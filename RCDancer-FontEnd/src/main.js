import Vue from 'vue'
import App from './App.vue'
import router from '@/router'
import store from '@/store'
import './plugins/vuetify'
import '@/assets/css/normalize.css'
// 引入axios库进行http请求
import axios from 'axios'
Vue.prototype.$http = axios
// 引入文件上传组件
import upLoader from 'vue-simple-uploader'

Vue.use(upLoader);
Vue.config.productionTip = false

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
