<template>
<div :style='{"width":"60%","padding":"20px","margin":"0 auto","overflow":"hidden","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"width":"100%","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","padding":"30px 40px 40px","margin":"20px auto 40px","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="快递单号" prop="kuaididanhao">
            <el-input  v-model="ruleForm.kuaididanhao" 
                placeholder="快递单号" clearable :disabled=" false  ||ro.kuaididanhao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="快递名称" prop="kuaidimingcheng">
            <el-input  v-model="ruleForm.kuaidimingcheng" 
                placeholder="快递名称" clearable :disabled=" false  ||ro.kuaidimingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="截图" v-if="type!='cross' || (type=='cross' && !ro.jietu)" prop="jietu">
            <file-upload
            tip="点击上传截图"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.jietu?ruleForm.jietu:''"
            @change="jietuUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' class="upload" v-else label="截图" prop="jietu">
                <img v-if="ruleForm.jietu.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jietu.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jietu.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="快递类型" prop="kuaidileixing">
            <el-input  v-model="ruleForm.kuaidileixing" 
                placeholder="快递类型" clearable :disabled=" false  ||ro.kuaidileixing"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="快递备注" prop="kuaidibeizhu">
            <el-input  v-model="ruleForm.kuaidibeizhu" 
                placeholder="快递备注" clearable :disabled=" false  ||ro.kuaidibeizhu"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="代取费用" prop="daiqufeiyong">
            <el-input type="number" v-model.number="ruleForm.daiqufeiyong" 
                placeholder="代取费用" clearable :disabled=" false  ||ro.daiqufeiyong"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="账号" prop="zhanghao">
            <el-input  v-model="ruleForm.zhanghao" 
                placeholder="账号" clearable :disabled=" false  ||ro.zhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="手机" prop="shouji">
            <el-input  v-model="ruleForm.shouji" 
                placeholder="手机" clearable :disabled=" false  ||ro.shouji"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="取货地址" prop="quhuodizhi">
            <el-input  v-model="ruleForm.quhuodizhi" 
                placeholder="取货地址" clearable :disabled=" false  ||ro.quhuodizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="目的地址" prop="mudedizhi">
            <el-input  v-model="ruleForm.mudedizhi" 
                placeholder="目的地址" clearable :disabled=" false  ||ro.mudedizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="配送账号" prop="peisongzhanghao">
            <el-input  v-model="ruleForm.peisongzhanghao" 
                placeholder="配送账号" clearable :disabled=" false  ||ro.peisongzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="联系电话" prop="lianxidianhua">
            <el-input  v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable :disabled=" false  ||ro.lianxidianhua"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="评价时间" prop="pingjiashijian">
              <el-date-picker
				  :disabled=" false  ||ro.pingjiashijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.pingjiashijian" 
                  type="datetime"
                  placeholder="评价时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}'  label="评分" prop="pingfen">
            <el-select v-model="ruleForm.pingfen" placeholder="请选择评分"  >
              <el-option
                  v-for="(item,index) in pingfenOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"45%","padding":"10px","margin":"0 2% 10px","background":"#fff","display":"inline-block"}' label="评价" prop="pingjia">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="评价"
              v-model="ruleForm.pingjia">
            </el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#ff721b","width":"110px","lineHeight":"36px","fontSize":"14px","height":"36px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid #ff721b","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#170000","width":"110px","lineHeight":"36px","fontSize":"14px","height":"36px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            kuaididanhao : false,
            kuaidimingcheng : false,
            jietu : false,
            kuaidileixing : false,
            kuaidibeizhu : false,
            daiqufeiyong : false,
            zhanghao : false,
            shouji : false,
            quhuodizhi : false,
            mudedizhi : false,
            peisongzhanghao : false,
            lianxidianhua : false,
            pingjiashijian : false,
            pingfen : false,
            pingjia : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          kuaididanhao: '',
          kuaidimingcheng: '',
          jietu: '',
          kuaidileixing: '',
          kuaidibeizhu: '',
          daiqufeiyong: '',
          zhanghao: '',
          shouji: '',
          quhuodizhi: '',
          mudedizhi: '',
          peisongzhanghao: '',
          lianxidianhua: '',
          pingjiashijian: '',
          pingfen: '',
          pingjia: '',
        },
        pingfenOptions: [],


        rules: {
          kuaididanhao: [
            { required: true, message: '快递单号不能为空', trigger: 'blur' },
          ],
          kuaidimingcheng: [
          ],
          jietu: [
          ],
          kuaidileixing: [
          ],
          kuaidibeizhu: [
          ],
          daiqufeiyong: [
            { required: true, message: '代取费用不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          zhanghao: [
          ],
          shouji: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          quhuodizhi: [
          ],
          mudedizhi: [
          ],
          peisongzhanghao: [
          ],
          lianxidianhua: [
          ],
          pingjiashijian: [
            { required: true, message: '评价时间不能为空', trigger: 'blur' },
          ],
          pingfen: [
            { required: true, message: '评分不能为空', trigger: 'blur' },
          ],
          pingjia: [
            { required: true, message: '评价不能为空', trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='kuaididanhao'){
              this.ruleForm.kuaididanhao = obj[o];
              this.ro.kuaididanhao = true;
              continue;
            }
            if(o=='kuaidimingcheng'){
              this.ruleForm.kuaidimingcheng = obj[o];
              this.ro.kuaidimingcheng = true;
              continue;
            }
            if(o=='jietu'){
              this.ruleForm.jietu = obj[o].split(",")[0];
              this.ro.jietu = true;
              continue;
            }
            if(o=='kuaidileixing'){
              this.ruleForm.kuaidileixing = obj[o];
              this.ro.kuaidileixing = true;
              continue;
            }
            if(o=='kuaidibeizhu'){
              this.ruleForm.kuaidibeizhu = obj[o];
              this.ro.kuaidibeizhu = true;
              continue;
            }
            if(o=='daiqufeiyong'){
              this.ruleForm.daiqufeiyong = obj[o];
              this.ro.daiqufeiyong = true;
              continue;
            }
            if(o=='zhanghao'){
              this.ruleForm.zhanghao = obj[o];
              this.ro.zhanghao = true;
              continue;
            }
            if(o=='shouji'){
              this.ruleForm.shouji = obj[o];
              this.ro.shouji = true;
              continue;
            }
            if(o=='quhuodizhi'){
              this.ruleForm.quhuodizhi = obj[o];
              this.ro.quhuodizhi = true;
              continue;
            }
            if(o=='mudedizhi'){
              this.ruleForm.mudedizhi = obj[o];
              this.ro.mudedizhi = true;
              continue;
            }
            if(o=='peisongzhanghao'){
              this.ruleForm.peisongzhanghao = obj[o];
              this.ro.peisongzhanghao = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='pingjiashijian'){
              this.ruleForm.pingjiashijian = obj[o];
              this.ro.pingjiashijian = true;
              continue;
            }
            if(o=='pingfen'){
              this.ruleForm.pingfen = obj[o];
              this.ro.pingfen = true;
              continue;
            }
            if(o=='pingjia'){
              this.ruleForm.pingjia = obj[o];
              this.ro.pingjia = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.pingfenOptions = "★,★★,★★★,★★★★,★★★★★".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`daiqupingjia/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('daiqupingjia/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'success',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`daiqupingjia/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`daiqupingjia/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      jietuUploadChange(fileUrls) {
          this.ruleForm.jietu = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  border: 1px solid #999;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #000;
	  width: 300px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  border: 1px solid #999;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #000;
	  width: auto;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  border: 1px solid #999;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #000;
	  width: auto;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview ::v-deep .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview ::v-deep .upload .upload-img {
	  border: 1px solid #666;
	  cursor: pointer;
	  border-radius: 30px;
	  color: #000;
	  width: 150px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  border: 1px solid #666;
	  cursor: pointer;
	  border-radius: 30px;
	  color: #000;
	  width: 150px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  border: 1px solid #666;
	  cursor: pointer;
	  border-radius: 30px;
	  color: #000;
	  width: 150px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  border: 1px solid #999;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
