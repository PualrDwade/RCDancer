<template>
  <v-container fluid class="main-video-cpt">
    <v-layout 
      id="main-video-wrap"
      class="main-video-wrap"
      wrap 
      fill-height 
      justify-center>
      <v-flex 
        xs12 
        align-center 
        justify-center 
        class="grow-to-fill main-video-container">
        <video 
          class="main-video" 
          preload="auto"
          :src='`${videoSrc}#t=0.1`'
          type="video/mp4" 
          >
          您的当前版本浏览器并不支持播放视频
        </video>
        <!-- 视频悬浮控制球 -->
        <v-flex class="main-video-float-control" xs12 justify-center>
          <float-control></float-control>
        </v-flex>
        <!-- 视频底部选项栏 -->
        <v-flex class="main-video-bottom-control">
          <bottom-control 
            v-on:open-page-screen="goPageScreen"
            v-on:open-full-screen="goFullScreen">
          </bottom-control>
        </v-flex>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import floatControl from '@/components/video_related/DC_FloatingControl'
import bottomControl from '@/components/video_related/DC_BottomControl'
import { mapMutations } from 'vuex'
export default {
  props: ['videoSrc'],
  data () {
    return {
      videoEle: null
    }
  },
  mounted () {
    this.videoEle = document.querySelector('.main-video');
    this.set_video_ele(this.videoEle);
    // this.capturePicture(this.videoEle);
    // this.testAutoPlay(this.videoEle).then(info => {
    //   if(!info) {
    //     this.setAutoWhenClick();
    //   }
    // })
  },
  methods: {
    capturePicture (ele) {
      if (!ele) return;
      // 针对Chrome 66 autoplay blocker的hack
      ele.play().then(() => {
        ele.addEventListener('loadeddata', setTimeout(() => {
          ele.pause();
        }, 100))
      }).catch(err => {
        console.info(err);
      })
    },
    goFullScreen () {
      this.$emit('full-screen-mode');
      this.toggle_big_screen();
    },
    goPageScreen () {
      this.$emit('page-screen-mode');
      this.toggle_big_screen();
    },
    testAutoPlay (ele) {
      return new Promise(resolve => {
        const video = ele;
        let autoPlay;
        video.play().then(() => {
          // 支持自动播放
          autoPlay = true;
        }).catch(err => {
          autoPlay = false;
          console.log(err);
        }).finally(() => {
          resolve(autoPlay);
        })
      })
    },
    setAutoWhenClick () {
        const video = this.videoEle;
        console.log('playing!');
        video.play();
        function setAutoPlay () {
          // 设置自动播放为true
          video.autoplay = true;
          document.removeEventListener('click', setAutoPlay);
          document.removeEventListener('touchend', setAutoPlay);
        }
        document.addEventListener('click', setAutoPlay);
        document.addEventListener('touchend', setAutoPlay);
    },
    ...mapMutations(['toggle_big_screen']),
    ...mapMutations('training', ['set_video_ele']),
  },
  components: {
    floatControl,
    bottomControl
  }
}
</script>

<style lang="stylus">
.full-btn {
  position: absolute;
  left: 0;
}
.main-video-wrap {
  position: relative;
  .theme--light {
    .v-label {
      color: #fff !important;
    }
  }  
  .main-video-container {
    position: relative;
    flex: 0 0 83rem;
    overflow hidden;
    // max-width: 83rem;
    background: #383838;
    &:hover {
      .main-video-bottom-control {
        transform: translateY(0);
      }
    }
    .main-video {
      width: 100%;
      // height: 100%;
      // object-fit: cover;
    }
    .main-video-float-control {
      // z-index: 3;
      right: 1rem;
      top: 0;
      transform: translateY(-100% - 1px);
      transition: all .2s ease;
      position: absolute;
      &:hover {
        transform: translateX(0) translateY(1rem);
      }
    }
    .main-video-bottom-control {
      position: absolute;
      // z-index: 3;
      bottom: 0;
      left: 0;
      right: 0;
      transition all .3s ease;
      transform: translateY(100%);
    }
  }
}
</style>
