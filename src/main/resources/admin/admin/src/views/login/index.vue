<template>
  <div class="login">
    <div class="login-bgc">

    </div>
    <div class="login-form">
      <p class="title">公共场所不建议自动登录，以防账号丢失</p>
      <el-form v-if="loginshow" :rules="rules" ref="ruleForm" :model="form" label-width="0px">
        <div style="padding-left:40px;padding-right:40px;padding-top:20px">
          <el-form-item prop="name">
            <el-input placeholder="请输入账号" v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" placeholder="请输入密码" v-model="form.password"></el-input>
          </el-form-item>
          <p @click="loginsave" class="button">登录</p>
          <p @click="reset" class="zhuce">注册resident</p>
        </div>

      </el-form>
      <el-form v-else :rules="rules" ref="ruleForms" :model="form" label-width="0px">
        <div style="padding-left:40px;padding-right:40px;padding-top:20px">
          <el-form-item prop="name">
            <el-input placeholder="请输入账号" v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" placeholder="请输入密码" v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item prop="passwords">
            <el-input placeholder="请输入再次确认密码" v-model="form.passwords"></el-input>
          </el-form-item>
          <p @click="zhuce" class="button">注册</p>
          <p @click="logins" class="zhuce">已有账号登录</p>
        </div>

      </el-form>

    </div>
  </div>
</template>

<script>
import {
  login,
  register
} from "@/assets/api/api.js";
export default {
  data () {
    return {
      form: {
        name: "",
        password: "",
        passwords: ""
      },
      loginshow: true,
      rules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },

        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },

        ],
        passwords: [
          { required: true, message: '请输入再次确认密码', trigger: 'blur' },

        ],

      }

    }
  },
  methods: {
    logins () {
      this.loginshow = true
      this.$refs.ruleForms.resetFields();
    },
    reset () {
      this.loginshow = false
      this.$refs.ruleForm.resetFields();
    },
    zhuce () {
      this.$refs.ruleForms.validate((valid) => {
        if (valid) {
          let params = {
            username: this.form.name,
            password: this.form.password
          };
          register(params).then(res => {
            // console.log(res);
            if (res.data.code == '0') {
              this.loginshow = true
              this.$refs.ruleForm.resetFields();
            } else {
              this.$message.error(res.data.msg);
            }
          }).catch((erro) => {
            this.$message.error(erro.msg);
          });
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    loginsave () {
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          let params = {
            username: this.form.name,
            password: this.form.password
          };
          login(params).then(res => {

            if (res.data.code == '0') {
              this.$storage.set("Token", res.data.token);
              // sessionStorage.setItem("token", res.data.token)
              this.$message.success("登录成功");
              if (this.$route.query.source == "1") {
                this.$router.push("/event/homerulel")
              } else {
                this.$router.push("/event/home")
              }
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
.login {
  width: 100%;
  height: 100%;
  position: relative;
  .login-form {
    position: fixed;
    right: 0px;
    top: 50%;
    transform: translateY(-50%);
    padding: 20px;
    box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px;
    border-color: rgba(0, 0, 0, 0.3);
    background-color: rgb(255, 255, 255);
    border-radius: 20px;
    border-width: 0px;
    width: 400px;
    border-style: solid;
    justify-content: flex-end;
    height: auto;
    .title {
      padding: 0px 10px;
      box-shadow: rgba(255, 0, 0, 0.8) 0px 0px 0px;
      margin: 10px auto;
      border-color: rgb(0, 0, 0);
      background-color: rgba(247, 247, 247, 0);
      color: rgb(203, 148, 92);
      border-radius: 8px;
      border-width: 0px;
      width: 100%;
      line-height: 32px;
      font-size: 18px;
      border-style: solid;
    }
  }
}
.login-bgc {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  width: 100%;
  height: 100vh;
  background-attachment: fixed;
  background-size: cover;
  background-position: center;
  background-image: url("http://codegen.caihongy.cn/20220129/ab52b9e572bb442893ca40bfc5412286.png");
}
/deep/.el-input--medium .el-input__inner {
  padding: 0px 10px;
  box-shadow: rgba(0, 0, 0, 0.5) 0px 0px 0px;
  border-color: rgb(204, 204, 204);
  background-color: rgb(233, 233, 233);
  color: rgb(51, 51, 51);
  border-radius: 8px;
  text-align: left;
  border-width: 0px;
  width: 100%;
  font-size: 14px;
  border-style: solid;
  height: 44px;
}
.button {
  width: 80%;
  padding: 0px 10px;
  box-shadow: rgba(255, 0, 0, 0.5) 0px 0px 0px;
  margin: 10px auto;
  border-color: rgb(204, 204, 204);
  background-color: rgb(203, 148, 92);
  color: rgb(255, 255, 255);
  border-radius: 44px;
  border-width: 0px;
  line-height: 44px;
  font-size: 14px;
  border-style: solid;
  text-align: center;
}
.zhuce {
  text-align: center;
}
</style>