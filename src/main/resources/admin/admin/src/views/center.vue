<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="居民号" prop="juminhao">
          <el-input v-model="ruleForm.juminhao" readonly              placeholder="居民号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="居民姓名" prop="juminxingming">
          <el-input v-model="ruleForm.juminxingming"               placeholder="居民姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='jumin'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in juminxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='jumin'" label="居民照片" prop="juminzhaopian">
          <file-upload
          tip="点击上传居民照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.juminzhaopian?ruleForm.juminzhaopian:''"
          @change="juminjuminzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="居民手机" prop="juminshouji">
          <el-input v-model="ruleForm.juminshouji"               placeholder="居民手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="居住地址" prop="juzhudizhi">
          <el-input v-model="ruleForm.juzhudizhi"               placeholder="居住地址" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="门牌号" prop="menpaihao">
          <el-input v-model="ruleForm.menpaihao"               placeholder="门牌号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="单元号" prop="danyuanhao">
          <el-input v-model="ruleForm.danyuanhao"               placeholder="单元号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      juminxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.juminxingbieOptions = "男,女".split(',')
  },
  methods: {
    juminjuminzhaopianUploadChange(fileUrls) {
        this.ruleForm.juminzhaopian = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.juminhao)&& 'jumin'==this.flag){
        this.$message.error('居民号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'jumin'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'jumin' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
        if(this.ruleForm.juminzhaopian!=null) {
                this.ruleForm.juminzhaopian = this.ruleForm.juminzhaopian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'jumin' ==this.flag && this.ruleForm.juminshouji&&(!isMobile(this.ruleForm.juminshouji))){
        this.$message.error(`居民手机应输入手机格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
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
</style>
