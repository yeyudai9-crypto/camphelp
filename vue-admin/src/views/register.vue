<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230830/25e4efeaf5f14216b2e7e70a43d1c06e.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center top","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"0px solid #eee","minHeight":"690px","padding":"100px 60px 20px 600px","boxShadow":"0 0px 0px rgba(64, 158, 255, .6)","margin":"0","borderRadius":"10px","color":"#999","background":"url(http://codegen.caihongy.cn/20230801/017937c712194d5e8a38f9bca47c4a73.png) no-repeat center top / 100% 100%","width":"1200px","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"10px","margin":"0 auto 30px","color":"#56b2c6","textAlign":"center","background":"none","width":"96%","lineHeight":"40px","fontSize":"24px","textShadow":"4px 4px 2px rgba(64, 158, 255, .1)"}' class="title">基于地理位置的校园代取系统注册</div>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('zhanghao')?'required':''">账号：</div>
					<el-input  v-model="ruleForm.zhanghao"  autocomplete="off" placeholder="账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yonghuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yonghutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('dizhi')?'required':''">地址：</div>
					<el-input  v-model="ruleForm.dizhi"  autocomplete="off" placeholder="地址"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('shenfen')?'required':''">身份：</div>
                    <el-select v-model="ruleForm.shenfen" placeholder="请选择身份" >
                        <el-option
                            v-for="(item,index) in yonghushenfenOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='peisongyuan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('peisongzhanghao')?'required':''">配送账号：</div>
					<el-input  v-model="ruleForm.peisongzhanghao"  autocomplete="off" placeholder="配送账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='peisongyuan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='peisongyuan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='peisongyuan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('peisongren')?'required':''">配送人：</div>
					<el-input  v-model="ruleForm.peisongren"  autocomplete="off" placeholder="配送人"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='peisongyuan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in peisongyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='peisongyuan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="peisongyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0 100px","margin":"0 auto 10px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='peisongyuan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"inherit","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 24px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px auto 10px","color":"#fff","display":"block","outline":"none","borderRadius":"30px","background":"#56b2c6","width":"200px","fontSize":"16px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","color":"rgba(159, 159, 159, 1)","textAlign":"right","display":"inline-block","width":"80%","lineHeight":"1","fontSize":"14px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
            yonghushenfenOptions: [],
            peisongyuanxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					zhanghao: '',
					xingming: '',
					mima: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
					dizhi: '',
					shenfen: '',
				}
			}
			if(this.tableName=='peisongyuan'){
				this.ruleForm = {
					peisongzhanghao: '',
					mima: '',
					peisongren: '',
					xingbie: '',
					touxiang: '',
					lianxidianhua: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.shenfen = [{ required: true, message: '请输入身份', trigger: 'blur' }]
			}
			if ('peisongyuan' == this.tableName) {
				this.rules.peisongzhanghao = [{ required: true, message: '请输入配送账号', trigger: 'blur' }]
			}
			if ('peisongyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('peisongyuan' == this.tableName) {
				this.rules.peisongren = [{ required: true, message: '请输入配送人', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
			this.yonghushenfenOptions = "学生,老师".split(',')
			this.peisongyuanxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        peisongyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
						this.$message.error(`账号不能为空`);
						return
					}
					if((!this.ruleForm.xingming) && `yonghu` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `yonghu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`yonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if((!this.ruleForm.shenfen) && `yonghu` == this.tableName){
						this.$message.error(`身份不能为空`);
						return
					}
					if((!this.ruleForm.peisongzhanghao) && `peisongyuan` == this.tableName){
						this.$message.error(`配送账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `peisongyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `peisongyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.peisongren) && `peisongyuan` == this.tableName){
						this.$message.error(`配送人不能为空`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`peisongyuan` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20230830/25e4efeaf5f14216b2e7e70a43d1c06e.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: inherit;
						background: none;
						width: calc(100% - 0px);
						font-size: 14px;
						border-color: #e0e0e0;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-select ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: inherit;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #e0e0e0;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: inherit;
						background: none;
						width: 288px;
						font-size: 14px;
						border-color: #e0e0e0;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: inherit;
						background: none;
						width: 288px;
						font-size: 14px;
						border-color: #e0e0e0;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
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
		  		  border: 2px solid #e0e0e0;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: inherit;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form ::v-deep .el-upload-list .el-upload-list__item {
		  		  border: 2px solid #e0e0e0;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: inherit;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form ::v-deep .el-upload .el-icon-plus {
		  		  border: 2px solid #e0e0e0;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: inherit;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 5px;
				content: "*";
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
