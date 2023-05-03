import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import quxiaobaoming from '@/views/modules/quxiaobaoming/list'
    import jumin from '@/views/modules/jumin/list'
    import forum from '@/views/modules/forum/list'
    import toupiaotongji from '@/views/modules/toupiaotongji/list'
    import huodongbaoming from '@/views/modules/huodongbaoming/list'
    import shequgonggao from '@/views/modules/shequgonggao/list'
    import discussshequhuodong from '@/views/modules/discussshequhuodong/list'
    import shequhuodong from '@/views/modules/shequhuodong/list'
    import toupiaoxinxi from '@/views/modules/toupiaoxinxi/list'
    import huodongpingjia from '@/views/modules/huodongpingjia/list'
    import config from '@/views/modules/config/list'
    import discussshequchangdi from '@/views/modules/discussshequchangdi/list'
    import shequchangdi from '@/views/modules/shequchangdi/list'


//2.配置路由   注意：name
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/quxiaobaoming',
        name: '取消报名',
        component: quxiaobaoming
      }
      ,{
	path: '/jumin',
        name: '居民',
        component: jumin
      }
      ,{
	path: '/forum',
        name: '社区论坛',
        component: forum
      }
      ,{
	path: '/toupiaotongji',
        name: '投票统计',
        component: toupiaotongji
      }
      ,{
	path: '/huodongbaoming',
        name: '活动报名',
        component: huodongbaoming
      }
      ,{
	path: '/shequgonggao',
        name: '社区公告',
        component: shequgonggao
      }
      ,{
	path: '/discussshequhuodong',
        name: '社区活动评论',
        component: discussshequhuodong
      }
      ,{
	path: '/shequhuodong',
        name: '社区活动',
        component: shequhuodong
      }
      ,{
	path: '/toupiaoxinxi',
        name: '投票信息',
        component: toupiaoxinxi
      }
      ,{
	path: '/huodongpingjia',
        name: '活动评价',
        component: huodongpingjia
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/discussshequchangdi',
        name: '社区场地评论',
        component: discussshequchangdi
      }
      ,{
	path: '/shequchangdi',
        name: '社区场地',
        component: shequchangdi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
