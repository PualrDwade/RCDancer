<template>
  <div class="progress-bar mx-3">
    <!-- 包含区间设置游标的进度条 -->
    <div class="progress-bar-container">
      <progress-cursor 
        ref="leftCursor"
        @mousedown.native="drag_begin($event)"
        class="progress-cursor left-cursor">
      </progress-cursor>
      <v-progress-linear
        color="secondary"
        height="4"
        value="30"
        class="mb-0 mt-1"
      ></v-progress-linear>
      <progress-cursor 
        ref="rightCursor"
        @mousedown.native="drag_begin($event)"
        class="progress-cursor right-cursor">
      </progress-cursor>
    </div>
  </div>
</template>

<script>
import progressCursor from '@/components/video_related/DC_ProgressCursor'
import { mapState } from 'vuex'

export default {
  name: 'progress-bar',
  data () {
    return {
      pos: { x: 0, y: 0 },
      cursor: null,
      left_limit: -6.5,
      right_limit: 0,
      bar_length: 0,
      left_cursor: null,
      right_cursor: null,
      left_ratio: 0,
      right_ratio: 1,
    }
  },
  components: {
    progressCursor
  },
  watch: {
    isBigScreen (newVal) {
      this.change_limit();
      this.reset_cursor(); 
    }
  },
  computed: {
    ...mapState(['isBigScreen'])
  },
  mounted () {
    this.left_cursor = document.querySelector('.left-cursor');
    this.right_cursor = document.querySelector('.right-cursor');
    this.change_limit();
  },
  methods: {
    drag_begin (e) {
      this.cursor = e.currentTarget;
      this.pos.x = e.clientX - this.cursor.offsetLeft;
      // 设置拖拽监听事件
      document.addEventListener('mousemove', this.drag_cursor);
      document.addEventListener('mouseup', () => {
        document.removeEventListener('mousemove', this.drag_cursor);
        document.onmouseup = null;
        this.cursor = null;
      })
    },
    drag_cursor (e) {
      let left_val = e.clientX - this.pos.x;
      left_val = left_val < this.left_limit ? this.left_limit
                 : (left_val > this.right_limit ? this.right_limit : left_val);
      this.cursor.style.left = `${left_val}px`; 
      const ratio = ((left_val + 6.5) / this.bar_length).toFixed(2);
      if (this.cursor === this.right_cursor) {
        // 计算当前游标所占位置的比例
        this.right_ratio = ratio;
        console.log(this.right_ratio);
      } else {
        this.left_ratio = ratio;
        console.log(this.left_ratio);
      }
    },
    change_limit () {
      const bar = document.querySelector('.progress-bar')
      this.bar_length = Number((window.getComputedStyle(bar).width).slice(0, -2));
      this.right_limit = this.bar_length - 6.5;
      // console.log(this.left_limit, this.right_limit);
    },
    reset_cursor () {
      this.left_cursor.style.left = `${this.left_ratio * this.bar_length - 6.5}px`;
      this.right_cursor.style.left = `${this.right_ratio * this.bar_length - 6.5}px`;
      // console.log(this.left_ratio, `${this.left_ratio * this.bar_length - 6.5}px`);
      // console.log(this.right_ratio, `${this.right_ratio * this.bar_length - 6.5}px`);
    }
  }
};
</script>

<style lang="stylus" scoped>
.progress-bar {
  width: 100%;  
  cursor: pointer;
  box-sizing: content-box;
  // position: relative;
  .progress-bar-container {
    position: relative
    .progress-cursor {
      position: absolute;
      bottom: 100%;
      transform: scale(0.9);
      transition: all .2s ease;
      &:hover {
        transform: scale(1) translateY(-5px);
      }
    }
    // 6.5px为cursor小球的半径
    .left-cursor {
      left: -6.5px;
    }
    .right-cursor {
      left: calc(100% - 6.5px);
    }
  }
}
</style>
