import axios from "axios";
import storage from '@/utils/storage'
const service = axios.create({
    timeout: 20000, // 请求超时时间
    withCredentials: true,
    changeOrigin: true,

});

axios.interceptors.request.use(config => {
    config.headers['Token'] = storage.get('Token') // 请求头带上token
    return config
}, error => {
    return Promise.reject(error)
})
// response拦截器
service.interceptors.response.use(
    response => {

        console.log(response);
        if (response.status == "200") {
            return response;
        }
    },
    function (error) {
        //失败



        return Promise.reject(error.response.data);
    }
);

export default service;