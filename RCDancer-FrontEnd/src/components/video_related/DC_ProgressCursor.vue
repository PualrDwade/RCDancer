<template>
  <div class="progress-cursor" ref="cursor">
    <div class="cursor-ball"></div>
  </div>
</template>

<script>
export default {
  name: 'progress-cursor',
  data () {
    return {
      cursor: null,
      pos: { x: 0, y: 0 }
    }
  },
  methods: {
  }
}
</script>

<style lang="stylus">
.progress-cursor {
  user-select none;
  .cursor-ball {
    width: 15px;
    height: 15px;
    background: $primaryColor;
    border-radius: 50%;
    box-shadow: 1px 1px 10px rgba(0, 0, 0, .5);
    transition: all .2s ease;
    // &:hover {
    //   width: 18px;
    //   height: 18px;
    // }
    &::after {
      content: '';
      position: absolute;
      left: 50%;
      top: 100%;
      height: 10px;
      width: 1px;
      background: $secondColor;
      // z-index: 5;
    }
  }
}
</style>
