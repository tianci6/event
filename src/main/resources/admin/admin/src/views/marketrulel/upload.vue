<template>
  <div>
    <div class="form">
      <el-form
        ref="forms"
        :rules="rules"
        label-position="top"
        :model="form"
        label-width="80px"
      >
        <el-form-item prop="name" label="Title">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="Email">
          <el-input v-model="form.email"></el-input>
        </el-form-item>
        <el-form-item prop="content" label="Intrdouce">
          <el-input v-model="form.content"></el-input>
        </el-form-item>

        <el-form-item prop="describe" label="Description">
          <el-input v-model="form.describe"></el-input>
        </el-form-item>
        <el-form-item label="Category">
          <el-select v-model="form.type" placeholder="Category">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item prop="address" label="Address">
          <el-input v-model="form.address"></el-input>
        </el-form-item>

        <el-form-item prop="imgUrl" label="Image">
          <el-upload
            action="/eventi/file/upload"
            :on-success="succes"
            :headers="headers"
            class="upload-demo"
            drag
          >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              Please Input Image，Or <em>Click to upload</em>
            </div>
            <div class="el-upload__tip" slot="tip">
              Only jpg/png files can be uploaded, and the size should not exceed
              500kb
            </div>
          </el-upload>
        </el-form-item>
        <p @click="subclikc" class="sub">Upload</p>
      </el-form>
    </div>
  </div>
</template>

<script>
import { upload, add } from "@/assets/api/api.js";
import storage from "@/utils/storage";
export default {
  data() {
    return {
      options: [
        {
          value: "A",
          label: "Promotion",
        },
        {
          value: "B",
          label: "Business",
        },
      ],
      headers: {
        Token: storage.get("Token"),
      },
      form: {
        name: "",
        type: "A",
        email: "",
        content: "",
        describe: "",
        address: "",
        imgUrl: "",
      },
      rules: {
        name: [
          { required: true, message: "Please Input Title", trigger: "blur" },
        ],
        email: [
          { required: true, message: "Please Input Email", trigger: "blur" },
        ],
        content: [
          {
            required: true,
            message: "Please Input Introduce",
            trigger: "blur",
          },
        ],
        describe: [
          {
            required: true,
            message: "Please Input Descripition",
            trigger: "blur",
          },
        ],
        address: [
          { required: true, message: "Please Input Address", trigger: "blur" },
        ],
        imgUrl: [
          { required: true, message: "Please Input Image", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    beforeupload(item) {},
    succes(file) {
      this.form.imgUrl = "upload/" + file.file;
    },
    subclikc() {
      this.$refs.forms.validate((valid) => {
        if (valid) {
          add(this.form)
            .then((res) => {
              if (res.data.code == "0") {
                this.$router.push("/event/homerulel/comment");
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
    },
  },
};
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
.el-select {
  width: 100%;
}
</style>