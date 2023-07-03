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
import login from '@/views/login/index'
import homes from '@/views/market/home'
import index from '@/views/market/index'
import marketking from '@/views/market/marketking/index'
import detali from '@/views/market/marketking/detali'
import Uplode from '@/views/market/marketking/Uplode'
import Individual from '@/views/market/Individual/index'
import homerulel from '@/views/marketrulel/index'
import homerulelindex from '@/views/marketrulel/homerulelindex'
import comment from '@/views/marketrulel/comment'
import upload from '@/views/marketrulel/upload'
import discuss from '@/views/marketrulel/discuss'
import announcement from '@/views/modules/announcement/list'
import uploadreport from '@/views/modules/uploadreport/list'


//2.配置路由 注意：name
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch((err) => err);
};
const routes = [{
  path: '/index',
  name: 'Home',
  component: Index,
  children: [{
    // 这里不设置值，是把main作为默认页面
    path: '/',
    name: 'Home',
    component: Home,
    meta: { icon: '', title: 'center' }
  }, {
    path: '/updatePassword',
    name: 'ChangePassword',
    component: UpdatePassword,
    meta: { icon: '', title: 'updatePassword' }
  },
  {
    path: '/event/login',
    name: '/event/login',
    component: login,

  },
  {
    path: '/event/homerulel/',
    name: 'homerulel',
    component: homerulel,
    children: [
      {
        path: '/',
        name: 'index',
        component: homerulelindex,
      },
      {
        path: '/event/homerulel/comment',
        name: 'comment',
        component: comment,
      },
      {
        path: '/event/homerulel/config',
        name: 'system',
        component: config
      },
      {
        path: '/event/homerulel/upload',
        name: 'upload',
        component: upload
      },
      {
        path: '/event/homerulel/discuss',
        name: 'discuss',
        component: discuss
      },
    ]

  },

  {
    path: '/event/home',
    name: 'homes',
    component: homes,
    children: [
      {
        path: '/',
        name: 'index',
        component: index,
      },

      {
        path: '/event/marketking',
        name: 'marketking',
        component: marketking,
      },
      {
        path: '/event/Uplode',
        name: 'Uplode',
        component: Uplode,
      },
      {
        path: '/event/marketking/detali',
        name: 'detali',
        component: detali,
      },
      {
        path: '/event/Individual',
        name: 'Individual',
        component: Individual,
      }
    ]

  },
  {
    path: '/pay',
    name: '支付',
    component: pay,
    meta: { icon: '', title: 'pay' }
  }, {
    path: '/center',
    name: 'information',
    component: center,
    meta: { icon: '', title: 'center' }
  }
    , {
    path: '/quxiaobaoming',
    name: 'CancelRegister',
    component: quxiaobaoming
  }
    , {
    path: '/jumin',
    name: 'Resident',
    component: jumin
  }
  , {
    path: '/forum',
    name: 'Forum',
    component: forum
  }
    , {
    path: '/toupiaotongji',
    name: 'Voting Statistics',
    component: toupiaotongji
  }
    , {
    path: '/huodongbaoming',
    name: 'Event Register',
    component: huodongbaoming
  }
    , {
    path: '/shequgonggao',
    name: 'Announcement',
    component: shequgonggao
  }
    , {
    path: '/discussshequhuodong',
    name: 'discuss',
    component: discussshequhuodong
  }
    , {
    path: '/shequhuodong',
    name: 'Enent',
    component: shequhuodong
  }
    , {
    path: '/toupiaoxinxi',
    name: 'voting information',
    component: toupiaoxinxi
  }
    , {
    path: '/huodongpingjia',
    name: 'evaluation',
    component: huodongpingjia
  }
    , {
    path: '/config',
    name: 'system',
    component: config
  }
    , {
    path: '/discussshequchangdi',
    name: 'community venue reviews',
    component: discussshequchangdi
  }
    , {
    path: '/shequchangdi',
    name: 'community venue',
    component: shequchangdi
  }, {
      path: '/announcement',
      name: 'announcement',
      component: announcement
    }, {
      path: '/report',
      name: 'report',
      component: uploadreport
    }
  ]
},
{
  path: '/login',
  name: 'login',
  component: Login,
  meta: { icon: '', title: 'login' }
},
{
  path: '/register',
  name: 'register',
  component: register,
  meta: { icon: '', title: 'register' }
},
{
  path: '/',
  name: 'Home',
  redirect: '/index'
}, /*默认跳转路由*/
{
  path: '*',
  component: NotFound
}
]
//3.实例化VueRouter 注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;

