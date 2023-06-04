<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >

      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="EventName" prop="huodongmingcheng">
          <el-input v-model="ruleForm.huodongmingcheng" 
              placeholder="EventName" clearable  :readonly="ro.huodongmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="EventName" prop="huodongmingcheng">
              <el-input v-model="ruleForm.huodongmingcheng" 
                placeholder="EventName" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="Type" prop="huodongleixing">
          <el-input v-model="ruleForm.huodongleixing" 
              placeholder="Type" clearable  :readonly="ro.huodongleixing"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="Type" prop="huodongleixing">
              <el-input v-model="ruleForm.huodongleixing" 
                placeholder="Type" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="Location" prop="huodongdidian">
          <el-input v-model="ruleForm.huodongdidian" 
              placeholder="Location" clearable  :readonly="ro.huodongdidian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="Location" prop="huodongdidian">
              <el-input v-model="ruleForm.huodongdidian" 
                placeholder="Location" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="StartTime" prop="kaishishijian">
          <el-input v-model="ruleForm.kaishishijian" 
              placeholder="StartTime" clearable  :readonly="ro.kaishishijian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="StartTime" prop="kaishishijian">
              <el-input v-model="ruleForm.kaishishijian" 
                placeholder="StartTime" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="End" prop="jieshushijian">
          <el-input v-model="ruleForm.jieshushijian" 
              placeholder="EndTime" clearable  :readonly="ro.jieshushijian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="EndTime" prop="jieshushijian">
              <el-input v-model="ruleForm.jieshushijian" 
                placeholder="EndTime" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="RegisterDeadline" prop="baomingjiezhi">
          <el-input v-model="ruleForm.baomingjiezhi" 
              placeholder="RegisterDeadline" clearable  :readonly="ro.baomingjiezhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="RegisterDeadline" prop="baomingjiezhi">
              <el-input v-model="ruleForm.baomingjiezhi" 
                placeholder="RegisterDeadline" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="NumberOfApplicants" prop="baomingrenshu">
          <el-input v-model="ruleForm.baomingrenshu" 
              placeholder="NumberOfApplicants" clearable  :readonly="ro.baomingrenshu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="NumberOfApplicants" prop="baomingrenshu">
              <el-input v-model="ruleForm.baomingrenshu" 
                placeholder="NumberOfApplicants" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="contactperson" prop="lianxiren">
          <el-input v-model="ruleForm.lianxiren" 
              placeholder="contactperson" clearable  :readonly="ro.lianxiren"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="contactperson" prop="lianxiren">
              <el-input v-model="ruleForm.lianxiren" 
                placeholder="contactperson" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="contactPhone" prop="lianluodianhua">
          <el-input v-model="ruleForm.lianluodianhua" 
              placeholder="contactPhone" clearable  :readonly="ro.lianluodianhua"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="contactPhone" prop="lianluodianhua">
              <el-input v-model="ruleForm.lianluodianhua" 
                placeholder="contactPhone" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="ID" prop="juminhao">
          <el-input v-model="ruleForm.juminhao" 
              placeholder="ID" clearable  :readonly="ro.juminhao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="ID" prop="juminhao">
              <el-input v-model="ruleForm.juminhao" 
                placeholder="ID" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="Name" prop="juminxingming">
          <el-input v-model="ruleForm.juminxingming" 
              placeholder="Name" clearable  :readonly="ro.juminxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="Name" prop="juminxingming">
              <el-input v-model="ruleForm.juminxingming" 
                placeholder="Name" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="Mobile" prop="juminshouji">
          <el-input v-model="ruleForm.juminshouji" 
              placeholder="Mobile" clearable  :readonly="ro.juminshouji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="Mobile" prop="juminshouji">
              <el-input v-model="ruleForm.juminshouji" 
                placeholder="Mobile" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="Reason for cancel" prop="quxiaoyuanyin">
          <el-input v-model="ruleForm.quxiaoyuanyin" 
              placeholder="Reason for cancel" clearable  :readonly="ro.quxiaoyuanyin"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="Reason for cancel" prop="quxiaoyuanyin">
              <el-input v-model="ruleForm.quxiaoyuanyin" 
                placeholder="Reason for cancel" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="cancel time" prop="quxiaoshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.quxiaoshijian" 
                type="datetime"
                :readonly="ro.quxiaoshijian"
                placeholder="cancel time">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.quxiaoshijian" label="cancel time" prop="quxiaoshijian">
              <el-input v-model="ruleForm.quxiaoshijian" 
                placeholder="cancel time" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
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
	  addEditForm: {"btnSaveFontColor":"rgba(0, 0, 0, 1)","selectFontSize":"14px","btnCancelBorderColor":"rgba(193, 193, 193, 1)","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"40px 40px 0 40px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"rgba(255, 255, 255, 0)","dateIconFontSize":"14px","btnSaveBgColor":"rgba(227, 201, 176, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"rgba(243, 243, 243, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"40px 40px 0 40px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"4px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"rgba(194, 161, 49, 1)","btnSaveBorderWidth":"4px"},
      id: '',
      type: '',
      ro:{
	huodongmingcheng : false,
	huodongleixing : false,
	huodongdidian : false,
	kaishishijian : false,
	jieshushijian : false,
	baomingjiezhi : false,
	baomingrenshu : false,
	lianxiren : false,
	lianluodianhua : false,
	juminhao : false,
	juminxingming : false,
	juminshouji : false,
	quxiaoyuanyin : false,
	quxiaoshijian : false,
	crossuserid : false,
	crossrefid : false,
	sfsh : false,
	shhf : false,
      },
      ruleForm: {
        huodongmingcheng: '',
        huodongleixing: '',
        huodongdidian: '',
        kaishishijian: '',
        jieshushijian: '',
        baomingjiezhi: '',
        baomingrenshu: '',
        lianxiren: '',
        lianluodianhua: '',
        juminhao: '',
        juminxingming: '',
        juminshouji: '',
        quxiaoyuanyin: '',
        quxiaoshijian: '',
        crossuserid: '',
        crossrefid: '',
        shhf: '',
      },
      rules: {
          huodongmingcheng: [
                { required: true, message: '活动名称不能为空', trigger: 'blur' },
          ],
          huodongleixing: [
          ],
          huodongdidian: [
                { required: true, message: 'Location不能为空', trigger: 'blur' },
          ],
          kaishishijian: [
          ],
          jieshushijian: [
          ],
          baomingjiezhi: [
          ],
          baomingrenshu: [
                { validator: validateIntNumber, trigger: 'blur' },
          ],
          lianxiren: [
          ],
          lianluodianhua: [
                { validator: validateMobile, trigger: 'blur' },
          ],
          juminhao: [
          ],
          juminxingming: [
          ],
          juminshouji: [
          ],
          quxiaoyuanyin: [
                { required: true, message: '取消原因不能为空', trigger: 'blur' },
          ],
          quxiaoshijian: [
          ],
          crossuserid: [
          ],
          crossrefid: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {



  },
  created() {
	this.ruleForm.quxiaoshijian = this.getCurDateTime()

	this.addEditStyleChange()
	this.addEditUploadStyleChange()
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
          if(o=='huodongmingcheng'){
            this.ruleForm.huodongmingcheng = obj[o];
	    this.ro.huodongmingcheng = true;
            continue;
          }
          if(o=='huodongleixing'){
            this.ruleForm.huodongleixing = obj[o];
	    this.ro.huodongleixing = true;
            continue;
          }
          if(o=='huodongdidian'){
            this.ruleForm.huodongdidian = obj[o];
	    this.ro.huodongdidian = true;
            continue;
          }
          if(o=='kaishishijian'){
            this.ruleForm.kaishishijian = obj[o];
	    this.ro.kaishishijian = true;
            continue;
          }
          if(o=='jieshushijian'){
            this.ruleForm.jieshushijian = obj[o];
	    this.ro.jieshushijian = true;
            continue;
          }
          if(o=='baomingjiezhi'){
            this.ruleForm.baomingjiezhi = obj[o];
	    this.ro.baomingjiezhi = true;
            continue;
          }
          if(o=='baomingrenshu'){
            this.ruleForm.baomingrenshu = obj[o];
	    this.ro.baomingrenshu = true;
            continue;
          }
          if(o=='lianxiren'){
            this.ruleForm.lianxiren = obj[o];
	    this.ro.lianxiren = true;
            continue;
          }
          if(o=='lianluodianhua'){
            this.ruleForm.lianluodianhua = obj[o];
	    this.ro.lianluodianhua = true;
            continue;
          }
          if(o=='juminhao'){
            this.ruleForm.juminhao = obj[o];
	    this.ro.juminhao = true;
            continue;
          }
          if(o=='juminxingming'){
            this.ruleForm.juminxingming = obj[o];
	    this.ro.juminxingming = true;
            continue;
          }
          if(o=='juminshouji'){
            this.ruleForm.juminshouji = obj[o];
	    this.ro.juminshouji = true;
            continue;
          }
          if(o=='quxiaoyuanyin'){
            this.ruleForm.quxiaoyuanyin = obj[o];
	    this.ro.quxiaoyuanyin = true;
            continue;
          }
          if(o=='quxiaoshijian'){
            this.ruleForm.quxiaoshijian = obj[o];
	    this.ro.quxiaoshijian = true;
            continue;
          }
          if(o=='crossuserid'){
            this.ruleForm.crossuserid = obj[o];
	    this.ro.crossuserid = true;
            continue;
          }
          if(o=='crossrefid'){
            this.ruleForm.crossrefid = obj[o];
	    this.ro.crossrefid = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `quxiaobaoming/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {





































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
                       if(!statusColumnName.startsWith("[")) {
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
				url: "quxiaobaoming/page", 
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
					   url: `quxiaobaoming/${!this.ruleForm.id ? "save" : "update"}`,
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
						 this.parent.quxiaobaomingCrossAddOrUpdateFlag = false;
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
			   url: `quxiaobaoming/${!this.ruleForm.id ? "save" : "update"}`,
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
				 this.parent.quxiaobaomingCrossAddOrUpdateFlag = false;
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
      this.parent.quxiaobaomingCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
