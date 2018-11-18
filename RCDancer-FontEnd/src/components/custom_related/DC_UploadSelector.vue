<template>
  <div class="upload-selector">
    <!-- 作为导航栏组件 -->
    <div class="upload-container">
        <uploader :single="single" @file-added="added" @file-removed="removed" @file-success="completed" :options="options" :class="upload">
          <uploader-unsupport></uploader-unsupport>
          <uploader-drop>
            <!-- <p>选择视频或者直接拖入文件</p> -->
            <uploader-btn ref="uploadBtn" :attrs="attrs" style="font-size:13px">
              <span class="primary--text">
                <v-icon small color="primary">info</v-icon>选择视频
              </span>
              或拖入文件
            </uploader-btn>
          </uploader-drop>
          <uploader-list></uploader-list>
        </uploader>
    </div>
  </div>
</template>


<script>
export default {
  props: {
    single: true
  },
  name: "uploadSelector",
  data: function() {
    return {
      options: {
        target: "http://120.79.206.32:5000/upload/",
        testChunks: false,
        singleFile: true
      },
      attrs: {
        accept: "video/mp4"
      },
      disabled: true
    };
  },
  mounted: function() {
    // 在组件挂载完毕之后设置样式，取消默认样式
    this.$refs.uploadBtn.$el.className = "btn btn-info";
  },
  computed: {
    upload: function() {
      // 使用计算属性计算class
      return {
        "uploader-example": true
      };
    }
  },
  methods: {
    // 可以直接使用rootFile, file, message, chunk，得到服务端的回调函数
    // message是服务端的返回状态
    completed: function(file) {
      // 上传完成的回调函数
      // 得到id和name
      const identifier = file.uniqueIdentifier;
      console.log("file is being handing");
      this.$http
        .get(
          `http://120.79.206.32:5000/uploadSuccess/?identifier=${identifier}`
        )
        .then(response => {
          // 完成文件处理，打印响应
          console.log("file handle completed!");
          console.log(response);
        })
        .catch(error => {
          console.log(error);
          // 设置按钮可点击
        });
    },
    // 取消上传的事件监听，要求服务器删除对应的所有片段
    removed: function(file) {
      console.log("remove");
      const identifier = file.uniqueIdentifier;
      this.$http
        .get(`http://120.79.206.32:5000/removeFile/?identifier=${identifier}`)
        .then(resonse => {
          console.log(resonse);
        })
        .catch(error => {
          console.log(error);
        });
      // this.$refs.uploadBtn.$el.className = 'btn btn-info'
    },
    // 文件添加之后，设置按钮不可点击
    added: function(file) {
      console.log("file added");
      // 添加了文件之后，按钮不可点击样式
      // this.$refs.uploadBtn.$el.className = 'btn btn-info disabled'
      console.log(file);
      console.log(this);
    }
  }
};
</script>

<style lang="stylus" scoped>
.upload-selector {
  flex-grow: 1;
  padding: 4px 16px;
  .upload-container {
    .uploader {
      .uploader-drop {
        text-align: center;
      }
      .btn {
        display: block;
        width: 100%;
        cursor: pointer;
      }
      .uploader-example {
        padding: 10px;
        /* margin: 40px auto 0; */
        font-size: 14px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
        .uploader-list {
          max-height: 440px;
          overflow: auto;
          overflow-x: hidden;
          overflow-y: auto;
        }
      }
    }
  }
}
.uploader-example .uploader-list {

}
</style>