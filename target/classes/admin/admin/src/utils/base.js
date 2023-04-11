const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot7znd1/",
            name: "springboot7znd1",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot7znd1/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "社区活动中心"
        } 
    }
}
export default base
