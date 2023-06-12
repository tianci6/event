<template>
  <div class="detali">
    <div class="detali-box">
      <img :src="$base.url+detaliboj.imgUrl" alt="">
      <div class="detali-info">
        <div>
          <p class="name">{{detaliboj.name}}</p>
          <p class="name-type">{{detaliboj.content}}</p>
        </div>
        <div style="margin-top:30px">
          <p class="title">Introduce:
          </p>
          <p class="conter">{{detaliboj.describe}}</p>
          <p class="title">Address:
          </p>
          <p class="conter">{{detaliboj.address}}</p>
          <p v-if="saveshow" @click="subclikc('A')" class="sub">收藏</p>
          <p v-if="!saveshow" @click="subclikc('B')" class="sub">取消收藏</p>
        </div>
      </div>

    </div>

  </div>
</template>

<script>
import {
  collectMaterial,
  checkCollect
} from "@/assets/api/api.js";
export default {
  data () {
    return {
      url: "https://d.mousenat.cn/eventi/",
      detaliboj: null,
      saveshow: false
    }
  },
  created () {
    this.detaliboj = this.$route.query
    this.getcheckCollect()
  },
  methods: {
    getcheckCollect () {
      let params = {
        materialId: this.detaliboj.id,
      }
      checkCollect(params).then(res => {
        // console.log(res);
        if (res.data.code == '0') {
          if (res.data.data != null) {
            this.saveshow = false
          } else {
            this.saveshow = true
          }
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    },
    subclikc (value) {

      let params = {
        materialId: this.detaliboj.id,
        type: value
      }
      collectMaterial(params).then(res => {
        // console.log(res);
        if (res.data.code == '0') {
          this.getcheckCollect()
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    }
  }
}
</script>

<style lang="scss" scoped>
.detali {
  //   padding: 50px;
  padding: 50px 150px;

  .detali-box {
    display: flex;
    img {
      width: 50%;
      height: 700px;
    }
  }
  .detali-info {
    padding: 40px;
  }
  .name {
    font-size: 26px;
  }
  .name-type {
    margin-top: 20px;
    font-size: 30px;
  }
  .title {
    margin-top: 20px;
    margin-bottom: 10px;
    font-size: 26px;
  }
  .conter {
    margin-top: 10px;
    font-size: 23px;
  }
}
.sub {
  margin-top: 50px;
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