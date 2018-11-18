<template>
<div class="fault-detect-page">
  <v-content id="full-screen-wrap" class="page-content">
    <div class="music-bar">
      <v-img :src="require('@/assets/img/bar.png')"></v-img>
    </div>
    <main-video 
      v-on:page-screen-mode="goPageScreen"
      :video-src="mainVideoSrc"
    >
    </main-video>
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
      mainVideoSrc: require('@/assets/video/webcam.mp4'),
      subVideoSrc: require('@/assets/video/lxq.mp4')
    }
  },
  components: {
    mainVideo,
    subVideo
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
  }
}
</script>

<style lang="stylus">
.music-bar {
  position: absolute;
  display: flex;
  justify-content: center;
  z-index 2;
  left: 0; 
  right: 0;
  top: 20px;
  margin: auto;
  .v-image {
    flex: 0 0 500px;
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
