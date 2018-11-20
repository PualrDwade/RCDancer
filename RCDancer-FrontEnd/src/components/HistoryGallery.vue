<template>
  <div class="history-gallery">
    <subheader menu-name="历史练习记录"></subheader>
    <v-container grid-list-lg class="pt-0">
      <v-layout class="history-card-list" row wrap>
        <v-flex 
          v-for="history in testData" 
          :key="history.id"
          xs6 md4 lg3 
          class="history-card-container">
          <v-card class="history-card" light>
            <v-img :src="history.img" style="width: 100%"></v-img>
            <v-card-title primary-title class="py-1">
              <div>
                <div class="subheading">{{history.name}}</div>
                <span class="grey--text">创建时间：{{history.createTime}}</span>
              </div>
            </v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn flat>管理</v-btn>
              <v-btn outline color="primary">进入</v-btn>
            </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import subheader from '@/components/custom_related/DC_Subheader'
export default {
  name: 'history-gallery',
  data () {
    return {
      img: require('@/assets/img/section.jpg'),
      testData: [
        {
          id: '1',
          name: '流星✨群',
          createTime: '2018.11.01',
          img: require('@/assets/img/section.jpg')
        },
        {
          id: '2',
          name: '火星✨群',
          createTime: '2018.11.06',
          img: require('@/assets/img/section2.jpg')
        },
        {
          id: '3',
          name: '水星✨群',
          createTime: '2018.11.10',
          img: require('@/assets/img/section3.jpg')
        },
        {
          id: '4',
          name: '土星✨群',
          createTime: '2018.11.11',
          img: require('@/assets/img/section.jpg')
        },
      ]
    }
  },
  components: {
    subheader
  }
}
</script>

<style lang="stylus" scoped>
.history-gallery {
  flex: 1 0 auto;
  .history-card {
    flex-grow: 1;
  }
}
</style>
