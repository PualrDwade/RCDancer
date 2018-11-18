import cv2
from PIL import Image
import numpy as np


class SimpleVideoHandle(object):
    """
    视频处理类，
    直接对用户上传的视频
    进行增强处理
    """

    @staticmethod
    def videoEnhance(file_dir, save_dir, file_name):
        """
        @param file_dir:文件所在路径
        @param save_file:文件保存位置
        @param file_name:文件名
        视频增强处理的静态方法
        """
        print("----------------开始读取视频处理并写入------------------\n")
        # 获得视频的格式
        videoCapture = cv2.VideoCapture(file_dir + '\\' + file_name)
        # 获得码率及尺寸
        fps = videoCapture.get(cv2.CAP_PROP_FPS)
        size = (int(videoCapture.get(cv2.CAP_PROP_FRAME_WIDTH)),
                int(videoCapture.get(cv2.CAP_PROP_FRAME_HEIGHT)))
        # 打印size
        print(size)
        # 指定写视频的格式, I420-avi, MJPG-mp4
        forcc = cv2.VideoWriter_fourcc(*'MJPG')
        # 指定写入文件的路径
        save_path = save_dir + '\\new' + file_name
        videoWriter = cv2.VideoWriter(save_path, -1, fps, size)
        # 开始读帧
        success, frame = videoCapture.read()
        # 读帧,frame是numpy数组
        while success:
            # 对帧进行处理
            frame = Image.fromarray(frame)
            # # 增强之后转化为opencv格式
            frame = cv2.cvtColor(np.asarray(frame), cv2.COLOR_RGB2GRAY)
            # cv2.imshow("OpenCV", frame)  # 进行显示
            # cv2.waitKey(int(fps)//2)  # 速率
            videoWriter.write(frame)  # 同时进行写入
            success, frame = videoCapture.read()  # 读取下一帧
        print("----------------读取视频处理并写入完成----------------\n")
