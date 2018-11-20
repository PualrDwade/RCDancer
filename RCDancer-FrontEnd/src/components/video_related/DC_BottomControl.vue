<template>
  <div class="bottom-control-bar">
    <v-layout 
      class="bottom-control-wrap" 
      wrap
      fill-height>
      <!-- 视频进度条 -->
      <v-flex xs12 class="progress-bar-wrap" justify-end align-center>
        <progress-bar></progress-bar>
      </v-flex>
      <!-- 视频下方选项控制条 -->
      <v-flex xs12 class="options-bar-wrap" align-center>
        <v-layout class="options-bar">
          <!-- 视频播放开关 -->
          <v-flex class="options-item align-left">
            <v-btn v-if="!isPlaying" icon class="theme--dark" @click="play_video">
              <v-icon>play_arrow</v-icon>
            </v-btn>
            <v-btn v-else icon class="theme--dark" @click="pause_video">
              <v-icon>pause</v-icon>
            </v-btn>
          </v-flex>
          <!-- 视频进度与长度 -->
          <v-flex class="options-item subheading" align-center>
            <div class="primary--text">01:12 / 04:32</div>
          </v-flex>
          <!-- 音量控制条 -->
          <v-flex class="options-item">
            <v-btn icon class="theme--dark">
              <v-icon>volume_up</v-icon>
            </v-btn>
          </v-flex>
          <!-- 小视频悬浮窗开关 -->
          <v-flex class="options-item" align-center>
            <v-switch
              class="ma-0"
              hide-details
              v-model="subOn"
              :label="`悬浮窗${subOn ? '开' : '关'}`"
              ripple
            ></v-switch>
          </v-flex>
          <!-- 视频镜像开关 -->
          <v-flex class="options-item pl-2" align-center>
            <v-switch
              class="ma-0"
              hide-details
              v-model="isFlip"
              :label="`镜像${isFlip ? '开' : '关'}`"
              ripple
            ></v-switch>
          </v-flex>
          <v-flex class="options-spacer"></v-flex>
          <!-- 视频其他选项开关 -->
          <v-flex class="options-item">
            <v-tooltip top>
              <v-btn icon class="theme--dark" slot="activator">
                <v-icon>settings</v-icon>
              </v-btn>
              <span>视频选项</span>
            </v-tooltip>
          </v-flex>
          <!-- 网页开关 -->
          <v-flex class="options-item" @click="$emit('open-page-screen')">
            <v-tooltip top>
              <v-btn icon class="theme--dark" slot="activator">
                <v-icon>view_array</v-icon>
              </v-btn>
              <span>网页全屏</span>
            </v-tooltip>
          </v-flex>
          <!-- 全屏开关 -->
          <!-- <v-flex class="options-item" @click="$emit('open-full-screen')">
            <v-btn icon class="theme--dark">
              <v-icon>fullscreen</v-icon>
            </v-btn>
          </v-flex> -->
        </v-layout>
      </v-flex>
    </v-layout>
  </div>
</template>

<script>
import progressBar from '@/components/video_related/DC_ProgressBar.vue'
import { mapState, mapMutations } from 'vuex'

export default {
  data () {
    return {
      isPlaying: false,
      isFlip: false,
      subOn: true,
    }
  },
  watch: {
    isFlip () {
      this.flip_video();
    },
    subOn (val) {
      this.toggle_sub(val);
    }
  },
  computed: {
    ...mapState('training', ['video'])
  },
  methods: {
    play_video () {
      this.video.videoEle.play();
      this.isPlaying = true;
    },
    pause_video () {
      this.video.videoEle.pause();
      this.isPlaying = false;
      // TODO change video status
    },
    // 镜像翻转
    flip_video () {
      this.video.videoEle.classList.toggle('flip');
    },
    toggle_sub (val) {
      if (val) {
        this.toggle_sub_video(true);
      } else {
        this.toggle_sub_video(false);
      }
    },
    ...mapMutations('training', ['toggle_sub_video'])
  },
  components: {
    progressBar
  }
}
</script>

<style lang="stylus" scoped>
.bottom-control-bar {
  width: 100%;
  background-color: rgba(0, 0, 0, .6);
  user-select: none;
  .bottom-control-wrap {
    .progress-bar-wrap {

    }
    .options-bar-wrap {
      .options-bar {
        .options-item {
          flex: 0 1 auto;
        }
      }
    }
  }
}
.options-spacer {
  flex-grow: 1;
}
</style>
