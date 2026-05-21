<template>
  <div>
    <div
        :style='{"padding":"0 20px","margin":"-60px 0 0 0","borderRadius":"0","alignItems":"center","background":"rgba(0,0,0,0.5)","display":"flex","width":"100%","justifyContent":"center","height":"60px"}'
        class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'"
                     :style='{"alignItems":"center","background":"rgba(0,0,0,0.5)","display":"flex","width":"100%","fontSize":"14px","justifyContent":"center","zIndex":"11","height":"100%"}'>
        <el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
        <el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/jiedanxinxi">
          <a>{{ item.name }}</a></el-breadcrumb-item>
        <el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div
        :style='{"padding":"0 20px","margin":"-60px 0 0 0","borderRadius":"0","alignItems":"center","background":"rgba(0,0,0,0.5)","display":"flex","width":"100%","justifyContent":"center","height":"60px"}'>
      <el-button size="mini" @click="backClick">返回</el-button>
    </div>
    <div class="detail-preview"
         :style='{"margin":"20px auto","alignItems":"flex-start","flexWrap":"wrap","display":"flex","width":"60%","position":"relative","justifyContent":"space-between"}'>
      <div class="attr"
           :style='{"width":"60%","padding":"0px","position":"relative","background":"#fff","display":"flex","order":"1"}'>

        <div class="info" :style='{"padding":"0px","margin":"0px","background":"#ffffff","flex":"1"}'>
          <div class="item"
               :style='{"padding":"10px","margin":"0 0 2px 0","alignItems":"center","background":"#ffffff","justifyContent":"space-between","display":"flex"}'>
            <div :style='{"color":"#333","fontSize":"16px","fontWeight":"600"}'>
              {{ detail.kuaidimingcheng }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              订单号
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.dingdanhao }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              快递单号
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.kuaididanhao }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              快递类型
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.kuaidileixing }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              快递备注
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.kuaidibeizhu }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              代取费用
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.daiqufeiyong }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              账号
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.zhanghao }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              手机
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.shouji }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              取货地址
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.quhuodizhi }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              目的地址
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.mudedizhi }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              配送账号
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.peisongzhanghao }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              联系电话
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.lianxidianhua }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              快递状态
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.kuaidizhuangtai }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              接单时间
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.jiedanshijian }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              配送人
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.peisongren }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0px","margin":"0 0 10px 0","background":"#ffffff","justifyContent":"spaceBetween","display":"flex"}'
               v-if="centerType">
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"center","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>
              是否支付
            </div>
            <div
                :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>
              {{ detail.ispay == '已支付' ? '已支付' : '未支付' }}
            </div>
          </div>
          <div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
            <el-button
                :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#E5AD12","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                v-if="btnAuth('jiedanxinxi','修改')" @click="editClick">修改
            </el-button>
            <el-button
                :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#ff721b","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                v-if="btnAuth('jiedanxinxi','删除')" @click="delClick">删除
            </el-button>
            <!-- hasChat 无 -->
            <el-button
                :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#FF721B","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                v-if="btnAuth('jiedanxinxi','送达')"
                @click="onAcross('songdadingdan','','kuaidizhuangtai','已送达','已送达,送货中'.split(',')[0])" type="warning">送达
            </el-button>
            <el-button v-if="centerType&&(detail.ispay=='未支付'||!detail.ispay)&&btnAuth('jiedanxinxi','支付')"
                       :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#E5AD12","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                       type="warning" size="small" @click="payClick">支付
            </el-button>
          </div>
        </div>
      </div>

      <div class="swiper3" v-if="detailBanner.length"
           :style='{"width":"calc(100% - 120px)","background":"#fff","display":"block","height":"auto"}'>
        <div class="big"
             :style='{"border":"0","margin":"0 10px 20px 0","background":"#fff","width":"calc(85% - 10px)","position":"relative","float":"left","height":"400px"}'>
          <img id="big"
               :style='{"border":"1px solid #ddd","objectFit":"contain","top":"0","left":"0","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}'
               :src="swiperBigUrl" class="image">
        </div>
        <div class="samll"
             :style='{"padding":"0","margin":"0 10px 0 0","background":"#fff","flexDirection":"column","display":"flex","width":"calc(15% - 10px)","float":"right","height":"400px"}'>
          <div :style='{"border":"0","margin":"0 0 10px","position":"relative","background":"#fff","height":"95px"}'
               v-for="item in detailBanner" :key="item.id">
            <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}'
                 v-if="item.substr(0,4)=='http'" :src="item" @click="swiperClick3(item)" class="image">
            <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%","zIndex":"1"}' v-else
                 :src="baseUrl + item" @click="swiperClick3(baseUrl + item)" class="image">
          </div>
        </div>
      </div>


      <el-tabs class="detail"
               :style='{"border":"0","boxShadow":"none","margin":"40px 0 0","background":"#fff","flex":"1","width":"calc(100% - 260px)","order":"4"}'
               v-model="activeName" type="border-card">
        <el-tab-pane label="路线规划与实时位置" name="first">
          <div class="delivery-map">
            <div class="map-actions">
              <el-button type="primary" size="small" @click="planRoute">生成路线</el-button>
              <el-button type="success" size="small" @click="openNavigation" :disabled="!routeInfo.amapUrl">开始导航</el-button>
              <el-button type="warning" size="small" @click="reportLocation">上报当前位置</el-button>
              <el-button size="small" @click="refreshLocation">刷新位置</el-button>
            </div>
            <div class="map-panel">
              <div class="map-line"></div>
              <div class="map-point pickup">取</div>
              <div class="map-point destination">达</div>
              <div v-if="locationInfo" class="map-point courier" :style="courierPointStyle">配</div>
              <div v-if="!locationInfo" class="map-empty">暂无配送员实时位置</div>
            </div>
            <div class="map-summary">
              <p>取货地址：{{ detail.quhuodizhi || '未填写' }}</p>
              <p>目的地址：{{ detail.mudedizhi || '未填写' }}</p>
              <p v-if="routeInfo.distanceMeters">预计距离：{{ routeInfo.distanceMeters }} 米，预计 {{ routeInfo.durationMinutes }} 分钟</p>
              <p v-if="locationInfo">配送员坐标：{{ locationInfo.latitude }}, {{ locationInfo.longitude }}，更新时间：{{ locationInfo.updateTime }}</p>
              <p v-if="mapMessage">{{ mapMessage }}</p>
            </div>
            <div v-if="detail.luxianguihua" class="legacy-route" v-html="detail.luxianguihua"></div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="share_view"
         :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","position":"fixed","right":"0","bottom":"20%","background":"#fff","zIndex":"11"}'>
    </div>
  </div>
</template>

<script>
import CountDown from '@/components/CountDown';
import axios from 'axios'
import Swiper from "swiper";

export default {
  //数据集合
  data() {
    return {
      tablename: 'jiedanxinxi',
      baseUrl: '',
      breadcrumbItem: [
        {
          name: '接单信息'
        }
      ],
      title: '',
      detailBanner: [],
      id: 0,
      detail: {},
      activeName: 'first',
      total: 1,
      pageSize: 5,
      pageSizes: [10, 20, 30, 50],
      totalPage: 1,
      buynumber: 1,
      centerType: false,
      shareUrl: location.href,
      swiperBigUrl: null,
      routeInfo: {},
      locationInfo: null,
      locationTrack: [],
      mapMessage: '',
      trackingTimer: null,
    }
  },
  created() {
    if (this.$route.query.centerType) {
      this.centerType = true
    }

    this.init();
  },
  mounted() {
  },
  beforeDestroy() {
    if (this.trackingTimer) {
      clearInterval(this.trackingTimer);
    }
  },
  computed: {
    courierPointStyle() {
      if (!this.locationInfo) {
        return {};
      }
      const lat = Number(this.locationInfo.latitude || 0);
      const lng = Number(this.locationInfo.longitude || 0);
      return {
        left: (25 + Math.abs(lng * 10000) % 50) + '%',
        top: (25 + Math.abs(lat * 10000) % 45) + '%'
      }
    }
  },
  //方法集合
  methods: {
    swiperClick3(src) {
      this.swiperBigUrl = src
    },
    init() {
      this.id = this.$route.query.id
      this.baseUrl = this.$config.baseUrl;
      this.$http.get(this.tablename + '/detail/' + this.id, {}).then(res => {
        if (res.data.code == 0) {
          this.detail = res.data.data;
          this.title = this.detail.kuaidimingcheng;
          this.detailBanner = this.detail.jietu ? this.detail.jietu.split(",") : [];
          this.$forceUpdate();
          this.planRoute();
          this.refreshLocation();

          // 否

        }
        if (this.detailBanner.length) {
          if (this.detailBanner[0].substr(0, 4) == 'http') {
            this.swiperBigUrl = this.detailBanner[0]
          } else {
            this.swiperBigUrl = this.baseUrl + this.detailBanner[0]
          }
        }
      });
    },
    planRoute() {
      if (!this.detail || !this.detail.dingdanhao) {
        return;
      }
      this.$http.post('navigation/plan', {
        orderId: this.detail.dingdanhao,
        pickupAddress: this.detail.quhuodizhi,
        destinationAddress: this.detail.mudedizhi
      }).then(res => {
        if (res.data.code == 0) {
          this.routeInfo = res.data;
          this.mapMessage = '路线规划已生成';
        } else {
          this.mapMessage = res.data.msg || '路线规划失败';
        }
      });
    },
    openNavigation() {
      if (this.routeInfo && this.routeInfo.amapUrl) {
        window.open(this.routeInfo.amapUrl, '_blank');
      }
    },
    reportLocation() {
      if (!this.detail || !this.detail.dingdanhao) {
        this.$message.error('订单信息不完整');
        return;
      }
      if (!navigator.geolocation) {
        this.$message.error('当前浏览器不支持定位');
        return;
      }
      navigator.geolocation.getCurrentPosition(position => {
        const payload = {
          orderId: this.detail.dingdanhao,
          peisongzhanghao: this.detail.peisongzhanghao || localStorage.getItem('username'),
          peisongren: this.detail.peisongren || localStorage.getItem('frontName') || localStorage.getItem('username'),
          latitude: Number(position.coords.latitude.toFixed(6)),
          longitude: Number(position.coords.longitude.toFixed(6))
        };
        this.$http.post('location/report', payload).then(res => {
          if (res.data.code == 0) {
            this.locationInfo = res.data.data;
            this.mapMessage = '当前位置已上报';
            this.$message.success('位置上报成功');
          } else {
            this.$message.error(res.data.msg || '位置上报失败');
          }
        });
      }, () => {
        this.$message.error('定位失败，请确认浏览器定位权限已开启');
      }, {
        enableHighAccuracy: true,
        timeout: 10000,
        maximumAge: 30000
      });
    },
    refreshLocation() {
      if (!this.detail || !this.detail.dingdanhao) {
        return;
      }
      this.$http.get('location/current', {params: {orderId: this.detail.dingdanhao}}).then(res => {
        if (res.data.code == 0) {
          this.locationInfo = res.data.data;
          this.mapMessage = this.locationInfo ? '实时位置已刷新' : '暂无配送员实时位置';
        }
      });
      this.$http.get('location/track', {params: {orderId: this.detail.dingdanhao}}).then(res => {
        if (res.data.code == 0) {
          this.locationTrack = res.data.data || [];
        }
      });
    },
    onAcross(acrossTable, crossOptAudit, statusColumnName, tips, statusColumnValue) {
      if (this.detail.ispay != '已支付') {
        this.$message.error('请支付完成再操作');
        return;
      }
      localStorage.setItem('crossTable', `jiedanxinxi`);
      localStorage.setItem('crossObj', JSON.stringify(this.detail));
      localStorage.setItem('statusColumnName', statusColumnName);
      localStorage.setItem('statusColumnValue', statusColumnValue);
      localStorage.setItem('tips', tips);
      if (statusColumnName != '' && !statusColumnName.startsWith("[")) {
        var obj = JSON.parse(localStorage.getItem('crossObj'));
        for (var o in obj) {
          if (o == statusColumnName && obj[o] == statusColumnValue) {
            this.$message({
              type: 'success',
              message: tips,
              duration: 1500
            });
            return
          }
        }
      }
      this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
    },
    payClick() {
      localStorage.setItem("paytable", this.tablename)
      localStorage.setItem("payObject", JSON.stringify(this.detail))

      this.$router.push({path: '/index/pay'});
    },
    curChange(page) {
      this.getDiscussList(page);
    },
    prevClick(page) {
      this.getDiscussList(page);
    },
    nextClick(page) {
      this.getDiscussList(page);
    },
    // 返回按钮
    backClick() {
      history.back()
    },
    // 下载
    download(file) {
      if (!file) {
        this.$message({
          type: 'error',
          message: '文件不存在',
          duration: 1500,
        });
        return;
      }
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
        headers: {
          token: localStorage.getItem("frontToken")
        },
        responseType: "blob"
      }).then(({
                 data
               }) => {
        const binaryData = [];
        binaryData.push(data);
        const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
          type: 'application/pdf;chartset=UTF-8'
        }))
        const a = document.createElement('a')
        a.href = objectUrl
        a.download = arr
        // a.click()
        // 下面这个写法兼容火狐
        a.dispatchEvent(new MouseEvent('click', {
          bubbles: true,
          cancelable: true,
          view: window
        }))
        window.URL.revokeObjectURL(data)
      }, err => {
        axios.get((location.href.split(this.$config.name).length > 1 ? location.href.split(this.$config.name)[0] : '') + this.$config.name + '/file/download?fileName=' + arr, {
          headers: {
            token: localStorage.getItem("frontToken")
          },
          responseType: "blob"
        }).then(({
                   data
                 }) => {
          const binaryData = [];
          binaryData.push(data);
          const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
            type: 'application/pdf;chartset=UTF-8'
          }))
          const a = document.createElement('a')
          a.href = objectUrl
          a.download = arr
          // a.click()
          // 下面这个写法兼容火狐
          a.dispatchEvent(new MouseEvent('click', {
            bubbles: true,
            cancelable: true,
            view: window
          }))
          window.URL.revokeObjectURL(data)
        })
      })
    },


    // 权限判断
    btnAuth(tableName, key) {
      if (this.centerType) {
        return this.isBackAuth(tableName, key)
      } else {
        return this.isAuth(tableName, key)
      }
    },
    // 修改
    editClick() {
      this.$router.push(`/index/jiedanxinxiAdd?type=edit&&id=${this.detail.id}`);
    },
    // 删除
    delClick() {
      this.$confirm('是否删除此接单信息？')
          .then(_ => {
            this.$http.post('jiedanxinxi/delete', [this.detail.id]).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  type: 'success',
                  message: '删除成功!',
                  duration: 1500,
                  onClose: () => {
                    history.back()
                  }
                });
              }
            });
          }).catch(_ => {
      });
    },
  },
  components: {
    CountDown
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.editor ::v-deep .avatar-uploader {
  height: 0;
  line-height: 0;
}

.detail-preview {

  .attr {
    .el-carousel ::v-deep .el-carousel__indicator button {
      width: 0;
      height: 0;
      display: none;
    }

    .el-input-number__decrease:hover:not(.is-disabled) ~ .el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled) ~ .el-input .el-input__inner:not(.is-disabled) {
      border-color: none;
    }
  }

  .detail {
    & ::v-deep .el-tabs__header .el-tabs__nav-wrap {
      margin-bottom: 0;
    }

    & .add .el-textarea {
      width: auto;
    }
  }
}

.attr .el-carousel ::v-deep .el-carousel__container .el-carousel__arrow--left {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.attr .el-carousel ::v-deep .el-carousel__container .el-carousel__arrow--left:hover {
  background: red;
}

.attr .el-carousel ::v-deep .el-carousel__container .el-carousel__arrow--right {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.attr .el-carousel ::v-deep .el-carousel__container .el-carousel__arrow--right:hover {
  background: red;
}

.attr .el-carousel ::v-deep .el-carousel__indicators {
  padding: 0;
  margin: 0;
  z-index: 2;
  position: absolute;
  list-style: none;
}

.attr .el-carousel ::v-deep .el-carousel__indicators li {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 12px;
  opacity: 0.4;
  transition: 0.3s;
  height: 12px;
}

.attr .el-carousel ::v-deep .el-carousel__indicators li:hover {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 0.7;
  height: 12px;
}

.attr .el-carousel ::v-deep .el-carousel__indicators li.is-active {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 1;
  height: 12px;
}

.attr .el-input-number ::v-deep .el-input-number__decrease {
  cursor: pointer;
  z-index: 1;
  display: flex;
  border-color: #DCDFE6;
  border-radius: 0;
  top: 1px;
  left: 1px;
  background: #A8A8A8;
  width: 40px;
  justify-content: center;
  border-width: 0;
  align-items: center;
  position: absolute;
  border-style: solid;
  text-align: center;
  height: 38px;
}

.attr .el-input-number ::v-deep .el-input-number__decrease i {
  color: #666;
  font-size: 14px;
}

.attr .el-input-number ::v-deep .el-input-number__increase {
  cursor: pointer;
  z-index: 1;
  display: flex;
  border-color: #DCDFE6;
  right: 1px;
  border-radius: 0;
  top: 1px;
  background: #A8A8A8;
  width: 40px;
  justify-content: center;
  border-width: 0;
  align-items: center;
  position: absolute;
  border-style: solid;
  text-align: center;
  height: 38px;
}

.attr .el-input-number ::v-deep .el-input-number__increase i {
  color: #666;
  font-size: 14px;
}

.attr .el-input-number ::v-deep .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  border-radius: 4px;
  padding: 0 40px;
  outline: none;
  color: #666;
  background: #FFF;
  display: inline-block;
  width: 100%;
  font-size: 14px;
  line-height: 40px;
  text-align: center;
  height: 40px;
}

.detail-preview .detail.el-tabs ::v-deep .el-tabs__header {
  margin: 0;
  background: none;
  border-color: #E4E7ED;
  border-width: 0 0 0px 0;
  border-style: solid;
}

.detail-preview .detail.el-tabs ::v-deep .el-tabs__header .el-tabs__item {
  border: 0;
  padding: 0 30px;
  margin: 0 30px 0 0;
  color: #fff;
  font-weight: 500;
  display: inline-block;
  font-size: 14px;
  line-height: 44px;
  border-radius: 8px;
  background: #170000;
  position: relative;
  list-style: none;
  height: 44px;
}

.detail-preview .detail.el-tabs ::v-deep .el-tabs__header .el-tabs__item:hover {
  border: 0;
  color: #fff;
  background: #ff721b;
}

.detail-preview .detail.el-tabs ::v-deep .el-tabs__header .el-tabs__item.is-active {
  border: 0;
  border-radius: 8px;
  padding: 0 30px;
  margin: 0 30px 0 0;
  color: #fff;
  background: #ff721b;
  line-height: 44px;
  height: 44px;
}

.detail-preview .detail.el-tabs ::v-deep .el-tabs__content {
  padding: 15px;
}

.detail-preview .detail.el-tabs .add ::v-deep .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  width: auto;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.detail-preview .detail.el-tabs .add ::v-deep .el-textarea__inner {
}

.breadcrumb-preview .el-breadcrumb ::v-deep .el-breadcrumb__separator {
  margin: 0 9px;
  color: #fff;
  font-weight: 500;
}

.breadcrumb-preview .el-breadcrumb .item1 ::v-deep .el-breadcrumb__inner a {
  color: #fff;
  display: inline-block;
}

.breadcrumb-preview .el-breadcrumb .item2 ::v-deep .el-breadcrumb__inner a {
  color: #fff;
  display: inline-block;
}

.breadcrumb-preview .el-breadcrumb .item3 ::v-deep .el-breadcrumb__inner a {
  color: #fff;
  display: inline-block;
}

#pagination.el-pagination ::v-deep .el-pagination__total {
  margin: 0 10px 0 0;
  color: #666;
  font-weight: 400;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .btn-prev {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .btn-next {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .btn-prev:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #C0C4CC;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .btn-next:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #C0C4CC;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pager {
  padding: 0;
  margin: 0;
  display: inline-block;
  vertical-align: top;
}

#pagination.el-pagination ::v-deep .el-pager .number {
  cursor: pointer;
  border-radius: 2px;
  padding: 0 4px;
  margin: 0 5px;
  color: #9E9E9E;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pager .number:hover {
  cursor: pointer;
  border-radius: 2px;
  padding: 0 4px;
  margin: 0 5px;
  color: #FF721B;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pager .number.active {
  cursor: default;
  padding: 0 4px;
  margin: 0 5px;
  color: #FF721B;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #f2f2f2;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pagination__sizes {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pagination__sizes .el-input {
  margin: 0 5px;
  width: 100px;
  position: relative;
}

#pagination.el-pagination ::v-deep .el-pagination__sizes .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  cursor: pointer;
  padding: 0 25px 0 8px;
  color: #606266;
  display: inline-block;
  font-size: 13px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pagination__sizes .el-input span.el-input__suffix {
  top: 0;
  position: absolute;
  right: 0;
  height: 100%;
}

#pagination.el-pagination ::v-deep .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
  cursor: pointer;
  color: #C0C4CC;
  width: 25px;
  font-size: 14px;
  line-height: 28px;
  text-align: center;
}

#pagination.el-pagination ::v-deep .el-pagination__jump {
  margin: 0 0 0 24px;
  color: #606266;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pagination__jump .el-input {
  border-radius: 3px;
  padding: 0 2px;
  margin: 0 2px;
  display: inline-block;
  width: 50px;
  font-size: 14px;
  line-height: 18px;
  position: relative;
  text-align: center;
  height: 28px;
}

#pagination.el-pagination ::v-deep .el-pagination__jump .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  cursor: pointer;
  padding: 0 3px;
  color: #606266;
  display: inline-block;
  font-size: 14px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}

.share_view {
  position: fixed;
  right: 0;
  bottom: 20%;
  background: #fff;
  box-shadow: 0 4px 6px rgba(0, 0, 0, .1);

  .share {
    width: 40px;
    height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-bottom: 1px solid #eee;
    cursor: pointer;
  }

  .share:last-of-type {
    border: none;
  }
}


.detail-preview .el-rate ::v-deep .el-rate__item {
  cursor: pointer;
  display: inline-block;
  vertical-align: middle;
  font-size: 0;
  position: relative;
}

.detail-preview .el-rate ::v-deep .el-rate__item .el-rate__icon {
  margin: 0 3px;
  display: block;
  font-size: 18px;
  position: relative;
  transition: .3s;
}

.delivery-map {
  padding: 12px;
  color: #333;
}

.map-actions {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  margin-bottom: 12px;
}

.map-panel {
  position: relative;
  width: 100%;
  min-height: 260px;
  overflow: hidden;
  border: 1px solid #dcdfe6;
  background:
    linear-gradient(90deg, rgba(64, 158, 255, .08) 1px, transparent 1px),
    linear-gradient(rgba(64, 158, 255, .08) 1px, transparent 1px),
    #f7fbff;
  background-size: 36px 36px;
}

.map-line {
  position: absolute;
  left: 14%;
  right: 14%;
  top: 50%;
  height: 4px;
  background: #409eff;
  transform: rotate(-8deg);
  transform-origin: center;
}

.map-point {
  position: absolute;
  z-index: 2;
  width: 36px;
  height: 36px;
  border-radius: 50%;
  color: #fff;
  text-align: center;
  line-height: 36px;
  font-weight: 600;
  box-shadow: 0 4px 10px rgba(0, 0, 0, .18);
}

.pickup {
  left: 12%;
  top: 58%;
  background: #67c23a;
}

.destination {
  right: 12%;
  top: 34%;
  background: #f56c6c;
}

.courier {
  background: #e6a23c;
  transition: all .3s ease;
}

.map-empty {
  position: absolute;
  left: 50%;
  top: 50%;
  color: #909399;
  transform: translate(-50%, -50%);
}

.map-summary {
  margin-top: 12px;
  line-height: 1.8;
}

.map-summary p {
  margin: 0;
}

.legacy-route {
  margin-top: 12px;
}
</style>
