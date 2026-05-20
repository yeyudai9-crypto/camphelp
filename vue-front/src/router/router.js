import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import peisongyuanList from '../pages/peisongyuan/list'
import peisongyuanDetail from '../pages/peisongyuan/detail'
import peisongyuanAdd from '../pages/peisongyuan/add'
import kuaididingdanList from '../pages/kuaididingdan/list'
import kuaididingdanDetail from '../pages/kuaididingdan/detail'
import kuaididingdanAdd from '../pages/kuaididingdan/add'
import jiedanxinxiList from '../pages/jiedanxinxi/list'
import jiedanxinxiDetail from '../pages/jiedanxinxi/detail'
import jiedanxinxiAdd from '../pages/jiedanxinxi/add'
import songdadingdanList from '../pages/songdadingdan/list'
import songdadingdanDetail from '../pages/songdadingdan/detail'
import songdadingdanAdd from '../pages/songdadingdan/add'
import daiqupingjiaList from '../pages/daiqupingjia/list'
import daiqupingjiaDetail from '../pages/daiqupingjia/detail'
import daiqupingjiaAdd from '../pages/daiqupingjia/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'peisongyuan',
					component: peisongyuanList
				},
				{
					path: 'peisongyuanDetail',
					component: peisongyuanDetail
				},
				{
					path: 'peisongyuanAdd',
					component: peisongyuanAdd
				},
				{
					path: 'kuaididingdan',
					component: kuaididingdanList
				},
				{
					path: 'kuaididingdanDetail',
					component: kuaididingdanDetail
				},
				{
					path: 'kuaididingdanAdd',
					component: kuaididingdanAdd
				},
				{
					path: 'jiedanxinxi',
					component: jiedanxinxiList
				},
				{
					path: 'jiedanxinxiDetail',
					component: jiedanxinxiDetail
				},
				{
					path: 'jiedanxinxiAdd',
					component: jiedanxinxiAdd
				},
				{
					path: 'songdadingdan',
					component: songdadingdanList
				},
				{
					path: 'songdadingdanDetail',
					component: songdadingdanDetail
				},
				{
					path: 'songdadingdanAdd',
					component: songdadingdanAdd
				},
				{
					path: 'daiqupingjia',
					component: daiqupingjiaList
				},
				{
					path: 'daiqupingjiaDetail',
					component: daiqupingjiaDetail
				},
				{
					path: 'daiqupingjiaAdd',
					component: daiqupingjiaAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
