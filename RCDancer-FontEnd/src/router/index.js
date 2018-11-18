// ~ routes index
import Router from 'vue-router'
import Vue from 'vue'
import leftSideMenu from '@/components/LeftSideMenu'
import rightSideMenu from '@/components/RightSideMenu'
import trainingPage from '@/views/TrainingPage'
import faultDetectPage from '@/views/FaultDetectPage'
import indexPage from '@/views/IndexPage'

const routes = [
  {
    path: '/',
    redirect: 'index'
  },
  {
    path: '/index',
    components: {
      default: indexPage
    }
  },
  {
    path: '/train',
    components: {
      default: trainingPage,
      leftMenu: leftSideMenu,
      rightMenu: rightSideMenu
    }
  },
  {
    path: '/faultDetect',
    components: {
      default: faultDetectPage,
      leftMenu: leftSideMenu,
      rightMenu: rightSideMenu
    }
  }
];

Vue.use(Router);
export default new Router({
  routes
})
