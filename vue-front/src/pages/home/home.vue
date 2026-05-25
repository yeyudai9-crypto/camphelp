<template>
<div class="home-preview" :style='{"width":"100%","margin":"0px auto","flexDirection":"column","display":"flex"}'>




		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"padding":"30px 20% 80px","margin":"-25px 0 0 0","background":"#F4F4F4"}'>
		<div v-if="true" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
			<div class="box1" :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"36px","color":"#9E9E9E","textAlign":"center","height":"auto"}'>Bullish Headlines</div>
			<div class="box2" :style='{"width":"50px","margin":"0 300px 0 0","background":"#B6B6B6","height":"2px"}'></div>
			<div class="box3" :style='{"width":"50px","background":"#B6B6B6","height":"2px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"width":"300px","margin":"-50px auto 20px","lineHeight":"54px","textAlign":"center"}'>
			<span :style='{"color":"#505050","fontSize":"40px"}'>通知公告</span>
		</div>
		
			
			
			
			
			
			
			
			
			
			
		







		<div v-if="newsList.length" class="list list18 index-pv1" :style='{"width":"100%","padding":"0","justifyContent":"space-between","display":"flex","height":"auto"}'>
		  <div :style='{"width":"63%","overflow":"hidden","background":"#fff","justifyContent":"space-between","display":"flex","height":"480px"}' class="left">
		    <div :style='{"width":"50%","flexDirection":"column","background":"#f5f5f5","justifyContent":"space-between","display":"flex","height":"auto"}' class="list">
			  <template v-for="(item,index) in newsList">
		      <div v-if="index < 6" @click="toDetail('newsDetail', item)" @mouseenter="newsMouseove18(index)" class="item" :class="index == newsIndex18 ? 'active' : ''">
		        <div class="name">{{item.title}}</div>
		      </div>
			  </template>
		    </div>
		    <div :style='{"width":"50%","height":"480px"}' class="imgs">
			  <template v-for="(item,index) in newsList">
		      <img v-if="index < 6" v-show="index == newsIndex18" :style='{"width":"100%","objectFit":"cover","display":"block","height":"480px"}' :src="baseUrl + item.picture" alt="">
			  </template>
		    </div>
		  </div>
		  <div :style='{"width":"35%","overflow":"hidden","background":"#fff","height":"480px"}' class="right">
		    <div v-if="newsList.length > 6" :style='{"cursor":"pointer","width":"100%","position":"relative","height":"200px"}' class="top list-item animation-box" @click="toDetail('newsDetail', newsList[6])">
		      <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"200px"}' :src="baseUrl + newsList[6].picture">
		      <div :style='{"width":"100%","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
		        <div :style='{"padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff"}' class="title">{{newsList[6].title}}</div>
		      </div>
		    </div>
		    <div v-if="newsList.length > 7" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}' class="list">
			  <template v-for="(item,index) in newsList">
		      <div v-if="index > 6" :style='{"cursor":"pointer","borderColor":"#f5f5f5","alignItems":"center","borderWidth":"0 0 1px","display":"flex","width":"100%","borderStyle":"solid","height":"45px"}' class="item" @click="toDetail('newsDetail', item)">
		        <div class="dian"></div>
		        <div class="title" >{{item.title}}</div>
		        <div :style='{"padding":"0 6px"}' class="time">
		          <span class="icon iconfont icon-shijian21"></span>
		          <span class="text">{{item.addtime}}</span>
		        </div>
		      </div>
			  </template>
		    </div>
		  </div>
		</div>




		<div @click="moreBtn('news')" :style='{"border":"0","width":"80px","margin":"20px auto","lineHeight":"32px","textAlign":"center","display":"none"}'>
			<span :style='{"color":"#9E9E9E","fontSize":"14px"}'>更多</span>
			<i :style='{"color":"#9E9E9E","fontSize":"14px"}' class="icon iconfont icon-gengduo1"></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->



<!-- 特价商品 -->
<div id="animate_listkuaididingdan" class="lists animate__animated" :style='{"padding":"40px 20%","margin":"0 0 10px","background":"#f4f4f4","order":"4"}'>
	<div v-if="true" class="idea" :style='{"padding":"20px","color":"#9E9E9E","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
		<div class="box1" :style='{"width":"100%","fontSize":"40px","textAlign":"center","height":"80px"}'>Bargain Goods</div>
		<div class="box2" :style='{"width":"50px","margin":"0 300px 0 0","background":"#B6B6B6","height":"2px"}'></div>
		<div class="box3" :style='{"width":"50px","background":"#B6B6B6","height":"2px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"400px","margin":"-45px auto 20px","lineHeight":"54px","textAlign":"center"}'>
	  <span :style='{"color":"#505050","fontSize":"36px"}'>代取订单展示</span>
	</div>
	
	
	
	
	
	
	
	
	
	






	
		<div v-if="kuaididingdanList.length" class="list list16 index-pv1" :style='{"width":"100%","padding":"0","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}'>
		  <div v-for="item,index in kuaididingdanList" :key="index"  @click="toDetail('kuaididingdanDetail', item)" class="list-item animation-box">
		    <div :style='{"border":"0","width":"40%","padding":"0","overflow":"hidden","height":"auto"}' class="img-box">
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-if="preHttp(item.jietu)" :src="item.jietu.split(',')[0]" alt="" />
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-else :src="baseUrl + (item.jietu?item.jietu.split(',')[0]:'')" alt="" />
			</div>
		    <div :style='{"padding":"10px","overflow":"hidden","alignItems":"center","flex":"1","display":"flex","height":"auto"}' class="item-info">
		      <div :style='{"padding":"0 10px 0 0","flexDirection":"column","flex":"1","display":"flex"}'>
				<div class="title">{{item.kuaidimingcheng}}</div>
				<div class="title">状态:{{item.zhuangtai}}</div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0","order":"2"}' class="time">
		          <span class="icon iconfont icon-shijian21"></span>
		          <span class="text">{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0","order":"1"}' class="publisher">
		          <span class="icon iconfont icon-geren16"></span>
		          <span class="text">{{item.zhanghao}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0"}' class="collect">
		          <span class="icon iconfont icon-shoucang10"></span>
		          <span class="text">{{item.storeupnum}}</span>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('kuaididingdan')" :style='{"border":"0","width":"80px","margin":"10px auto","lineHeight":"32px","textAlign":"center","display":"none"}'>
		<span :style='{"color":"#9E9E9E","fontSize":"14px"}'>更多</span>
		<i :style='{"color":"#9E9E9E","fontSize":"14px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	

</div>
<!-- 特价商品 -->
	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],

        kuaididingdanList: [],


		newsIndex18: 0,


      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getList();
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			setTimeout(()=>{
			},750)
		},
		newsMouseove18(index) {
			this.newsIndex18 = index
		},
		recommendIndexClick12(index, name) {
			this['recommendIndex12' + name] = index
			this.getList()
			
			document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
			  el.classList.remove("active")
			})
			setTimeout(() => {
			  document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
			    el.classList.add("active")
			  })
			}, 1);
		},


		handleScroll() {
			let arr = [
				{id:'search',css:'animate__bounce'},
				{id:'about',css:'animate__lightSpeedInLeft'},
				{id:'system',css:'animate__backInRight'},
				{id:'animate_listkuaididingdan',css:'animate__rotateInUpRight'},
				{id:'animate_newsnews',css:'animate__rotateInUpLeft'},
				{id:'msgs',css:'animate__swing'},
				{id:'friendly',css:'animate__backInUp'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 13,
                sort: 'addtime',
				order: 'desc'
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
			
			data = {
				page: 1,
				limit: 4,
			}
			this.$http.get('kuaididingdan/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.kuaididingdanList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select ::v-deep .el-input__inner {
			border: 0;
			border-radius: 20px 0 0 20px;
			padding: 0 10px 0 10px;
			outline: none;
			color: #fff;
			background: rgba(0,0,0,0.5);
			width: 120px;
			font-size: 14px;
			height: 44px;
		}
		
		.search .input ::v-deep .el-input__inner {
			border: 0;
			border-radius: 0 20px 20px 0;
			padding: 0 10px;
			outline: none;
			color: #fff;
			background: rgba(0,0,0,0.5);
			width: 480px;
			font-size: 14px;
			height: 44px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	




	.home-preview .news .list18 .left .list .item {
				cursor: pointer;
				padding: 0 20px;
				background: #fff;
				width: 100%;
				border-color: #F4F4F4;
				border-width: 0 0 1px 0;
				border-style: solid;
				height: 80px;
			}
	
	.home-preview .news .list18 .left .list .item:hover {
				background: #ff721b;
			}
	
	.home-preview .news .list18 .left .list .item .name {
				color: #333;
				font-size: 18px;
				line-height: 80px;
			}
	
	.home-preview .news .list18 .left .list .item:hover .name {
				color: #fff;
			}
	
	.home-preview .news .list18 .right .list .item .dian {
				border-radius: 100%;
				margin: 0 6px;
				background: #D8D8D8;
				width: 4px;
				height: 4px;
			}
	.home-preview .news .list18 .right .list .item:hover .dian {
				background: #ff721b;
			}
	
	.home-preview .news .list18 .right .list .item .title {
				overflow: hidden;
				color: #333;
				flex: 1;
				font-size: 14px;
				line-height: 24px;
				transition: 0.3s;
				height: 24px;
			}
	.home-preview .news .list18 .right .list .item:hover .title {
				color: #ff721b;
			}
	
	.home-preview .news .list18 .right .list .item .time .icon {
				color: #9b9b9b;
				font-size: 12px;
				line-height: 24px;
			}
	.home-preview .news .list18 .right .list .item:hover .time .icon {
				color: #ff721b;
			}
	.home-preview .news .list18 .right .list .item .time .text {
				color: #9b9b9b;
				font-size: 12px;
				line-height: 24px;
			}
	.home-preview .news .list18 .right .list .item:hover .time .text {
				color: #ff721b;
			}



	.home-preview .recommend .list12 .tab .item {
				cursor: pointer;
				border: 1px solid #9E9E9E;
				padding: 0 10px;
				margin: 0 10px;
				color: #9E9E9E;
				width: auto;
				font-size: 16px;
				line-height: 45px;
				height: 50px;
			}
	
	.home-preview .recommend .list12 .tab .item:hover {
				color: #fff;
				background: #242424;
			}
	
	.home-preview .recommend .list12 .tab .item.active {
				color: #fff;
				background: #242424;
				border-color: #999;
				border-width: 0 0 1px 0;
				border-style: solid;
			}
	
	.home-preview .recommend .list12 .tab .more {
				cursor: pointer;
				align-self: start;
				padding: 5px 10px;
				margin: 0 10px;
				color: #9E9E9E;
				background: #fff;
				display: none;
				line-height: 44px;
				align-items: center;
			}
	
	.home-preview .recommend .list12 .tab .more:hover {
				color: #242424;
			}
	
	.home-preview .recommend .list12 .item.active {
	  animation-name: mymove;
	
	  &:nth-of-type(1) {
	    animation-duration: 1s;
	  }
	  &:nth-of-type(2) {
	    animation-duration: 1.2s;
	  }
	  &:nth-of-type(3) {
	    animation-duration: 1.4s;
	  }
	  &:nth-of-type(4) {
	    animation-duration: 1.6s;
	  }
	  &:nth-of-type(5) {
	    animation-duration: 1.8s;
	  }
	  &:nth-of-type(6) {
	    animation-duration: 2s;
	  }
	}
	
	@keyframes mymove
	{
		from {top: 320px;}
		to {top: 0;}
	}



	.home-preview .lists .list16 .list-item {
				cursor: pointer;
				padding: 0;
				margin: 0 0 20px;
				overflow: hidden;
				background: #ebebeb;
				display: flex;
				width: 49%;
				font-size: 0;
				position: relative;
				height: auto;
			}
	
	.home-preview .lists .list16 .list-item:hover {
				background: #ff721b;
			}
	
	.home-preview .lists .list16 .list-item .title {
				padding: 0 10px;
				overflow: hidden;
				color: #333;
				font-size: 14px;
				border-color: red;
				border-width: 0;
				line-height: 36px;
				border-style: solid;
				height: 36px;
			}
	
	.home-preview .lists .list16 .list-item:hover .title {
				color: #fff;
			}
	
	.home-preview .lists .list16 .list-item .time .icon {
				margin: 0 2px 0 0;
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .time .icon {
				color: #fff;
			}
	.home-preview .lists .list16 .list-item .time .text {
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .time .text {
				color: #fff;
			}
	
	.home-preview .lists .list16 .list-item .publisher .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .publisher .icon {
				color: #fff;
			}
	.home-preview .lists .list16 .list-item .publisher .text {
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .publisher .text {
				color: #fff;
			}
	
	.home-preview .lists .list16 .list-item .like .icon {
				margin: 0 2px 0 0;
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .like .icon {
				color: #fff;
			}
	.home-preview .lists .list16 .list-item .like .text {
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .like .text {
				color: #fff;
			}
	
	.home-preview .lists .list16 .list-item .collect .icon {
				margin: 0 2px 0 0;
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .collect .icon {
				color: #fff;
			}
	.home-preview .lists .list16 .list-item .collect .text {
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .collect .text {
				color: #fff;
			}
	
	.home-preview .lists .list16 .list-item .view .icon {
				margin: 0 2px 0 0;
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .view .icon {
				color: #fff;
			}
	.home-preview .lists .list16 .list-item .view .text {
				color: #868686;
				font-size: 12px;
				line-height: 28px;
			}
	.home-preview .lists .list16 .list-item:hover .view .text {
				color: #fff;
			}
	
	.home-preview .lists .list16 .list-item .desc {
				overflow: hidden;
				color: #868686;
				width: 50%;
				font-size: 14px;
				line-height: 1.5;
				height: auto;
			}
	.home-preview .lists .list16 .list-item:hover .desc {
				color: #fff;
			}
</style>
