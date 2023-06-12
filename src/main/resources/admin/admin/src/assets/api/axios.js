import axios from "axios";
import storage from '@/utils/storage'
import router from '@/router/router-static'
const service = axios.create({
    timeout: 20000, // 请求超时时间
    withCredentials: true,
    changeOrigin: true,
    headers: {
        'Content-Type': 'application/json; charset=utf-8',
        'Token': sessionStorage.getItem("token")
    }

});

// 请求拦截
service.interceptors.request.use(config => {
    config.headers['Token'] = sessionStorage.getItem("token") // 请求头带上token
    return config
}, error => {
    // console.log(123);
    return Promise.reject(error)
})
// response拦截器
service.interceptors.response.use(
    (response) => {
        console.log(response);
        if (response.data.code == '401') {
            // console.log(123);
            router.push({ name: '/event/login' })
        }
        return response
    },
    (error) => {
        // console.log(123);
        // Vue.prototype.$Login.hiden();
        return Promise.resolve(error.response);
    }
);


export default service;