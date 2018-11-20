<template>
  <v-navigation-drawer    
    :value="rightMenu" 
    app 
    right 
    temporary
    width="350">
    <v-tabs
      dark
      grow
      color="primary"
    > 
      <v-tabs-slider style="height: 5px" color="secondary"></v-tabs-slider>
      <!-- adivice list [tab] -->
      <v-tab href="#advice-list">
        建议清单
      </v-tab>
      <!-- detail list [tab] -->
      <v-tab href="#detail-list">
        详细记录 
      </v-tab>

      <v-tab-item value="advice-list">
        <dc-subheader menu-name="错误列表"></dc-subheader>
        <advice-list :advice-list="testData"></advice-list>        
      </v-tab-item>

      <v-tab-item value="detail-list">
        <v-card>
          <v-img
            src="https://cdn.vuetifyjs.com/images/cards/desert.jpg"
            aspect-ratio="2.75"
          ></v-img>

          <v-card-title primary-title>
            <div>
              <h3 class="headline mb-0">RC.Dancer Detail List</h3>
              <div>Located two hours south of Sydney in the <br>Southern Highlands of New South Wales, ...</div>
            </div>
          </v-card-title>

          <v-card-actions>
            <v-btn flat color="orange">Share</v-btn>
            <v-btn flat color="orange">Explore</v-btn>
          </v-card-actions>
        </v-card>
      </v-tab-item>
    </v-tabs>
    <dc-subheader menu-name="上传录像"></dc-subheader>
    <v-layout>
      <v-flex align-center>
        <record-upload></record-upload>
      </v-flex>
    </v-layout>
  </v-navigation-drawer>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import adviceList from '@/components/sidebar_related/DC_AdiviceList'
import dcSubheader from '@/components/custom_related/DC_Subheader'
import recordUpload from '@/components/custom_related/DC_RecordUpload'

export default {
  data () {
    return {
      testUrl: require('@/assets/img/section2.jpg'),
      testData: [
        {
          id: 1,
          type: '动作',
          timePoint: '00:21',
          snapUrl: require('@/assets/img/section2.jpg'),
          mistakeToken: '肢体动作——头部方向不正确',
          adviceToken: '头部方向为斜上方请注意向斜上方看'
        },
        {
          id: 2,
          type: '细节',
          timePoint: '00:56',
          snapUrl: require('@/assets/img/section2.jpg'),
          mistakeToken: '肢体细节——身体重心不符',
          adviceToken: '身体重心应降低、可适当后仰'
        },
        {
          id: 3,
          type: '动作',
          timePoint: '01:43',
          snapUrl: require('@/assets/img/section2.jpg'),
          mistakeToken: '肢体动作——左手臂、右手臂方向错误',
          adviceToken: '两臂方向相反'
        },
        {
          id: 4,
          type: '节拍',
          timePoint: '02:21',
          snapUrl: require('@/assets/img/section2.jpg'),
          mistakeToken: '节拍错误——动作过于提前',
          adviceToken: '请注意节拍，稍晚些做动作'
        },
      ]
    }
  },
  components: {
    dcSubheader,
    adviceList,
    recordUpload
  },
  computed: {
    ...mapState(['rightMenu'])
  },
  methods: {
    ...mapMutations(['close_right_menu'])
  }
}
</script>

<style>
</style>
