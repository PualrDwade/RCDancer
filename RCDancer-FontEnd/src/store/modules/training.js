// 训练页面的状态管理
const STATUS = {
  LOADING: 'LOADING',
  FINISHED: 'FINISHED',
  PAUSE: 'PAUSE',
  PLAYING: 'PLAYING',
  END: 'END',
  ERROR: 'ERROR'
}
const SPPED_ARRANGE = [1, 1.25, 0.75, 0.5, 0.3];

const state = {
  video: {
    id: '01', // 视频id（hash？）
    src: null, // 视频源
    type: null, // 视频类型
    videoEle: null, // 视频dom元素
    status: STATUS.LOADING, // 视频状态
    duration: 0, // 视频长度
    poster: null, // 封面
    currentTime: 0 // 当前播放进度
  },
  sectionList: [], // 当前视频自定义片段列表
  sectionSelected: {
    startTime: 0, // 区间开始游标点
    endTime: 0 // 区间终止游标点
  },
  speed: SPPED_ARRANGE[0], // 视频倍速
  loop: -1, // 循环次数（-1）即无限循环
  // TODO: 是否默认循环
  // isLoop: false
  subOpen: true, // 小悬浮窗
  isMirror: false // 镜像
}
const getters = {
  
}
const actions = {
  // 获取视频信息
  getVideo ({ commit }, id) {
    new Promise((resolve, reject) => {
      resolve('sample data here');
    }).then(video => {
      commit('get_video', { video });
    })
  },
  // 视频的训练片段CRUD操作
  addNewSection ({ commit }, section) {
    new Promise((resolve, reject) => {
      resolve('sample data here');
    }).then(info => {
      commit('add_section', { section });
    })
  },
  deleteSection ({ commit }, id) {
    new Promise((resolve, reject) => {
      resolve('sample data here');
    }).then(info => {
      commit('delete_section', { id });
    })
  },
  getSectionList ({ commit }, id) {
    new Promise((resolve, reject) => {
      // 请求sectionList
      resolve('sample data here');
    }).then(data => {
      commit('get_section_list', { data });
    }).catch(err => {
      throw new Error(err);
    })
  }
}

const mutations = {
  // TODO: 所有validation都在组件中进行
  get_video (state, { video }) {
    // 
  },
  get_section_list (state, { data }) {
    state.sectionList = data
  },
  add_section (state, { section }) {
    state.sectionList.push(section);
    // TODO: 提示添加成功
  },
  delete_section (state, { id }) {
    state.sectionList = state.sectionList.map((sec, index, arr) => {
      if (sec.id === id) {
        arr.splice(index, 1);
      }
    })
    // TODO: 提示删除成功
  },
  toggle_mirror (state, toggle) {
    state.isMirror = toggle;
  },
  toggle_sub_video (state, toggle) {
    console.log(toggle);
    state.subOpen = toggle;
  },
  // ~设置新区间的开始时间
  set_sec_startTime (state, start) {
    // TODO: 时间上需要做处理
    state.sectionSelected.startTime = start;
  },
  set_sec_endTime (state, end) {
    state.sectionSelected.endTime = end;
  },
  set_video_speed (state, speed) {
    state.speed = speed;
  },
  set_video_loop (state, loop) {
    state.loop = loop;
  },
  // ~设置视频dom元素
  set_video_ele (state, ele) {
    state.video.videoEle = ele;
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
