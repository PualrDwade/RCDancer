<template>
  <v-app dark class="d-block">
    <tool-bar-top></tool-bar-top>
    <left-menu></left-menu>
    <right-menu></right-menu>
    <v-content>
      <v-container fluid>
        <v-layout fill-height>
          <v-flex xs12 justify-center align-center>
            <video src="@/assets/video/lxq.mp4" controls style="width: 80%;"></video>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import leftMenu from '@/components/LeftSideMenu'
import rightMenu from '@/components/RightSideMenu'
import toolBarTop from '@/components/ToolBarTop'

export default {
  data () {
    return {}
  },
  components: {
    leftMenu,
    rightMenu,
    toolBarTop,
  }
}
</script>

<style scoped>

</style>
