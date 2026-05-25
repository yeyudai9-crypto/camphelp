<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20240118/7a90d739918844fd901258271df346a4.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"width":"600px","padding":"20px","margin":"0","position":"relative","borderRadius":"10px","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 30px 0","lineHeight":"44px","fontSize":"30px","color":"#fff","textAlign":"center"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"width":"100%","margin":"0 0 30px","lineHeight":"44px","fontSize":"30px","color":"#fff","textAlign":"center"}'>基于SpringBoot校园快递代取系统注册</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="zhanghao">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('zhanghao')?'required':''">账号：</div>
				<el-input v-model="registerForm.zhanghao"  placeholder="请输入账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingming">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('xingming')?'required':''">姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="shouji">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('shouji')?'required':''">手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="dizhi">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('dizhi')?'required':''">地址：</div>
				<el-input v-model="registerForm.dizhi"  placeholder="请输入地址" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="shenfen">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('shenfen')?'required':''">身份：</div>
                <el-select v-model="registerForm.shenfen" placeholder="请选择身份" >
                  <el-option
                      v-for="(item,index) in yonghushenfenOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='peisongyuan'" prop="peisongzhanghao">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('peisongzhanghao')?'required':''">配送账号：</div>
				<el-input v-model="registerForm.peisongzhanghao"  placeholder="请输入配送账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='peisongyuan'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='peisongyuan'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='peisongyuan'" prop="peisongren">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('peisongren')?'required':''">配送人：</div>
				<el-input v-model="registerForm.peisongren"  placeholder="请输入配送人" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='peisongyuan'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in peisongyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='peisongyuan'" prop="lianxidianhua">
				<div v-if="true" :style='{"padding":"0 10px 0 0","color":"#fff","textAlign":"right","display":"inline-block","width":"120px","lineHeight":"44px","fontSize":"14px"}' :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","color":"#fff","bottom":"70px","display":"block","right":"-400px","outline":"none","borderRadius":"0px","background":"rgba(255,255,255,0.3)","width":"343px","fontSize":"26px","position":"absolute","height":"60px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 6px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#fff","display":"none","outline":"none","borderRadius":"8px","background":"rgba(64, 158, 255, 1)","width":"80%","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","color":"#fff","bottom":"50px","display":"inline-block","lineHeight":"1","fontSize":"12px","textDecoration":"none","position":"absolute","right":"-350px"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            yonghushenfenOptions: [],
            peisongyuanxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					zhanghao: '',
					xingming: '',
					mima: '',
					mima2: '',
					xingbie: '',
					shouji: '',
					touxiang: 'upload/yonghu_touxiang1.jpg',
					dizhi: '',
					shenfen: '',
				}
			}
			if(this.tableName=='peisongyuan'){
				this.registerForm = {
					peisongzhanghao: '',
					mima: '',
					mima2: '',
					peisongren: '',
					xingbie: '',
					touxiang: 'upload/peisongyuan_touxiang1.jpg',
					lianxidianhua: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.shenfen = [{ required: true, message: '请输入身份', trigger: 'blur' }]
			}
			if ('peisongyuan' == this.tableName) {
				this.requiredRules.peisongzhanghao = [{ required: true, message: '请输入配送账号', trigger: 'blur' }]
			}
			if ('peisongyuan' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('peisongyuan' == this.tableName) {
				this.requiredRules.peisongren = [{ required: true, message: '请输入配送人', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		this.tableName = this.$route.query.role;
		if(this.$route.query.pageFlag=='register'){
		  if ('yonghu' == this.tableName) {
			this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
			this.yonghuxingbieOptions = "男,女".split(',');
		  if ('yonghu' == this.tableName) {
			this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
			this.yonghushenfenOptions = "学生,老师".split(',');
		  if ('yonghu' == this.tableName) {
			this.rules.shenfen = [{ required: true, message: '请输入身份', trigger: 'blur' }];
		  }
		  if ('peisongyuan' == this.tableName) {
			this.rules.peisongzhanghao = [{ required: true, message: '请输入配送账号', trigger: 'blur' }];
		  }
		  if ('peisongyuan' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('peisongyuan' == this.tableName) {
			this.rules.peisongren = [{ required: true, message: '请输入配送人', trigger: 'blur' }];
		  }
			this.peisongyuanxingbieOptions = "男,女".split(',');
		  if ('peisongyuan' == this.tableName) {
			this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      peisongyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.zhanghao) && `yonghu` == this.tableName){
					this.$message.error(`账号不能为空`);
					return
				}
				if((!this.registerForm.xingming) && `yonghu` == this.tableName){
					this.$message.error(`姓名不能为空`);
					return
				}
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
				if((!this.registerForm.shenfen) && `yonghu` == this.tableName){
					this.$message.error(`身份不能为空`);
					return
				}
				if((!this.registerForm.peisongzhanghao) && `peisongyuan` == this.tableName){
					this.$message.error(`配送账号不能为空`);
					return
				}
               if(`peisongyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `peisongyuan` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.peisongren) && `peisongyuan` == this.tableName){
					this.$message.error(`配送人不能为空`);
					return
				}
					if(`peisongyuan` == this.tableName && this.registerForm.lianxidianhua &&(!this.$validate.isMobile2(this.registerForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            }).catch(() => {
              this.$message.error('后端服务未启动或连接失败，请先启动 Spring Boot 服务');
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20240118/7a90d739918844fd901258271df346a4.jpg);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item ::v-deep .el-form-item__content {
						display: flex;
					}
		
		.rgs-form .el-input ::v-deep .el-input__inner {
						border: 3px solid #fff;
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: inset 0px 0px 16px 0px #332001;
						outline: none;
						color: #fff;
						background: transparent;
						width: 100%;
						font-size: 14px;
						min-width: 400px;
						height: 44px;
					}
		
		.rgs-form .el-select ::v-deep .el-input__inner {
						border: 3px solid #fff;
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: inset 0px 0px 16px 0px #332001;
						outline: none;
						color: #fff;
						background: transparent;
						width: 100%;
						font-size: 14px;
						min-width: 400px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border: 3px solid #fff;
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: inset 0px 0px 16px 0px #332001;
						outline: none;
						color: #fff;
						background: transparent;
						width: 100%;
						font-size: 14px;
						min-width: 400px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border: 3px solid #fff;
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: inset 0px 0px 16px 0px #332001;
						outline: none;
						color: #fff;
						background: transparent;
						width: 100%;
						font-size: 14px;
						min-width: 400px;
						height: 44px;
					}
		
		.rgs-form ::v-deep .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form ::v-deep .upload .upload-img {
		  		  border: 3px solid #fff;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #fff;
		  		  background: rgba(255,255,255,0);
		  		  width: 120px;
		  		  font-size: 24px;
		  		  line-height: 56px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form ::v-deep .el-upload-list .el-upload-list__item {
		  		  border: 3px solid #fff;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #fff;
		  		  background: rgba(255,255,255,0);
		  		  width: 120px;
		  		  font-size: 24px;
		  		  line-height: 56px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form ::v-deep .el-upload .el-icon-plus {
		  		  border: 3px solid #fff;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #fff;
		  		  background: rgba(255,255,255,0);
		  		  width: 120px;
		  		  font-size: 24px;
		  		  line-height: 56px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 110px;
				position: absolute;
				content: "*";
			}
</style>
