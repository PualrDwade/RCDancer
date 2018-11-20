<template>
    <v-navigation-drawer 
    :value="leftMenu" 
    app 
    temporary
    width="350" 
    >
        <!-- options list -->
        <v-divider></v-divider>
        <v-list class="pt-0" dense>
          <!-- mode list -->
          <v-list class="dense">
            <dc-subheader menu-name="模式选择"></dc-subheader>
            <v-list-tile class="pb-2">
              <v-layout>
                <v-flex class="px-1">
                  <v-list-tile-action style="flex: 1 0 auto;">
                    <v-btn 
                      block 
                      @click="toTraining"
                      :color="train ? 'primary' : 'grey lighten-1'">
                      <span class="pr-2">
                        <v-icon>alarm_on</v-icon>
                        练习模式
                      </span>
                    </v-btn>
                  </v-list-tile-action>
                </v-flex>
                <v-flex class="px-1">
                  <v-list-tile-action style="flex: 1 0 auto;">
                    <v-btn 
                      block
                      @click="toFaultDetect"
                      :color="!train ? 'primary' : 'grey lighten-1'">
                      <span class="pr-2">
                        <v-icon>visibility</v-icon>
                      </span>                      
                      纠错模式
                    </v-btn>
                  </v-list-tile-action>
                </v-flex>
              </v-layout>
            </v-list-tile>
            <v-list-tile @click="">
              <v-list-tile-action>
                <v-icon>settings</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  模式设置
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
            <v-list-tile @click="">
              <v-list-tile-action>
                <v-icon>close</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  退出模式
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list>
          <!-- new section -->
          <v-divider></v-divider>
          <v-list>
            <dc-subheader menu-name="区间管理"></dc-subheader>
            <!-- new section -->
            <v-list-tile @click="">
              <v-list-tile-action>
                <v-icon>add</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  新增区间
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
            <!-- sections management -->
            <v-list-tile @click="">
              <v-list-tile-action>
                <v-icon>settings</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  区间设置
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list>
          <!-- section list -->
          <dc-subheader menu-name="区间列表"></dc-subheader>
          <!-- section list item -->
          <section-list :sections="testSections"></section-list>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
import { mapState, mapMutations } from "vuex"
import dcSubheader from '@/components/custom_related/DC_Subheader'
import sectionList from '@/components/sidebar_related/DC_SectionList'
export default {
  data () {
    return {
      train: false,
      testSections: [
        {
          id: 1,
          sectionSnap: require('@/assets/img/section.jpg'),
          sectionName: '标志性动作之大鹏展翅',
          isStared: true,
          startTime: '00:27',
          endTime: '00:33',
          progress: 20,
          tags: ['难度A', '注意节奏', '手臂伸直']
        },
        {
          id: 2,
          sectionSnap: require('@/assets/img/section2.jpg'),
          sectionName: '挑衅动作',
          isStared: false,
          startTime: '01:45',
          endTime: '01:51',
          progress: 80,
          tags: ['难度S+', '眼神要真诚']
        },
        {
          id: 3,
          sectionSnap: require('@/assets/img/section3.jpg'),
          sectionName: '伸展运动',
          isStared: true,
          startTime: '02:27',
          endTime: '02:44',
          progress: 46
        },
      ]
    };
  },
  components: {
    sectionList,
    dcSubheader
  },
  computed: mapState(["leftMenu"]),
  methods: {
    ...mapMutations([
      'close_left_menu'
    ]),
    toTraining () {
      this.$router.push('/train');
      this.train = true;
    },
    toFaultDetect () {
      this.$router.push('/faultDetect');
      this.train = false;
    }
  }
};
</script>

<style scoped>
.on {

}
</style>
