<template>
	<div class="addEdit-block" :style='{"padding":"30px","fontSize":"16px","color":"#666","background":"none"}'>
		<el-form
			:style='{"border":"1px solid #eee","padding":"30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","fontSize":"inherit","borderRadius":"6px","background":"#fff"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'" label="订单号" prop="dingdanhao">
					<el-input v-model="ruleForm.dingdanhao" placeholder="订单号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-else-if="ruleForm.dingdanhao" label="订单号" prop="dingdanhao">
					<el-input v-model="ruleForm.dingdanhao" placeholder="订单号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="快递单号" prop="kuaididanhao">
					<el-input  v-model="ruleForm.kuaididanhao" placeholder="快递单号" clearable  :readonly="ro.kuaididanhao"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="快递单号" prop="kuaididanhao">
					<el-input v-model="ruleForm.kuaididanhao" placeholder="快递单号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="快递名称" prop="kuaidimingcheng">
					<el-input  v-model="ruleForm.kuaidimingcheng" placeholder="快递名称" clearable  :readonly="ro.kuaidimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="快递名称" prop="kuaidimingcheng">
					<el-input v-model="ruleForm.kuaidimingcheng" placeholder="快递名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="upload" v-if="type!='info' && !ro.jietu" label="截图" prop="jietu">
					<file-upload
						tip="点击上传截图"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.jietu?ruleForm.jietu:''"
						@change="jietuUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="upload" v-else-if="ruleForm.jietu" label="截图" prop="jietu">
					<img v-if="ruleForm.jietu.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jietu.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jietu.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="快递类型" prop="kuaidileixing">
					<el-input  v-model="ruleForm.kuaidileixing" placeholder="快递类型" clearable  :readonly="ro.kuaidileixing"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="快递类型" prop="kuaidileixing">
					<el-input v-model="ruleForm.kuaidileixing" placeholder="快递类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="快递备注" prop="kuaidibeizhu">
					<el-input  v-model="ruleForm.kuaidibeizhu" placeholder="快递备注" clearable  :readonly="ro.kuaidibeizhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="快递备注" prop="kuaidibeizhu">
					<el-input v-model="ruleForm.kuaidibeizhu" placeholder="快递备注" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="代取费用" prop="daiqufeiyong">
					<el-input type="number" v-model.number="ruleForm.daiqufeiyong" placeholder="代取费用" clearable  :readonly="ro.daiqufeiyong"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="代取费用" prop="daiqufeiyong">
					<el-input v-model="ruleForm.daiqufeiyong" placeholder="代取费用" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="账号" prop="zhanghao">
					<el-input  v-model="ruleForm.zhanghao" placeholder="账号" clearable  :readonly="ro.zhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="账号" prop="zhanghao">
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="手机" prop="shouji">
					<el-input  v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="取货地址" prop="quhuodizhi">
					<el-input  v-model="ruleForm.quhuodizhi" placeholder="取货地址" clearable  :readonly="ro.quhuodizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="取货地址" prop="quhuodizhi">
					<el-input v-model="ruleForm.quhuodizhi" placeholder="取货地址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="目的地址" prop="mudedizhi">
					<el-input  v-model="ruleForm.mudedizhi" placeholder="目的地址" clearable  :readonly="ro.mudedizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="目的地址" prop="mudedizhi">
					<el-input v-model="ruleForm.mudedizhi" placeholder="目的地址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="配送账号" prop="peisongzhanghao">
					<el-input  v-model="ruleForm.peisongzhanghao" placeholder="配送账号" clearable  :readonly="ro.peisongzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="配送账号" prop="peisongzhanghao">
					<el-input v-model="ruleForm.peisongzhanghao" placeholder="配送账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
					<el-input  v-model="ruleForm.lianxidianhua" placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="select" v-if="type!='info'"  label="快递状态" prop="kuaidizhuangtai">
					<el-select :disabled="ro.kuaidizhuangtai" v-model="ruleForm.kuaidizhuangtai" placeholder="请选择快递状态" >
						<el-option
							v-for="(item,index) in kuaidizhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="快递状态" prop="kuaidizhuangtai">
					<el-input v-model="ruleForm.kuaidizhuangtai"
						placeholder="快递状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="date" v-if="type!='info'" label="接单时间" prop="jiedanshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.jiedanshijian" 
						type="datetime"
						:readonly="ro.jiedanshijian"
						placeholder="接单时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-else-if="ruleForm.jiedanshijian" label="接单时间" prop="jiedanshijian">
					<el-input v-model="ruleForm.jiedanshijian" placeholder="接单时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="配送人" prop="peisongren">
					<el-input  v-model="ruleForm.peisongren" placeholder="配送人" clearable  :readonly="ro.peisongren"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="配送人" prop="peisongren">
					<el-input v-model="ruleForm.peisongren" placeholder="配送人" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-if="type!='info'"  label="路线规划" prop="luxianguihua">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.luxianguihua" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else-if="ruleForm.luxianguihua" label="路线规划" prop="luxianguihua">
                    <span :style='{"fontSize":"inherit","lineHeight":"40px","color":"inherit","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.luxianguihua"></span>
                </el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0","fontSize":"inherit","textAlign":"center"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-dagou" :style='{"margin":"0 2px","fontSize":"inherit","color":"#fff","height":"40px"}'></span>
					保存
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-guanbi1" :style='{"margin":"0 2px","fontSize":"inherit","color":"rgba(86,178,198,1)","height":"40px"}'></span>
					删除
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui" :style='{"margin":"0 2px","fontSize":"inherit","color":"rgba(86,178,198,1)","height":"40px"}'></span>
					退回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				dingdanhao : false,
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
				kuaidizhuangtai : false,
				jiedanshijian : false,
				peisongren : false,
				luxianguihua : false,
				ispay : false,
			},
			
			
			ruleForm: {
				dingdanhao: this.getUUID(),
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
				kuaidizhuangtai: '送货中',
				jiedanshijian: '',
				peisongren: '',
				luxianguihua: '',
			},
		
			kuaidizhuangtaiOptions: [],

			
			rules: {
				dingdanhao: [
				],
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
					{ validator: validateNumber, trigger: 'blur' },
				],
				zhanghao: [
				],
				shouji: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				quhuodizhi: [
				],
				mudedizhi: [
				],
				peisongzhanghao: [
					{ required: true, message: '配送账号不能为空', trigger: 'blur' },
				],
				lianxidianhua: [
					{ required: true, message: '联系电话不能为空', trigger: 'blur' },
				],
				kuaidizhuangtai: [
					{ required: true, message: '快递状态不能为空', trigger: 'blur' },
				],
				jiedanshijian: [
				],
				peisongren: [
				],
				luxianguihua: [
					{ required: true, message: '路线规划不能为空', trigger: 'blur' },
				],
				ispay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.jiedanshijian = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='dingdanhao'){
							this.ruleForm.dingdanhao = obj[o];
							this.ro.dingdanhao = true;
							continue;
						}
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
							this.ruleForm.jietu = obj[o];
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
						if(o=='kuaidizhuangtai'){
							this.ruleForm.kuaidizhuangtai = obj[o];
							this.ro.kuaidizhuangtai = true;
							continue;
						}
						if(o=='jiedanshijian'){
							this.ruleForm.jiedanshijian = obj[o];
							this.ro.jiedanshijian = true;
							continue;
						}
						if(o=='peisongren'){
							this.ruleForm.peisongren = obj[o];
							this.ro.peisongren = true;
							continue;
						}
						if(o=='luxianguihua'){
							this.ruleForm.luxianguihua = obj[o];
							this.ro.luxianguihua = true;
							continue;
						}
				}
				














				this.ruleForm.kuaidizhuangtai = '送货中' 



			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.peisongzhanghao!=''&&json.peisongzhanghao) || json.peisongzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.peisongzhanghao = json.peisongzhanghao
						this.ro.peisongzhanghao = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.peisongzhanghao = true;
					}
					if(((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.lianxidianhua = json.lianxidianhua
						this.ro.lianxidianhua = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.lianxidianhua = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.kuaidizhuangtai = true;
					}
					if(((json.peisongren!=''&&json.peisongren) || json.peisongren==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.peisongren = json.peisongren
						this.ro.peisongren = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.kuaidizhuangtaiOptions = "已送达,送货中".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jiedanxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.luxianguihua = this.ruleForm.luxianguihua.replace(reg,'../../../springbootfa427577/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
		if(this.ruleForm.dingdanhao) {
			this.ruleForm.dingdanhao = String(this.ruleForm.dingdanhao)
		}




	if(this.ruleForm.jietu!=null) {
		this.ruleForm.jietu = this.ruleForm.jietu.replace(new RegExp(this.$base.url,"g"),"");
	}















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "jiedanxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `jiedanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.jiedanxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `jiedanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.jiedanxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jiedanxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    jietuUploadChange(fileUrls) {
	    this.ruleForm.jietu = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: inherit;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  	  border: 0;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 50%, 98% 99%, 0% 100%, 0% 0%);
	  	  color: inherit;
	  	  background: rgba(86,178,198,.2);
	  	  width: 400px;
	  	  font-size: inherit;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  	  border: 0;
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(96% 0, 100% 50%, 96% 99%, 0% 100%, 0% 0%);
	  	  color: inherit;
	  	  background: rgba(86,178,198,.2);
	  	  width: 200px;
	  	  font-size: inherit;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  	  border: 0;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(96% 0, 100% 50%, 96% 99%, 0% 100%, 0% 0%);
	  	  color: inherit;
	  	  background: rgba(86,178,198,.2);
	  	  width: 200px;
	  	  font-size: inherit;
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
	  	  border: 0px solid rgba(230, 230, 230, 1);
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  clip-path: polygon(96% 0, 100% 50%, 96% 99%, 0% 100%, 0% 0%);
	  	  color: inherit;
	  	  background: rgba(86,178,198,.2);
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  	  border: 0px solid rgba(230, 230, 230, 1);
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  clip-path: polygon(96% 0, 100% 50%, 96% 99%, 0% 100%, 0% 0%);
	  	  color: inherit;
	  	  background: rgba(86,178,198,.2);
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  	  border: 0px solid rgba(230, 230, 230, 1);
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  clip-path: polygon(96% 0, 100% 50%, 96% 99%, 0% 100%, 0% 0%);
	  	  color: inherit;
	  	  background: rgba(86,178,198,.2);
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  	  border: 0;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(96% 0, 100% 50%, 96% 99%, 0% 100%, 0% 0%);
	  	  color: inherit;
	  	  background: rgba(86,178,198,.2);
	  	  width: 500px;
	  	  font-size: inherit;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				color: #fff;
				background: rgba(86,178,198,.8);
				width: auto;
				font-size: inherit;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				color: #fff;
				background: rgba(86,178,198,.8);
				width: auto;
				font-size: inherit;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				color: #fff;
				background: rgba(86,178,198,.8);
				width: auto;
				font-size: inherit;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				color: rgba(86,178,198,1);
				background: rgba(86,178,198,.3);
				width: auto;
				font-size: inherit;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				clip-path: polygon(0% 0%, 95% 0, 100% 50%, 95% 100%, 0% 100%);
				color: rgba(86,178,198,1);
				background: rgba(86,178,198,.3);
				width: auto;
				font-size: inherit;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
