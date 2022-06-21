import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 导入相关页面
import index from '../view/index'
import emp from '../view/emp/emp'
import dept from '../view/dept/dept'
import user from '../view/user/user'
import role from '../view/role/role'




// 2.配置映射关系
const routes = [
    { path: '/index', component: index }, // 访问/index路径就会跳转到index的视图
    { path: '/emp', component: emp },
    { path: '/dept', component: dept },
    { path: '/user', component: user },
    { path: '/role', component: role },
]


export default new VueRouter({
    routes
})




