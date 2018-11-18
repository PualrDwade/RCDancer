<template>
  <v-container
    fluid
    grid-list-lg
    class="pa-1 section-list"
    >
    <v-layout row wrap>            
      <v-flex xs12 v-for="section in sections" :key="section.id">
        <v-hover>
          <v-card
            light
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 13 : 2}`"
            class="section-card"
            >
            <v-layout wrap>
              <!-- section-top -->
              <v-flex xs12>
                <v-layout>
                  <!-- section snap --> 
                  <v-flex xs6 class="ml-1" align-center>
                    <v-img
                      :src="section.sectionSnap"
                      width="150px"
                      height="100px">
                    </v-img>
                  </v-flex>
                  <!-- section list -->
                  <v-flex xs6>
                    <v-layout wrap class="ma-0">
                      <!-- section title -->
                      <v-flex xs12 class="pb-0">
                        <v-layout align-center>
                          <v-flex xs8>
                            <span
                              class="body-1 font-weight-black text-no-wrap text-truncate">
                              {{section.sectionName}}
                            </span>
                          </v-flex>
                          <v-flex xs4 class="text-xs-right" justify-end>
                            <v-tooltip bottom>
                              <!-- edit section -->
                              <v-dialog
                                light
                                persistent
                                max-width="370px"
                                slot="activator">
                                <v-btn 
                                  icon
                                  @click="toggle_dialog"
                                  slot="activator" 
                                  class="ma-0 mb-1" 
                                  small>
                                  <v-icon small>create</v-icon>
                                </v-btn>

                                <v-card>
                                  <v-card-title>
                                    <span class="title primary--text">
                                      <v-icon color="primary">create</v-icon>
                                      编辑区间
                                    </span>
                                  </v-card-title>

                                  <v-card-text>
                                    <v-container
                                      class="pa-1"
                                      grid-list-md                             
                                    >
                                      <v-layout wrap>
                                        <!-- secton name -->
                                        <v-flex xs12>
                                          <v-text-field 
                                            label="区间名" 
                                            required
                                            clearable
                                            hint="长度在五个字符以内最佳" 
                                            :value="section.sectionName">
                                          </v-text-field>
                                        </v-flex>
                                        <!-- section period -->
                                        <v-flex xs12>
                                          <v-layout>
                                            <v-flex>
                                              <v-select label="起始分" multiple></v-select>
                                              <v-select label="起始秒" multiple></v-select>
                                            </v-flex>
                                            <v-flex align-center>
                                              <span>to</span>
                                            </v-flex>
                                            <v-flex>
                                              <v-select label="终止分" multiple></v-select>
                                              <v-select label="终止秒" multiple></v-select>
                                            </v-flex>
                                          </v-layout>
                                        </v-flex>
                                        <!-- section tags -->
                                        <v-flex xs12>
                                          <v-combobox
                                            :value="section.tags"
                                            chips
                                            label="Tag管理"
                                            multiple
                                            dense
                                            placeholder="这里还没有tag~"
                                            deletable-chips
                                          >
                                          </v-combobox>
                                        </v-flex>
                                      </v-layout>
                                    </v-container>
                                  </v-card-text>
                                  <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn color="secondary" flat @click="toggle_dialog">取消</v-btn>
                                    <v-btn color="primary" outline @click="toggle_dialog">保存</v-btn>
                                  </v-card-actions>
                                </v-card>
                              </v-dialog>
                              <span>编辑片段</span>
                            </v-tooltip>
                            <v-tooltip bottom>
                              <v-btn 
                                icon 
                                slot="activator" 
                                class="ma-0 mb-1" 
                                small>
                                <v-icon 
                                  small 
                                  :color="section.isStared ? 'primary' : ''">
                                  favorite
                                </v-icon>
                              </v-btn>
                              <span>添加收藏</span>
                            </v-tooltip>
                          </v-flex>
                        </v-layout>
                      </v-flex>
                      <!-- section period -->
                      <v-flex xs12 class="py-0">
                        <v-btn color="primary" class="ma-0">
                          <span>{{section.startTime}}</span>
                          <span>&nbsp——&nbsp</span>
                          <span>{{section.endTime}}</span>
                        </v-btn>
                      </v-flex>
                      <!-- section options -->
                      <v-flex 
                        xs12 
                        justify-space-between 
                        align-center
                        class="py-0">
                        <v-progress-linear :value="section.progress"></v-progress-linear>
                        <v-tooltip bottom>
                          <v-btn 
                            icon 
                            small
                            class="ma-0 ml-1" 
                            slot="activator">
                            <v-icon small>delete_forever</v-icon>
                          </v-btn>
                          <span>删除片段</span>
                        </v-tooltip>
                      </v-flex>
                    </v-layout>
                  </v-flex>
                </v-layout>
              </v-flex>
              <!-- section-bottom -->
              <!-- section tag -->
              <v-flex 
                xs12 
                class="pt-0 wrap" 
                v-if="section.tags">
                <v-chip 
                  color="secondary" 
                  text-color="white" 
                  close
                  small
                  v-for="tag in section.tags" 
                  :key="tag">
                  <!-- <v-icon left>label</v-icon> -->
                  {{tag}}
                </v-chip>
              </v-flex>
            </v-layout>                
          </v-card>
        </v-hover>
      </v-flex>
    </v-layout>
  </v-container>    
</template>

<script>
import { mapMutations } from "vuex";
export default {
  props: {
    sections: Array
  },
  data() {
    return {};
  },
  methods: {
    ...mapMutations(["toggle_dialog"])
  }
};
</script>

<style scoped>
.section-list {
  max-height: 25rem;
  overflow-x: hidden;
  overflow-y: auto;
}
.section-card {
  border: 1px solid rgba(0, 0, 0, 0.2);
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
