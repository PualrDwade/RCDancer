<template>
  <v-container
    fluid
    grid-list-lg
    class="pa-1 advice-list"
    >
    <v-layout row wrap>
      <v-flex xs12  v-for="advice in adviceList" :key="advice.id">
        <v-hover>
          <v-card
            light
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 13 : 2}`"
            class="advice-card pa-1"
          >
            <v-layout row wrap>
              <!-- item -->
              <v-flex xs12>
                <v-layout row align-start>
                  <!-- left -->
                  <v-flex xs6>
                    <v-layout column>
                      <!-- tag and time -->
                      <v-flex class="pb-0">
                        <v-btn 
                          dark
                          color="primary"
                          small
                          class="mx-0 grow-to-fill" >
                          <span></span>{{advice.timePoint}} </span>
                        </v-btn>
                      </v-flex>
                      <!-- action snap -->
                      <v-flex class="pt-0">
                        <v-img :src="advice.snapUrl"></v-img>
                      </v-flex>
                    </v-layout>
                  </v-flex>
                  <!-- right -->
                  <v-flex xs6>
                    <v-layout column justify-space-between>
                      <!-- inaccuracy -->
                      <v-flex class="pl-0" wrap>
                        <div class="my-1 advice-title font-weight-black">
                          <div class="">
                            错误: 
                            <v-chip color="secondary" text-color="white" small>
                              {{advice.type}}
                            </v-chip>
                          </div>
                          <div class="primary--text">{{advice.mistakeToken}}</div>
                        </div>
                        <div class="advice-content font-weight-black">
                          <v-divider></v-divider>
                          <div class="">纠正:</div>
                          <div class="primary--text">{{advice.adviceToken}}</div> 
                        </div>
                      </v-flex>
                      <!-- actions -->
                      <v-flex class="pt-0" justify-end align-end>
                        <v-btn icon small class="ma-0">
                          <v-icon small>create</v-icon>
                        </v-btn>
                        <v-btn icon small class="ma-0">
                          <v-icon small>fullscreen</v-icon>
                        </v-btn>
                        <v-btn icon small class="ma-0">
                          <v-icon small>delete_forever</v-icon>
                        </v-btn>
                      </v-flex>
                    </v-layout>
                  </v-flex>
                </v-layout>
              </v-flex>
            </v-layout>
          </v-card>
        </v-hover>
      </v-flex>
    </v-layout>
  </v-container> 
</template>

<script>
export default {
  props: {
    adviceList: Array
  }
}
</script>

<style scoped>
.advice-list {
  max-height: 75vh;
  overflow-x: hidden;
  overflow-y: auto;
}
.advice-card {
  border: 1px solid rgba(0, 0, 0, .2);
}
::-webkit-scrollbar
{
	width: 8px;
	height: 8px;
	background-color: transparent;
}
/*定义滚动条轨道 内阴影+圆角*/
::-webkit-scrollbar-track
{
	background-color: transparent;
}
 
/*定义滑块 内阴影+圆角*/
::-webkit-scrollbar-thumb
{
  border-radius: 5px;
  background-color: rgba(255, 99, 71, .9);
}
</style>
