<template>
  <div>
    <v-app light class="d-block">
      <!-- toolbar -->
      <tool-bar-top></tool-bar-top>
      <!-- left sidebar -->
      <router-view name="leftMenu"></router-view>
      <!-- right sidebar -->
      <router-view name="rightMenu"></router-view>
      <!-- main content -->
      <router-view></router-view>
    </v-app>
  </div>
</template>

<script>
import toolBarTop from '@/components/ToolBarTop'

export default {
  data () {
    return {}
  },
  mounted () {

  },
  components: {
    toolBarTop,
  }
}
</script>

<style scoped>
</style>
