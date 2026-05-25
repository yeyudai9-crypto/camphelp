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
    import kuaididingdan from '@/views/modules/kuaididingdan/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import jiedanxinxi from '@/views/modules/jiedanxinxi/list'
    import messages from '@/views/modules/messages/list'
    import songdadingdan from '@/views/modules/songdadingdan/list'
    import config from '@/views/modules/config/list'
    import peisongyuan from '@/views/modules/peisongyuan/list'
    import daiqupingjia from '@/views/modules/daiqupingjia/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
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
	path: '/kuaididingdan',
        name: '代取订单',
        component: kuaididingdan
      }
      ,{
	path: '/news',
        name: '通知公告',
        component: news
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/jiedanxinxi',
        name: '接单信息',
        component: jiedanxinxi
      }
      ,{
	path: '/messages',
        name: '留言反馈',
        component: messages
      }
      ,{
	path: '/songdadingdan',
        name: '送达订单',
        component: songdadingdan
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/peisongyuan',
        name: '配送员',
        component: peisongyuan
      }
      ,{
	path: '/daiqupingjia',
        name: '代取评价',
        component: daiqupingjia
      }
      ,{
	path: '/newstype',
        name: '通知公告分类',
        component: newstype
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
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
