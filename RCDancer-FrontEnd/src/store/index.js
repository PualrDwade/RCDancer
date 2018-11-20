import Vuex from 'vuex'
import Vue from 'vue'
import training from '@/store/modules/training';

Vue.use(Vuex);

const state = {
  leftMenu: false,
  rightMenu: false,
  dialogOpen: false,
  isBigScreen: false
}
const getter = {
  left_menu () {
    return this.state.leftMenu;
  },
  right_menu () {
    return this.state.rightMenu;
  }
}
const mutations = {
  toggle_big_screen: (state) => {
    state.isBigScreen = !state.isBigScreen;
  },
  toggle_left_menu (state) {
    state.leftMenu = !state.leftMenu;
  },
  open_left_menu (state) {
    state.leftMenu = true;
  },
  close_left_menu (state) {
    state.leftMenu = false;
  },
  toggle_right_menu (state) {
    state.rightMenu = !state.rightMenu;
  },
  open_right_menu (state) {
    state.rightMenu = true;
  },
  close_right_menu (state) {
    state.rightMenu = false;
  },
  toggle_dialog (state) {
    state.dialogOpen = !state.dialogOpen;
  },
  // 显示提示条
  show_snack (state, info) {
    //
  },
  // 显示加载图标
  show_spinner (state) {
    //
  }
}
export default new Vuex.Store({
  modules: {
    training
  },
  state,
  getter,
  mutations
})
