<template>
  <!-- 用于控制循环次数以及播放速率的控制浮窗 -->
  <div class="float-control-ball white--text">
    <v-layout class="float-control-wrap fill-height" column justify-start>
      <v-flex xs12 class="float-control-count" align-center justify-center>
        <span>2</span>
      </v-flex>
      <v-flex xs12 class="float-control-divider" justify-center>
      </v-flex>
      <v-flex xs12 class="float-control-speed" justify-center align-center>
        <span>0.75x</span>
      </v-flex>
    </v-layout>
  </div> 
</template>

<script>
export default {
  data () {
    return {}
  }
}
</script>

<style lang="stylus" scoped>
.float-control-ball {
  position: relative;
  box-sizing: border-box;
  width: 5rem;
  height: 5rem;
  padding: .5rem;
  border: 3px solid $primaryColor;
  border-radius: 50%;
  background: $backColor;
  &::after {
    content: '';
    position: absolute;
    border-width: 10px;
    border-style: solid;
    border-color: $primaryColor transparent transparent;
    left: calc(50% - 10px);
    bottom: -1.8rem;
  }
  .float-control-wrap {
    // background: $primaryColor;
    .float-control-count {
      font-size: 25PX;
      line-height: 25PX;
      font-weight: bold;
    }
    .float-control-divider {
      padding: 0 5px;
      background-clip: content-box;
      background-color: $primaryColor;
      flex: 0 0 3px;
    }
    .float-control-speed {
      font-size: 15PX;
      line-height: 15PX;
      font-weight: bold;
    }
    .float-control-count, .float-control-speed {
      transition: color .3s ease;
      cursor: pointer;
      user-select: none;
      &:hover {
        color: $secondColor;
      }
    }
  }
}

</style>
