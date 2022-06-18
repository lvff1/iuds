// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
// 导入路由表
import router from "./router"

// 导入a
import axios from 'axios'
import VueAxios from 'vue-axios'

//  导入element-ui组件库及相关样式
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';



Vue.config.productionTip = false

// 进行全局注册

Vue.use(ElementUI)
Vue.use(VueAxios,axios)



/* eslint-disable no-new */
new Vue({
  el: '#app',
  // 添加路由
  router: router,
  components: { App },
  template: '<App/>'
})
