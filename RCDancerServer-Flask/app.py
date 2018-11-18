# -*- coding: utf-8 -*-
import os
from flask import Flask, request
from flask import jsonify
from flask_cors import CORS
# from utils import Video
import time



# author:xuanxuan 
# 2018-10-24

ALLOWED_EXTENSIONS = set(['mp4'])

app = Flask(__name__)
app.config['MAX_CONTENT_LENGTH'] = 1000 * 1024 * 1024
app.debug = True
# 使用Flask_cors库解决跨域请求问题
CORS(app, supports_credentials=True)
# 绑定对应的域名
domain = 'http://120.79.206.32'


def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1] in ALLOWED_EXTENSIONS


@app.route('/upload/', methods=['POST'])
def upload_file():
    """
    文件分片上传的处理函数
    """
    # 得到文件
    file = request.files['file']
    if file and allowed_file(file.filename):
        chunkNumber = request.form.get('chunkNumber')  # 得到编号
        identifier = request.form.get('identifier')  # 得到id
        # 设置文件的名字
        filename = '%s%s%s' % (identifier, chunkNumber, '.mp4')
        basepath = os.path.dirname(__file__)  # 当前文件所在路径
        upload_path = os.path.join(basepath, 'static/video',
                                   filename)  # 注意：没有的文件夹一定要先创建，不然会提示没有该路径
        file.save(upload_path)
        return jsonify({"message": "ok"})
    return jsonify({"message": "error"})


@app.route('/uploadSuccess/', methods=['GET'])
def upload_success():
    """
    所有分片均上传完后被调用
    """
    # 等待1S时间再执行
    task = request.args.get('identifier')
    chunk = 1  # 分片序号
    with open('./static/video/%s%s' % (task, '.mp4'), 'wb') as target_file:  # 创建新文件
        while True:
            try:
                filename = './static/video/%s%d%s' % (task, chunk, '.mp4')
                # 按序打开每个分片
                source_file = open(filename, 'rb')
                # 读取分片内容写入新文件
                target_file.write(source_file.read())
                source_file.close()
                os.remove(filename)
                chunk += 1
            except IOError:
                # 跳出循环
                break
    # # 对视频进行预处理
    # video = Video.SimpleVideoHandle()
    # video.videoEnhance(
    #     './static/video', './static/video/handle', "%s%s" % (task, '.mp4'))
    # # 定义数据字典，结构化返回的data对象

    data = {
        "message": "ok",
        "chunkSize": chunk,
        "videoUrl": "%s%s%s%s" % (domain, "/static/video/", task, '.mp4')
    }
    return jsonify(data)


@app.route('/removeFile/', methods=['GET'])
def remove_file():
    """
    文件取消上传之后调用，服务器移除所有分片文件
    """
    # 给一个延迟，防止服务器出现错误导致出现没有删除成功的文件
    time.sleep(2)
    task = request.args.get('identifier')
    chunk = 1
    while True:
        try:
            # 得到片段名
            filename = './static/video/%s%d%s' % (task, chunk, '.mp4')
            # 移除文件
            os.remove(filename)
            chunk += 1
        except IOError:
            # 跳出循环
            break
    print("clean ok")
    return jsonify({"message": "ok"})


if __name__ == '__main__':
    # run the flask app
    app.run()
