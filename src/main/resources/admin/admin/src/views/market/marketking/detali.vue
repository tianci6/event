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
          <p class="title">email:
          </p>
          <p class="conter">{{detaliboj.email}}</p>
          <p v-if="saveshow" @click="subclikc('A')" class="sub">Favorite</p>
          <p v-if="!saveshow" @click="subclikc('B')" class="sub">cancel Favorite</p>
        </div>
      </div>

    </div>
    <div style="margin-top:30px">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="Description" name="Description">
          <div class="Description">
            <p class="conter">{{detaliboj.describe}}</p>

          </div>
        </el-tab-pane>
        <el-tab-pane label="Reviews" name="Reviews">
          <div>
            <p class="conter">There are no reviews yet.</p>
            <div class="pinglunbox">
              <div class="pinglunbox-info">
                <p class="name-title">Be the first to review “{{detaliboj.name}}”
                </p>
                <p class="conter">Your email address will not be published. Required fields are marked *</p>
                <div class="rating">
                  <p class="conter">Your rating *</p>
                  <el-rate style="margin-top:15px;margin-left:15px" v-model="value1"></el-rate>
                </div>
                <div>
                  <p class="conter">Your review *</p>
                  <div style="width:98%;margin-top:20px">
                    <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="textarea">
                    </el-input>
                  </div>
                </div>

                <p @click="submit" class="subs">submit</p>
                <div>
                  <p class="conter">Review List</p>
                  <div :key="index" v-for="(item,index) in pinglunlist">
                    <div class="pinglun">
                      <img :src="$base.url+item.userPhone" alt="">
                      <p style="margin-left:15px">{{item.username}}</p>
                      <el-rate style="margin-left:15px" v-model="item.score"></el-rate>
                      <p style="margin-left:15px">{{item.createTime}}</p>
                    </div>
                    <p style="margin-top:10px;margin-left:80px">{{item.content}}</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </el-tab-pane>

      </el-tabs>
    </div>

  </div>
</template>

<script>
import {
  collectMaterial,
  checkCollect,
  adds,
  getByMaterial
} from "@/assets/api/api.js";
import storage from "@/utils/storage";
export default {
  data () {
    return {
      value1: 5,
      textarea: "",
      market: [],
      activeName: "Description",
      url: "https://d.mousenat.cn/eventi/",
      detaliboj: null,
      saveshow: false,
      pinglunlist: []
    }
  },
  created () {
    this.detaliboj = this.$route.query
    console.log(this.detaliboj);
    this.getcheckCollect()
  },
  methods: {
    submit () {
      if (this.textarea != "") {
        let params = {
          materialId: this.detaliboj.id,
          content: this.textarea,
          score: this.value1

        }
        adds(params).then(res => {
          console.log(res);
          if (res.data.code == '0') {
            this.$message.success("评论成功");
            this.textarea = ""
            this.getByMaterial()
          } else {
            this.$message.error(res.data.msg);
          }
        }).catch((erro) => {
          this.$message.error(erro.msg);
        });
      } else {
        this.$message.error("请填写评论");
      }
    },
    gotodetali (item) {
      //   console.log(123);
      this.$router.push({
        path: '/event/marketking/detali',
        query: item
      })
    },
    handleClick (item, index) {
      if (this.activeName == 'Reviews') {
        this.getByMaterial()
      }
    },
    getByMaterial () {
      getByMaterial(this.detaliboj.id).then(res => {
        // console.log(res);
        if (res.data.code == '0') {
          // console.log(res);
          this.pinglunlist = res.data.data
          this.pinglunlist.forEach(item => {
            item.score
          })
        } else {
          this.$message.error(res.data.message);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    },

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
  // width: 100px;

  background-color: #d5a97a;
  padding-top: 10px;
  padding-right: 20px;
  padding-bottom: 10px;
  padding-left: 20px;
  font-size: 16px;
  border-radius: 30px;
}
.subs {
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
.sub:hover {
  background-color: rgba(223, 195, 153, 1);
}
/deep/.el-tabs__item {
  :hover {
    color: #d5a97a;
  }
}
/deep/.el-tabs__item.is-active {
  color: #d5a97a;
}
/deep/.el-tabs__active-bar {
  background-color: #d5a97a;
}
.Description {
  .conter {
    padding-top: 20px;
    padding-bottom: 40px;
  }
  .conters {
    font-size: 28px;
    font-weight: bold;
  }
}
.market-list {
  padding: 0px 100px;
  padding-bottom: 100px;
}
.pinglunbox {
  margin-top: 30px;
  width: 99%;
  //   height: 300px;
  padding: 30px;
  //   background-color: pink;
  border: 1px solid #ccc;
  .name-title {
    font-size: 25px;
    font-weight: bold;
  }
  .rating {
    display: flex;
    align-items: center;

    .box {
      padding: 0px 20px;
      flex: 0.8;
      .conter {
        margin-top: 20px;
        margin-bottom: 20px;
      }
    }
  }
}
/deep/.el-input--medium .el-input__inner {
  height: 80px;
}
.pinglun {
  display: flex;
  align-items: center;
  img {
    width: 70px;
    height: 70px;
    border-radius: 100px;
  }
}
</style>