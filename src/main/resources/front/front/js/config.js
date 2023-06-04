
var projectName = 'Community Support System';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

{
        name: '我的收藏',
        url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: 'activity',
	url: './pages/shequhuodong/list.html'
}, 
{
	name: 'voting',
	url: './pages/toupiaoxinxi/list.html'
}, 
{
	name: 'venue',
	url: './pages/shequchangdi/list.html'
}, 
{
	name: 'Announcement',
	url: './pages/shequgonggao/list.html'
}, 

{
	name: 'Forum',
	url: './pages/forum/list.html'
}, 
]

var adminurl =  "http://localhost:8080/eventi/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["Add","查看","Change","Delete"],"menu":"resident","menuJump":"列表","tableName":"jumin"}],"menu":"resident"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["Add","查看","Change","Delete","View comment","Sign up"],"menu":"Event","menuJump":"列表","tableName":"shequhuodong"}],"menu":"event"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","Change","Delete","取消","eventEvaluation"],"menu":"eventRegistration","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"eventRegistration"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","Change","Delete"],"menu":"eventEvaluation","menuJump":"列表","tableName":"huodongpingjia"}],"menu":"eventEvaluation"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","Change","Delete","审核"],"menu":"取消Sign up","menuJump":"列表","tableName":"quxiaobaoming"}],"menu":"Cancel registration management"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["Add","查看","Change","Delete","投票"],"menu":"投票信息","menuJump":"列表","tableName":"toupiaoxinxi"}],"menu":"投票信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","Change","Delete","报表"],"menu":"投票统计","menuJump":"列表","tableName":"toupiaotongji"}],"menu":"投票统计管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["Add","查看","Change","Delete","View comment"],"menu":"社区场地","menuJump":"列表","tableName":"shequchangdi"}],"menu":"社区场地管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["Add","查看","Change","Delete"],"menu":"社区公告","menuJump":"列表","tableName":"shequgonggao"}],"menu":"社区公告管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["Add","查看","Change","Delete"],"menu":"社区论坛","tableName":"forum"}],"menu":"社区论坛"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["Add","查看","Change","Delete"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","Sign up"],"menu":"社区活动列表","menuJump":"列表","tableName":"shequhuodong"}],"menu":"社区活动模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","投票"],"menu":"投票信息列表","menuJump":"列表","tableName":"toupiaoxinxi"}],"menu":"投票信息模块"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"社区场地列表","menuJump":"列表","tableName":"shequchangdi"}],"menu":"社区场地模块"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看"],"menu":"社区公告列表","menuJump":"列表","tableName":"shequgonggao"}],"menu":"社区公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"administered","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","Delete","取消","eventEvaluation"],"menu":"eventRegistration","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"eventRegistration"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","Delete"],"menu":"eventEvaluation","menuJump":"列表","tableName":"huodongpingjia"}],"menu":"eventEvaluation"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","Delete"],"menu":"取消Sign up","menuJump":"列表","tableName":"quxiaobaoming"}],"menu":"Cancel registration management"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","Delete"],"menu":"投票统计","menuJump":"列表","tableName":"toupiaotongji"}],"menu":"投票统计管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","Sign up"],"menu":"社区活动列表","menuJump":"列表","tableName":"shequhuodong"}],"menu":"社区活动模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","投票"],"menu":"投票信息列表","menuJump":"列表","tableName":"toupiaoxinxi"}],"menu":"投票信息模块"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"社区场地列表","menuJump":"列表","tableName":"shequchangdi"}],"menu":"社区场地模块"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看"],"menu":"社区公告列表","menuJump":"列表","tableName":"shequgonggao"}],"menu":"社区公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"resident","tableName":"jumin"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
