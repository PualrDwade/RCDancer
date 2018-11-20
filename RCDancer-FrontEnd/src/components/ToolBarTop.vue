<template>
    <v-toolbar
        v-if="!isBigScreen"
        app
        fixed
        clipped-left clipped-right
        dark
        color="primary"
    >
        <!-- side icon -->
        <v-toolbar-side-icon class="hidden-md-and-up" @click.stop="toggle_left_menu"></v-toolbar-side-icon>
        <!-- project logo -->
        <v-avatar @click="$router.push('index')">
          <v-img :src="logoUrl"></v-img>
        </v-avatar>
        <!-- <router-link tag="v-avatar" v-ripple to="/index">
          <v-img :src="logoUrl"></v-img>
        </router-link> -->

        <!-- project title -->
        <v-toolbar-title class="headline hidden-md-and-down">RC.Dancer</v-toolbar-title>
        <!-- window options -->
        <v-toolbar-items class="hidden-sm-and-down">
          <v-layout row align-center justify-center class="px-2">
            <v-flex>
              <v-btn flat small class="font-weight-black">隐藏窗口</v-btn>
            </v-flex>
            <v-flex>
              <v-btn flat small class="font-weight-black">全屏显示</v-btn>
            </v-flex>
            <v-flex>
              <v-btn flat class="font-weight-bold">新练习</v-btn>
            </v-flex>
          </v-layout>
        </v-toolbar-items>
        <v-spacer></v-spacer>
        <!-- search bar -->
        <v-layout row align-center class="search-bar mx-2">
          <v-flex>
            <v-text-field
                placeholder="搜索"
                single-line
                color="#fff"
                prepend-inner-icon="search"
                :append-icon-cb="search"
                clearable
            ></v-text-field>
          </v-flex>
        </v-layout>
        <!-- function items -->
        <v-toolbar-items>
          <!-- user avatar toggle -->
          <v-layout align-center class="pa-1">
            <v-flex>
              <v-menu
                offset-y
                transition="scale-transition"
                :nudge-left="100"
                :close-on-content-click="false"
              >
                <!-- <div v-ripple class="avatar" slot="activator"></div> -->
                <v-avatar slot="activator">
                  <v-img :src="userInfo.userAvatar"></v-img>
                </v-avatar>

                <v-card light class="my-1 user-menu">
                  <v-list>
                    <!-- user avatar -->
                    <v-list-tile avatar>
                      <v-list-tile-avatar>
                        <v-img :src="userInfo.userAvatar"></v-img>
                      </v-list-tile-avatar>

                      <v-list-tile-content>
                        <v-list-tile-title>{{ userInfo.username }}</v-list-tile-title>
                        <v-list-tile-sub-title class="text-no-wrap text-truncate">{{ userInfo.userSign }}</v-list-tile-sub-title>
                      </v-list-tile-content>

                      <v-list-tile-action>
                        <v-btn small outline icon color="primary">
                          <v-icon>done</v-icon>
                        </v-btn>
                      </v-list-tile-action>
                    </v-list-tile>
                  </v-list>

                  <v-divider></v-divider>
                  <!-- user options -->
                  <v-list>
                    <v-list-tile v-for="item in userOptions" :key="item.text" @click="">
                      <v-list-tile-avatar>
                        <v-icon medium color="primary">{{item.icon}}</v-icon>
                      </v-list-tile-avatar>
                      <v-list-tile-title>
                        <span>{{item.text}}</span>
                      </v-list-tile-title>
                      <v-spacer></v-spacer>
                      <v-icon color="primary">chevron_right</v-icon>
                    </v-list-tile>
                  </v-list>
                  <!-- card actions -->
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn class="" flat @click="">取消</v-btn>
                    <v-btn outline color="primary" class="" flat @click="">注销</v-btn>
                  </v-card-actions>
                </v-card>
              </v-menu>
            </v-flex>
          </v-layout>
          <!-- other options -->
          <v-layout row align-center justify-center>
            <v-flex v-for="item in rightSide" :key="item.text">
              <v-tooltip bottom>
                <v-btn slot="activator" icon>
                  <v-icon >{{item.icon}}</v-icon>
                </v-btn>
                <span>{{item.text}}</span>
              </v-tooltip>
            </v-flex>
          </v-layout>
        </v-toolbar-items>
    </v-toolbar>
</template>

<script>
import { mapState, mapMutations } from "vuex";
export default {
  data() {
    return {
      logoUrl: require("../assets/img/logo.png"),
      userInfo: {
        username: "Mirr",
        userSign: "Hello Rc.Dancer lorem",
        userAvatar: require("../assets/img/avatar.jpg")
      },
      rightSide: [
        {
          icon: "star",
          text: "收藏夹"
        },
        {
          icon: "history",
          text: "浏览历史"
        },
        {
          icon: "notifications",
          text: "我的消息"
        },
        // {
        //   icon: "camera",
        //   text: "换肤"
        // },
        {
          icon: 'brightness_3',
          text: "夜间模式"
        },
        {
          icon: 'wb_sunny',
          text: "日间模式"
        }
      ],
      userOptions: [
        {
          icon: "style",
          text: "个人中心"
        },
        {
          icon: "videocam",
          text: "视频管理"
        },
        {
          icon: "slow_motion_video",
          text: "片段管理"
        }
      ]
    };
  },
  computed: {
    ...mapState(["left_menu", "right_menu", "dialogOpen", "isBigScreen"])
  },
  mounted() {
    //~ 添加全局鼠标事件，当鼠标移动到浏览器边缘时，弹出对应方向菜单
    // TODO 搞个view
    document.addEventListener("mousemove", e =>
      this.debounce(this.mouse_toggle_menu, 30)(e)
    );
    // console.log(this.isBigScreen);
  },
  methods: {
    mouse_toggle_menu(e) {
      if (this.dialogOpen) return;
      if (e.clientX === 0) {
        this.open_left_menu();
      } else if (e.clientX > 500) {
        this.close_left_menu();
        if (e.clientX > window.innerWidth - 5) {
          this.open_right_menu();
        } else if (e.clientX < window.innerWidth - 500) {
          this.close_right_menu();
        }
      }
    },
    search(val) {
      // TODO: get input value
      console.log(val);
    },
    // ~ 除颤函数
    debounce(func, wait = 20, immediate = true) {
      let timeout;
      return function() {
        const [args, context] = [arguments, this];
        const later = () => {
          timeout = null;
          if (!immediate) {
            func.apply(context, args);
          }
        };
        const callNow = immediate && !timeout;
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
        if (callNow) {
          func.apply(context, args);
        }
      };
    },
    ...mapMutations([
        "toggle_left_menu", 
        "open_left_menu", 
        "close_left_menu",
        "open_right_menu", 
        "close_right_menu"
      ])
  }
};
</script>

<style scoped>
.search-bar {
  max-width: 13em;
}
.search-bar.bar-open {
  max-width: 15em;
}
.user-menu {
  max-width: 20em;
}
</style>
