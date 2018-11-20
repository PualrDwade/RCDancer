<template>
  <div class="traning-page">
    <v-content id="full-screen-wrap" class="page-content">
      <main-video 
        :video-src="mainVideoSrc"
        v-on:page-screen-mode="goPageScreen"
        v-on:full-screen-mode="goFullScreen"></main-video>
      <sub-video :video-src="subVideoSrc"></sub-video>
    </v-content>
  </div>
</template>

<script>
import mainVideo from '@/components/MainVideo'
import subVideo from '@/components/SubVideo'

export default {
  data () {
    return {
      mainVideoSrc: require('@/assets/video/lxq.mp4'),
      subVideoSrc: require('@/assets/video/webcam.mp4')
    }
  },
  components: {
    mainVideo,
    subVideo
  },
  mounted () {

  },
  methods: {
    goPageScreen () {
      const ele = document.querySelector('#full-screen-wrap');
      ele.classList.toggle('page-screen-mode'); 
      document.body.classList.add('overflow-x-hidden');
      // 屏幕分辨率的高： window.screen.height
      // 屏幕分辨率的宽： window.screen.width
      // 屏幕可用工作区高度： window.screen.availHeight
      // 屏幕可用工作区宽度： window.screen.availWidth
    },
    //~ 通过控制父级容器的全屏来伪造视频的全屏
    //~ 通过z-index控制视频控制条等组件的层级
    goFullScreen () {
      const ele = document.querySelector('#full-screen-wrap');
      const fullscreenElement = document.fullscreenElement || document.mozFullScreenElement ||
          document.webkitFullscreenElement || document.msFullscreenElement;
      if(fullscreenElement) {
        this.exitFullScreen();
      } else {
        //~ 加载全屏元素
        this.launchToFullScreen(ele);
      }
    },
    launchToFullScreen (element) {
      const ele = document.querySelector('#full-screen-wrap');
      if (element.requestFullscreen) {
        element.requestFullscreen();
      } else if (element.mozRequestFullScreen) {
        element.mozRequestFullScreen();
      } else if (element.webkitRequestFullscreen) {
        element.webkitRequestFullscreen();
      } else if (element.msRequestFullscreen) {
        element.msRequestFullscreen();
      }   
      ele.classList.add('full-screen-mode'); 
      window.onresize = () => {
        const isFull = document.fullscreenEnabled || window.fullScreen || 
                       document.webkitIsFullScreen || document.msFullscreenEnabled;             
        if (!Boolean(isFull)) {
          this.exitFullScreen();
        }
      }
    },
    exitFullScreen () {
      const ele = document.querySelector('#full-screen-wrap');      
      if (document.exitFullscreen) {
        document.exitFullscreen();
      } else if (document.mozCancelFullScreen) {
        document.mozCancelFullScreen();
      } else if (document.webkitExitFullscreen) {
        document.webkitExitFullscreen();
      }  
      ele.classList.remove('full-screen-mode');
      window.onresize = null;
    }
  }
}
</script>

<style lang="stylus">
.page-content {
  position: relative;
}
// ~ 全屏与宽屏模式
.full-screen-mode, .page-screen-mode {
  padding: 0 !important;
  .main-video-cpt {
    padding: 0 !important;
  }
}
.full-screen-mode {
  .main-video-cpt {
    height: 100vh;
    .main-video-container {
      max-width: none;
      height 100%;
    }
  }
}
.page-screen-mode {
  .main-video-cpt {
    height: 100vh;
    .main-video-container {
      max-width: none;
      height 100%;
      flex: 1 0 auto;
      .main-video {
        height: 100%;
        width: auto;
        object-fit: cover;
      }
    }
  }
}
</style>
