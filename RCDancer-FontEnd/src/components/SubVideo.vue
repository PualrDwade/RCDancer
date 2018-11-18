<template>
  <v-container 
    v-show="subOpen" 
    class="mini-video-wrap pa-0" 
    style="left: 70rem; top: 0;">
    <v-layout row wrap>
      <v-flex xs12
        @mousedown="drag_begin($event)" 
      >
        <v-layout fill-height row>
          <v-flex 
            xs12 
            class="drag-bar grow-to-fill" 
            justify-end
            align-center>
            <v-btn icon style="cursor: move">
              <v-icon color="white">menu</v-icon>
            </v-btn>
            <v-btn icon ref="close-btn">
              <v-icon color="primary">close</v-icon>
            </v-btn>
          </v-flex>
        </v-layout>
      </v-flex>
      <v-flex 
        xs12 
        justify-center 
        class="grwo-to-fill"
        align-center>
        <video 
          class="mini-video" 
          preload="auto" 
          :src='`${videoSrc}#t=0.1`'
          controls>
        </video>
      </v-flex>
    </v-layout>
  </v-container>      
</template>

<script>
import { mapState, mapMutations} from 'vuex';

export default {
  props: ['videoSrc'],
  data () {
    return {
      miniWrap: null,
      videoEle: null,
      pos: { x:　0, y:  0 },
    }
  },
  computed: {
    ...mapState('training', ['subOpen'])
  },
  mounted () {
    this.miniWrap = document.querySelector('.mini-video-wrap');
    this.videoEle = document.querySelector('.mini-video');
    // this.capturePicture(this.videoEle);
  },
  methods: {
    capturePicture (ele) {
      if (!ele) return;
      ele.play().then(() => {
        ele.addEventListener('loadeddata', setTimeout(() => {
          ele.pause();
        }, 100))
      }).catch(err => {
        console.info(err);
      })
    },
    drag_begin (e) {
      //~ 拖动事件，存储元素的绝对位置
      this.pos.x = e.clientX - this.miniWrap.offsetLeft;
      this.pos.y = e.clientY - this.miniWrap.offsetTop;
      document.addEventListener('mousemove', this.drag_bar);
      document.addEventListener('mouseup', () => {
        document.removeEventListener('mousemove', this.drag_bar);
        document.onmouseup = null;
      });
    },
    drag_bar (e) {
      this.miniWrap.style.left = `${e.clientX - this.pos.x}px`; 
      this.miniWrap.style.top = `${e.clientY - this.pos.y}px`; 
    },
    resize_bar () {

    }
  }
}
</script>

<style lang="stylus">
.mini-video-wrap {
  z-index: 4;
  position: absolute;
  max-width: 32rem;
  .mini-video {
    width: 100%;
  }
  &:hover .drag-bar {
    opacity: 1;
  }
  .drag-bar {
    background: #aaa  ;
    height: 40px;
    opacity: 0;
    transition: opacity .2s ease;
  }
}
</style>
