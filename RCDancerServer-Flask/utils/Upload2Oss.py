import oss2  # oss2包 连接阿里云OSS的工具
import sys

auth = oss2.Auth('LTAIaSTKmKqJCAPz', 'Wpk6fxU2XpeBDmU8E6ZgHEgc7RMXFB')  # 详见文档
endpoint = 'http://oss-cn-beijing.aliyuncs.com'  # 地址
bucket = oss2.Bucket(auth, endpoint, 'rcdancer')  # 项目名称


# 当无法确定待上传的数据长度时，total_bytes的值为None。
def percentage(consumed_bytes, total_bytes):
    if total_bytes:
        rate = int(100 * (float(consumed_bytes) / float(total_bytes)))
        print('\r{0}% '.format(rate), end='')
        sys.stdout.flush()


# 断线续传上传
def post_jpg(upload_filename, filepath):
    # 进行上传
    # 当文件长度大于或等于可选参数multipart_threshold（默认值为10MB）时，会使用分片上传。如未使用参数store指定目录，则会在HOME目录下建立.py-oss-upload目录来保存断点信息。
    result = oss2.resumable_upload(bucket, upload_filename, filepath,
                                   progress_callback=percentage)
    # 括号内 左边是上传后的文件名，右边是当前系统的文件地址
    print('finish{}'.format(result))
    jpg_url = bucket.sign_url('GET', upload_filename, 60)  # 阿里返回一个关于upload_filename的url地址 60是链接60秒有效
    print(jpg_url)
    return jpg_url


if __name__ == '__main__':
    post_jpg('test.mp4', '../static/video/test.mp4')
