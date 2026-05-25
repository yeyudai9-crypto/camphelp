const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootfa427577/",
            name: "springbootfa427577",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootfa427577/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于地理位置的校园代取系统"
        } 
    }
}
export default base
