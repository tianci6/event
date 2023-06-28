<template>
  <div>
    <div class="headers">
      <div class="active">
        <p>USER/ CENTER</p>
        <p>INDIVIDUALCENTER</p>
      </div>
      <div class="Individual-nav">
        <div class="Individual-left">
          <div @click="active(item, index)" :key="index" v-for="(item, index) in userlist" :class="indexs == item.name ? 'actives' : ''">
            {{ item.name }}
          </div>
        </div>
        <div class="Individual-right">
          <div v-if="indexs == 'Your Account'">
            <el-form ref="forms" :rules="rules" :model="form" label-width="120px">
              <el-form-item label="Account" prop="juminhao">
                <el-input placeholder="Account" v-model="form.juminhao"></el-input>
              </el-form-item>
              <el-form-item label="Password" prop="mima">
                <el-input type="password" placeholder="Password" v-model="form.mima"></el-input>
              </el-form-item>

              <el-form-item label="Name" prop="juminxingming">
                <el-input placeholder="Name" v-model="form.juminxingming"></el-input>
              </el-form-item>
              <el-form-item label="Age" prop="nianling">
                <el-input placeholder="Age" v-model="form.nianling"></el-input>
              </el-form-item>
              <el-form-item label="Gender">
                <el-select v-model="form.xingbie" placeholder="Age">
                  <el-option label="Male" value="Male"></el-option>
                  <el-option label="Female" value="Female"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item prop="nianling">
                <el-upload class="avatar-uploader" action="/eventi/file/upload" :on-success="succes" :headers="headers" :show-file-list="false">
                  <img v-if="
                      form.juminzhaopian != null && form.juminzhaopian != ''
                    " :src="$base.url+form.juminzhaopian" class="avatar" />
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
              </el-form-item>

              <el-form-item label="Mobile" prop="juminshouji">
                <el-input placeholder="Mobile" v-model="form.juminshouji"></el-input>
              </el-form-item>
              <el-form-item label="Address" prop="juzhudizhi">
                <el-input placeholder="Address" v-model="form.juzhudizhi"></el-input>
              </el-form-item>
              <el-form-item label="HouseNumber" prop="menpaihao">
                <el-input placeholder="HouseNumber" v-model="form.menpaihao"></el-input>
              </el-form-item>
              <el-form-item label="UnitNumber" prop="danyuanhao">
                <el-input placeholder="UnitNumber" v-model="form.danyuanhao"></el-input>
              </el-form-item>

              <div class="foot">
                <p @click="subclikc" class="sub">Update</p>
                <p @click="subclikcs" class="sub subs">Log out</p>
              </div>
            </el-form>
          </div>
          <div v-if="indexs == 'Your Post'">
            <el-table :data="tableData" style="width: 100%">
              <el-table-column prop="userId" label="ID" width="180">
              </el-table-column>
              <el-table-column prop="type" label="Category" width="180">
              </el-table-column>
              <el-table-column prop="name" label="Title"> </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="email" label="Email">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="content" label="Introduce">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="describe" label="Descripition">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="address" label="Address">
              </el-table-column>
              <el-table-column width="120" :show-overflow-tooltip="true" prop="imgUrl" label="图片信息">
              </el-table-column>
              <el-table-column fixed="right" width="120" label="操作">
                <template slot-scope="scope">
                  <p class="dels" @click="del(scope.row,false)" type="success" icon="el-icon-tickets" size="mini">
                    删除</p>
                </template>
              </el-table-column>

            </el-table>
            <!-- <el-pagination layout="prev, pager, next" :total="total">
            </el-pagination> -->
          </div>
          <div v-if="indexs == 'Your Favourite'">
            <div class="market-list">
              <el-row :gutter="20">
                <el-col :key="index" v-for="(item, index) in market" :span="6">
                  <div class="grid-content">
                    <img @click="gotodetali(item)" :src="$base.url + item.imgUrl" alt="" />
                  </div>
                  <div class="text-font">
                    <p>{{ item.name }}</p>
                    <p class="name">{{ item.content }}</p>
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
    <el-dialog title="Prompt" :visible.sync="deldialogVisible" width="30%" :before-close="handleClose">
      <span>Are you sure to proceed with the [Delete] operation?</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="deldialogVisible = false">Cancel</el-button>
        <el-button @click="save">Confirm</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  selectMyCollect,
  session,
  updates,
  selectMyMaterial,
  materialdel
} from "@/assets/api/api.js";
import storage from "@/utils/storage";
export default {
  data () {
    return {
      url: "https://d.mousenat.cn/eventi/",
      market: [],
      tableData: [],
      headers: {
        Token: storage.get("Token"),
      },
      form: {
        xingbie: "Male",
        juminhao: "",
        juminzhaopian: "",
        mima: "",
        mima2: "",
        juminxingming: "",
        nianling: "",
        juminshouji: "",
        juzhudizhi: "",
        menpaihao: "",
        danyuanhao: "",
      },
      rules: {
        name: [{ required: true, message: "请输入name", trigger: "blur" }],
        password: [
          { required: true, message: "请输入password", trigger: "blur" },
        ],
        juminxingming: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        mima: [{ required: true, message: "请输入密码", trigger: "blur" }],
        mima2: [
          { required: true, message: "请输入再次确认密码", trigger: "blur" },
        ],
        nianling: [{ required: true, message: "请输入Age", trigger: "blur" }],
        juminshouji: [
          { required: true, message: "请输入居民手机", trigger: "blur" },
        ],
        juzhudizhi: [
          { required: true, message: "请输入Address", trigger: "blur" },
        ],
        menpaihao: [
          { required: true, message: "请输入HouseNumber", trigger: "blur" },
        ],
        danyuanhao: [
          { required: true, message: "请输入UnitNumber", trigger: "blur" },
        ],
      },
      indexs: "Your Account",
      userlist: [
        {
          name: "Your Account",
          value: 0,
        },
        {
          name: "Your Post",
          value: 1,
        },
        {
          name: "Your Favourite",
          value: 2,
        },
      ],
      page: 1,
      limit: 10,
      total: 0,
      deldialogVisible: false
    };
  },
  created () {
    this.getuser();
  },
  methods: {
    handleClose () {
      this.deldialogVisible = false
    },
    save () {
      let params = [];
      params.push(this.materialId);
      materialdel(params)
        .then((res) => {
          // console.log(res);
          if (res.data.code == "0") {
            this.$message({
              message: "删除成功",
              type: "success",
            });
            this.deldialogVisible = false;
            this.getfabulist();
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {
          this.$message.error(erro.msg);
        });
    },
    del (item, value) {
      this.materialId = item.id;
      this.deldialogVisible = true;
    },
    subclikcs () {
      this.$storage.remove("Token");
      this.$router.replace({ name: "/event/login" });
    },
    succes (file) {
      console.log(file);
      this.form.juminzhaopian = "upload/" + file.file;
    },
    gotodetali (item) {
      //   console.log(123);
      this.$router.push({
        path: "/event/marketking/detali",
        query: item,
      });
    },
    getuser () {
      let params = {};
      session(params)
        .then((res) => {
          if (res.data.code == "0") {
            this.form = res.data.data;
            this.form.xingbie = "Male";
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => { });
    },
    active (item, index) {
      this.indexs = item.name;
      //   console.log(this.indexs);
      if (this.indexs == "Your Favourite") {
        this.getmarklist();
      } else if (this.indexs == "Your Post") {
        this.getfabulist();
      } else if (this.indexs == "Your Account") {
        this.getuser();
      }
    },
    getfabulist () {
      let params = {
        page: this.page,
        limit: this.limit,
      };
      selectMyMaterial(params)
        .then((res) => {
          if (res.data.code == "0") {
            this.tableData = res.data.data;
            //   console.log(res.data.data);
            //   this.total = res.data.data.total
            this.tableData.forEach((item) => {
              if (item.type == "A") {
                item.type = "活动";
              } else if (item.type == "B") {
                item.type = "商品";
              } else if (item.type == "C") {
                item.type = "二手商品";
              }
            });
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {
          this.$message.error(erro.msg);
        });
    },
    getmarklist () {
      let params = {
        materialId: "",
        // type: this.values
      };

      selectMyCollect(params)
        .then((res) => {
          console.log(res);
          if (res.data.code == "0") {
            this.market = res.data.data;
            this.market.sort(
              (a, b) =>
                new Date(a.createTime).getTime() -
                new Date(b.createTime).getTime()
            );
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {
          this.$message.error(erro.msg);
        });
    },
    subclikc () {
      let params = this.form;
      updates(params)
        .then((res) => {
          if (res.data.code == "0") {
            this.$message({
              message: "更新成功",
              type: "success",
            });
            this.getuser();
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => { });
    },
  },
};
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
  // margin: 0px auto;
  // text-align: center;
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
.foot {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0px 120px;
}
.subs {
  background-color: #ccc;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.avatar-uploader {
  width: 178px;
  height: 178px;
  border: 1px dashed #ccc;
}
.el-select {
  width: 100%;
}
.dels {
  cursor: pointer;
}
</style>