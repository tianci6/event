<template>
  <div class="uploader">
    <div class="form">
      <el-form ref="forms" :rules="rules" label-position="top" :model="form" label-width="80px">
        <el-form-item prop="name" label="商品名称">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="邮件">
          <el-input v-model="form.email"></el-input>
        </el-form-item>
        <el-form-item prop="content" label="商品介绍">
          <el-input v-model="form.content"></el-input>
        </el-form-item>
        <el-form-item prop="describe" label="商品描述">
          <el-input v-model="form.describe"></el-input>
        </el-form-item>
        <el-form-item prop="address" label="地址">
          <el-input v-model="form.address"></el-input>
        </el-form-item>

        <el-form-item prop="imgUrl" label="商品图片">
          <el-upload action="/eventi/file/upload" :on-success="succes" :headers="headers" class="upload-demo" drag>
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
        <p @click="subclikc" class="sub">提交</p>
      </el-form>
    </div>
  </div>
</template>

<script>
import {
  upload,
  add
} from "@/assets/api/api.js";

export default {
  data () {
    return {
      headers: {
        Token: sessionStorage.getItem("token")
      },
      form: {
        name: "",
        type: "C",
        email: "",
        content: "",
        describe: "",
        address: "",
        imgUrl: ""
      },
      rules: {
        name: [
          { required: true, message: '请输入商品名称', trigger: 'blur' },
        ],
        email: [
          { required: true, message: '请输入邮件', trigger: 'blur' },
        ],
        content: [
          { required: true, message: '请输入商品介绍', trigger: 'blur' },
        ],
        describe: [
          { required: true, message: '请输入商品描述', trigger: 'blur' },
        ],
        address: [
          { required: true, message: '请输入地址', trigger: 'blur' },
        ],
        imgUrl: [
          { required: true, message: '请输入商品图片', trigger: 'blur' },
        ],
      }
    }
  },
  methods: {
    beforeupload (item) {



    },
    succes (file) {

      this.form.imgUrl = "upload/" + file.file
    },
    subclikc () {
      this.$refs.forms.validate((valid) => {
        if (valid) {
          add(this.form).then(res => {
            if (res.data.code == '0') {
              this.$router.push("/event/marketking")
            } else {
              this.$message.error(res.data.msg);
            }
          }).catch((erro) => {
            this.$message.error(erro.msg);
          });
        } else {

          return false;
        }
      });
    }
  }
}
</script>

<style lang="scss" scoped>
.uploader {
  padding: 50px 200px;
  .form {
    margin: 0px auto;
    width: 70%;
    /deep/.el-input--medium .el-input__inner {
      height: 50px;
    }
  }
}
/deep/.el-upload {
  width: 100%;
}
/deep/.el-upload-dragger {
  width: 100%;
}
.sub {
  text-align: center;
  width: 100px;

  background-color: #d5a97a;
  padding-top: 10px;
  padding-right: 20px;
  padding-bottom: 10px;
  padding-left: 20px;
  font-size: 16px;
  border-radius: 30px;
}
</style>