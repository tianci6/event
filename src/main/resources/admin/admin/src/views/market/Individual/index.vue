<template>
  <div>
    <div class="headers">
      <div class="active">
        <p> USER/ CENTER</p>
        <p> INDIVIDUALCENTER</p>
      </div>
      <div class="Individual-nav">
        <div class="Individual-left">
          <div @click="active(item,index)" :key="index" v-for="(item,index) in userlist" :class="indexs==item.name ? 'actives':''">{{item.name}}</div>
        </div>
        <div class="Individual-right">
          <div v-if="indexs=='个人中心'">
            <el-form ref="forms" :rules="rules" :model="form" label-width="80px">
              <!-- <div> -->
              <el-form-item prop=" name" label="用户名">
                <el-input :disabled="true" v-model="form.name"></el-input>
              </el-form-item>
              <!-- </div> -->

              <p @click="subclikc" class="sub">重置密码</p>
            </el-form>
          </div>
          <div v-if="indexs=='我的发布'">
            <el-table :data="tableData" style="width: 100%">
              <el-table-column prop="userId" label="发布人用户ID" width="180">
              </el-table-column>
              <el-table-column prop="type" label="商品类型" width="180">
              </el-table-column>
              <el-table-column prop="name" label="名称">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="email" label="邮件">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="content" label="介绍">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="describe" label="描述">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="address" label="地址">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="imgUrl" label="图片信息">
              </el-table-column>
            </el-table>
            <!-- <el-pagination layout="prev, pager, next" :total="total">
            </el-pagination> -->
          </div>
          <div v-if="indexs=='我的收藏'">
            <div class="market-list">
              <el-row :gutter="20">
                <el-col :key="index" v-for="(item,index) in market" :span="6">
                  <div class="grid-content">
                    <img @click="gotodetali(item)" :src="$base.url+item.imgUrl" alt="">
                  </div>
                  <div class="text-font">

                    <p>{{item.name}}</p>
                    <p class="name">{{item.content}}</p>
                    <!-- <el-rate v-model="item.value" disabled show-score text-color="#334155" score-template="{value}">
            </el-rate> -->
                  </div>
                </el-col>

              </el-row>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import {
  selectMyCollect,
  session,
  resetPass,
  selectMyMaterial
} from "@/assets/api/api.js";
export default {
  data () {
    return {
      url: "https://d.mousenat.cn/eventi/",
      market: [],
      tableData: [],
      form: {
        name: "",
        password: ""
      },
      rules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],

      },
      indexs: "个人中心",
      userlist: [
        {
          name: "个人中心",
          value: 0
        },
        {
          name: "我的发布"
          ,
          value: 1
        },
        {
          name: "我的收藏"
          ,
          value: 2
        },
      ],
      page: 1,
      limit: 10,
      total: 0
    }
  },
  created () {
    this.getuser()
  },
  methods: {
    gotodetali (item) {
      //   console.log(123);
      this.$router.push({
        path: '/event/marketking/detali',
        query: item
      })
    },
    getuser () {
      let params = {
      }
      session(params).then(res => {
        if (res.data.code == '0') {
          this.form.name = res.data.data.username
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {

      });
    },
    active (item, index) {
      this.indexs = item.name
      //   console.log(this.indexs);
      if (this.indexs == "我的收藏") {
        this.getmarklist()
      } else if (this.indexs == "我的发布") {
        this.getfabulist()
      } else if (this.indexs == "个人中心") {
        this.getuser()
      }
    },
    getfabulist () {
      let params = {
        page: this.page,
        limit: this.limit
      }
      selectMyMaterial(params).then(res => {
        if (res.data.code == '0') {

          this.tableData = res.data.data
          //   console.log(res.data.data);
          //   this.total = res.data.data.total
          this.tableData.forEach(item => {
            if (item.type == "A") {
              item.type = "活动"
            } else if (item.type == "B") {
              item.type = "商品"
            } else if (item.type == "C") {
              item.type = "二手商品"
            }
          })
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    },
    getmarklist () {
      let params = {
        materialId: ""
        // type: this.values
      }

      selectMyCollect(params).then(res => {
        console.log(res);
        if (res.data.code == '0') {
          this.market = res.data.data
          this.market.sort((a, b) => new Date(a.createTime).getTime() - new
            Date(b.createTime).getTime())
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    },
    subclikc () {

      let params = {
        username: this.form.name
      }
      resetPass(params).then(res => {
        if (res.data.code == '0') {
          this.$message({
            message: '重置成功',
            type: 'success'
          });
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {

      });
    }
  }
}
</script>

<style lang="scss" scoped>
.headers {
  margin: 0px auto;
  margin-top: 20px;
  //   display: flex;
  width: 70%;

  margin-bottom: 30px;
  text-align: center;
}
.Individual-nav {
  margin-top: 30px;
  display: flex;
  //   align-items: center;
}

.Individual-left {
  width: 15%;
  div {
    display: inline-block;
    width: auto;
    line-height: 34px;
    // padding: 0px 30px;
    padding-left: 20px;
    padding-right: 20px;
    margin: 0 5px;
    padding: 20px;
    color: rgba(0, 0, 0, 1);
    font-size: 16px;
    border-radius: 10px;
    border-width: 10px 0 0;
    border-style: solid;
    border-color: rgba(143, 143, 143, 1);
    background-color: rgba(217, 217, 217, 1);
    box-shadow: 0 0 0px rgba(0, 0, 0, 0.1);
    text-align: center;
    box-sizing: border-box;
    cursor: pointer;
    width: 100%;
  }
  :hover {
    color: rgba(0, 0, 0, 1);
    font-size: 16px;
    border-radius: 10px;
    border-width: 10px 0 0;
    border-style: solid;
    border-color: rgba(213, 169, 122, 1);
    background-color: rgba(223, 195, 153, 1);
    box-shadow: 0 0 0px rgba(255, 0, 0, 0.8);
  }
  .actives {
    padding: 20px;
    // width: 60%;
    width: 100%;
    color: #fff;
    // height: 100px;

    font-size: 23px;
    border-radius: 10px;
    border-width: 10px 0 0;
    border-style: solid;
    border-color: rgba(213, 169, 122, 1);
    background-color: rgba(223, 195, 153, 1);
    box-shadow: 0 0 0px rgba(255, 0, 0, 0.8);
  }
}
.Individual-right {
  width: 84%;
  padding: 10px;
}
.sub {
  margin: 0px auto;
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
/deep/.el-input--medium .el-input__inner {
  height: 50px;
}
.grid-content {
  margin-top: 20px;
  width: 100%;
  height: 400px;
  //   background-color: pink;
  margin-bottom: 20px;

  img {
    width: 100%;
    height: 100%;
  }
}
.market-list {
  padding: 10px;
}
</style>