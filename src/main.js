// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
// 导入路由表
import router from "./router"



//  导入element-ui组件库及相关样式
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import http from './request/request'


Vue.config.productionTip = false

// 进行全局注册

Vue.use(ElementUI)

// 添加属性

Vue.prototype.http=http




/* eslint-disable no-new */
new Vue({
  el: '#app',
  // 添加路由
  router: router,
  components: { App },
  template: '<App/>'
})
