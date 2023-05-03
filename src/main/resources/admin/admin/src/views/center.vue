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
        <el-form-item   v-if="flag=='jumin'"  label="Resident ID" prop="juminhao">
          <el-input v-model="ruleForm.juminhao" readonly              placeholder="Resident ID" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="Resident name" prop="juminxingming">
          <el-input v-model="ruleForm.juminxingming"               placeholder="Resident name" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='jumin'"  label="gender" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="please choose gender">
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
        <el-form-item   v-if="flag=='jumin'"  label="Age" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="Age" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='jumin'" label="Resident photo" prop="juminzhaopian">
          <file-upload
          tip="upload photo"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.juminzhaopian?ruleForm.juminzhaopian:''"
          @change="juminjuminzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="Resident phone" prop="juminshouji">
          <el-input v-model="ruleForm.juminshouji"               placeholder="Resident phone" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="Resident address" prop="juzhudizhi">
          <el-input v-model="ruleForm.juzhudizhi"               placeholder="Resident address" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="room number" prop="menpaihao">
          <el-input v-model="ruleForm.menpaihao"               placeholder="room number" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jumin'"  label="unit" prop="danyuanhao">
          <el-input v-model="ruleForm.danyuanhao"               placeholder="unit" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="username" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="username"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">change</el-button>
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
    this.juminxingbieOptions = "male,female".split(',')
  },
  methods: {
    juminjuminzhaopianUploadChange(fileUrls) {
        this.ruleForm.juminzhaopian = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.juminhao)&& 'jumin'==this.flag){
        this.$message.error('Resident ID cannot be empty');
        return
      }
      if((!this.ruleForm.mima)&& 'jumin'==this.flag){
        this.$message.error('password cannot be empty');
        return
      }
      if( 'jumin' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`Age should be entered as an integer`);
        return
      }
        if(this.ruleForm.juminzhaopian!=null) {
                this.ruleForm.juminzhaopian = this.ruleForm.juminzhaopian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'jumin' ==this.flag && this.ruleForm.juminshouji&&(!isMobile(this.ruleForm.juminshouji))){
        this.$message.error(`Resident mobile phones should be entered in phone format`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`User name cannot be empty`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "Successfully modified information",
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
