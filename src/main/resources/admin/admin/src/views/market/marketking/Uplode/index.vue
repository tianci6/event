<template>
  <div class="uploader">
    <div class="form">
      <el-form label-position="top" ref="form" :model="form" label-width="80px">
        <el-form-item label="Your Name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="Your Email">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="Post Title">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="Time">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="Our community\'s name is">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="Post Category">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="Post Content">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="Upload an Image">
          <el-upload class="upload-demo" drag action="https://jsonplaceholder.typicode.com/posts/" multiple>
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
        <p class="sub">Submit Post</p>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      form: {}
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