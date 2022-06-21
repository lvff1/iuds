import Vue from 'vue'

// 导入axios
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios,axios)


//  创建一个axios实例  设置一些基本的数据
const http = axios.create({
    // 基础url
    baseURL: 'http://localhost:8082/',
    // 超时时间 单位毫秒
    timeout: 3000,
    // 请求头 设置 请求体中格式为json  编码为utf-8
    headers: {'Content-Type': 'application/json ;charset:utf-8'}
  });


  
// 导出
export default http
