<template>
  <div class="login">
    <div class="login-bgc"></div>
    <div class="login-form">
      <p class="title">Community Support System</p>
      <el-form
        v-if="loginshow"
        :rules="rules"
        ref="ruleForm"
        :model="form"
        label-width="0px"
      >
        <div style="padding-left: 40px; padding-right: 40px; padding-top: 20px">
          <el-form-item prop="name">
            <el-input
              placeholder="Community Account"
              v-model="form.name"
            ></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              type="password"
              placeholder="Password"
              v-model="form.password"
            ></el-input>
          </el-form-item>
          <p @click="loginsave" class="button">Login</p>
          <p @click="reset" class="zhuce">Create Your Community Account</p>
        </div>
      </el-form>
      <el-form
        v-else
        :rules="rules"
        ref="ruleForms"
        :model="form"
        label-width="0px"
      >
        <div style="padding-left: 40px; padding-right: 40px; padding-top: 20px">
          <el-form-item prop="juminhao">
            <el-input
              placeholder="Community Account Name"
              v-model="form.juminhao"
            ></el-input>
          </el-form-item>
          <el-form-item prop="mima">
            <el-input
              type="password"
              placeholder="Password"
              v-model="form.mima"
            ></el-input>
          </el-form-item>
          <el-form-item prop="mima2">
            <el-input
              type="password"
              placeholder="Password Again"
              v-model="form.mima2"
            ></el-input>
          </el-form-item>
          <el-form-item prop="juminxingming">
            <el-input
              placeholder="Real Name"
              v-model="form.juminxingming"
            ></el-input>
          </el-form-item>
          <el-form-item prop="nianling">
            <el-input placeholder="Age" v-model="form.nianling"></el-input>
          </el-form-item>
          <el-form-item prop="juminshouji">
            <el-input
              placeholder="Mobile Number"
              v-model="form.juminshouji"
            ></el-input>
          </el-form-item>

          <el-form-item prop="juzhudizhi">
            <el-input
              placeholder="Community Address"
              v-model="form.juzhudizhi"
            ></el-input>
          </el-form-item>
          <el-form-item prop="menpaihao">
            <el-input
              placeholder="HouseNumber"
              v-model="form.menpaihao"
            ></el-input>
          </el-form-item>
          <el-form-item prop="danyuanhao">
            <el-input
              placeholder="UnitNumber"
              v-model="form.danyuanhao"
            ></el-input>
          </el-form-item>

          <p @click="zhuce" class="button">Create Your Community Account</p>
          <p @click="logins" class="zhuce">Existing Account Login</p>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { login, register, registers, logins } from "@/assets/api/api.js";
export default {
  data() {
    return {
      form: {
        juminhao: "",
        mima: "",
        mima2: "",
        juminxingming: "",
        nianling: "",
        juminshouji: "",
        juzhudizhi: "",
        menpaihao: "",
        danyuanhao: "",
        name: "",
        password: "",
      },
      loginshow: true,
      rules: {
        name: [
          {
            required: true,
            message: "Please Input Your Community Account",
            trigger: "blur",
          },
        ],
        password: [
          {
            required: true,
            message: "Please Input Your Password",
            trigger: "blur",
          },
        ],
        juminxingming: [
          {
            required: true,
            message: "Please Input Your Real Name",
            trigger: "blur",
          },
        ],
        mima: [
          {
            required: true,
            message: "Please Input Your Password",
            trigger: "blur",
          },
        ],
        mima2: [
          {
            required: true,
            message: "Please Input Your Password Again",
            trigger: "blur",
          },
        ],
        nianling: [
          { required: true, message: "Please Input Your Age", trigger: "blur" },
        ],
        juminshouji: [
          {
            required: true,
            message: "Please Input Your Real Phone",
            trigger: "blur",
          },
        ],
        juzhudizhi: [
          {
            required: true,
            message: "Please Input Your Real Address",
            trigger: "blur",
          },
        ],
        menpaihao: [
          {
            required: true,
            message: "Please Input Your HouseNumber",
            trigger: "blur",
          },
        ],
        danyuanhao: [
          {
            required: true,
            message: "Please Input Your UnitNumber",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    logins() {
      this.loginshow = true;
      this.$refs.ruleForms.resetFields();
    },
    reset() {
      this.loginshow = false;
      this.$refs.ruleForm.resetFields();
    },
    zhuce() {
      this.$refs.ruleForms.validate((valid) => {
        if (valid) {
          let params = this.form;
          registers(params)
            .then((res) => {
              if (res.data.code == 0) {
                this.loginshow = true;
                this.$refs.ruleForms.resetFields();
                this.$message.success("Register Successful");
              } else {
                this.$message.error(res.data.msg);
              }
            })
            .catch((erro) => {
              this.$message.error(erro.msg);
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    /* loginsave () {
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          let params = {
            username: this.form.name,
            password: this.form.password,
          };
          login(params)
            .then((res) => {
              if (res.data.code == "0") {
                this.$storage.set("Token", res.data.token);
                // sessionStorage.setItem("token", res.data.token)
                this.$message.success("登录成功");
                if (this.$route.query.source == "1") {
                  this.$router.push("/event/homerulel");
                } else {
                  this.$router.push("/event/home");
                }
              } else {
                this.$message.error(res.data.msg);
              }
            })
            .catch((erro) => {
              this.$message.error(erro.msg);
            });
        } else {
          return false;
        }
      });
    }, */
    loginsave() {
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          if (this.$route.query.source == "1") {
            let params = {
              username: this.form.name,
              password: this.form.password,
            };
            logins(params)
              .then((res) => {
                if (res.data.code == "0") {
                  this.$storage.set("Token", res.data.token);
                  // sessionStorage.setItem("token", res.data.token)
                  this.$message.success("Login Successful");

                  this.$router.push("/event/homerulel");

                  // this.$router.push("/event/home");
                } else {
                  this.$message.error(res.data.msg);
                }
              })
              .catch((erro) => {
                this.$message.error(erro.msg);
              });
          } else {
            let params = {
              username: this.form.name,
              password: this.form.password,
            };
            login(params)
              .then((res) => {
                if (res.data.code == "0") {
                  this.$storage.set("Token", res.data.token);
                  // sessionStorage.setItem("token", res.data.token)
                  this.$message.success("Login Successful");
                  // this.$router.push("/event/homerulel");

                  this.$router.push("/event/home");
                } else {
                  this.$message.error(res.data.msg);
                }
              })
              .catch((erro) => {
                this.$message.error(erro.msg);
              });
          }
        } else {
          return false;
        }
      });
    },
  },
};
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
      text-align: center;
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