const base = {
    get() {
        return {
            url : "http://localhost:8080/eventi/",
            name: "event",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/eventi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "Community support system"
        } 
    }
}
export default base
