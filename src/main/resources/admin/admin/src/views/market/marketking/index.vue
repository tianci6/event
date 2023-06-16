<template>
  <div>
    <div class="seach">
      <el-input @change="seach" placeholder="请输入内容" v-model="input3" class="input-with-select">
      </el-input>
      <i @click="seach" class="el-icon-search seach"></i>
    </div>
    <div class="select">
      <div></div>
      <div>
        <el-form ref="form" :model="form" label-width="100px">
          <el-form-item label="排序规则：">
            <el-select @change="ruleclick" v-model="value" placeholder="please choose">
              <el-option v-for="item in paixurule" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="分类：">
            <el-select @change="ruleclicks" v-model="values" placeholder="please choose">
              <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-form>
      </div>
    </div>
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
</template>

<script>
import {
  list
} from "@/assets/api/api.js";
export default {
  data () {
    return {
      url: "http://192.168.31.92:8080/",
      form: {},
      market: [
        // {
        //   url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
        //   type: "Product",
        //   name: "The 25th-anniversary Ultimate Kaiba Set",
        //   value: 4
        // },
        // {
        //   url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
        //   type: "Product",
        //   name: "The 25th-anniversary Ultimate Kaiba Set",
        //   value: 4
        // },
        // {
        //   url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
        //   type: "Product",
        //   name: "The 25th-anniversary Ultimate Kaiba Set",
        //   value: 4
        // },
        // {
        //   url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
        //   type: "Product",
        //   name: "The 25th-anniversary Ultimate Kaiba Set",
        //   value: 4
        // },
        // {
        //   url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
        //   type: "Product",
        //   name: "The 25th-anniversary Ultimate Kaiba Set",
        //   value: 4
        // },
        // {
        //   url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
        //   type: "Product",
        //   name: "The 25th-anniversary Ultimate Kaiba Set",
        //   value: 4
        // },

      ],
      input3: "",
      paixurule: [
        {
          label: "升序",
          value: "0"
        },
        {
          label: "降序",
          value: "1"
        }
      ],
      options: [{
        value: 'A',
        label: '活动'
      }, {
        value: 'B',
        label: '商品'
      }, {
        value: 'C',
        label: '二手商品'
      },],
      value: "0",
      values: ""
    }

  },
  created () {
    // console.log(this.$route.query);
    this.values = ""
    if (this.$route.query && this.$route.query != "" && JSON.stringify(this.$route.query) != "{}") {
      this.values = this.$route.query
    } else {
      this.values = ""
    }
    this.getmarklist()
  },
  methods: {
    ruleclick (value) {
      if (value == "0") {
        this.market.sort((a, b) => new Date(a.createTime).getTime() - new
          Date(b.createTime).getTime())
      } else {
        this.market.sort((a, b) => new Date(a.createTime).getTime() - new
          Date(b.createTime).getTime()).reverse()

      }
    },
    seach () {
      this.getmarklist()
    },
    getmarklist () {
      let params = {
        name: "%" + this.input3 + "%",
        // type: this.values
      }
      if (this.values != "") {
        params.type = this.values
      }
      list(params).then(res => {
        console.log(res);
        if (res.data.code == '0') {
          this.market = res.data.data.list
          this.market.sort((a, b) => new Date(a.createTime).getTime() - new
            Date(b.createTime).getTime())
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    },
    ruleclicks () {

    },
    gotodetali (item) {
      //   console.log(123);
      this.$router.push({
        path: '/event/marketking/detali',
        query: item
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.seach {
  display: flex;
  width: 70%;
  //   width: 60%;
  //   text-align: center;
  margin: 0px auto;
  align-items: center;
  /deep/.el-input--medium .el-input__inner {
    height: 60px;
    border-radius: 100px;
  }
  .seach {
    width: 30px;
    margin-left: 20px;
    /deep/.el-icon-search:before {
      font-size: 35px;
    }
  }
}
.select {
  display: flex;
  justify-content: space-between;
  padding-right: 100px;
  margin: 50px 0px;
  /deep/.el-input--medium .el-input__inner {
    border: none;
  }
}
.market-list {
  padding: 0px 100px;
  padding-bottom: 100px;
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
.text-font {
  p {
    font-size: 20px;
    margin-bottom: 10px;
  }
  .name {
    font-size: 23px;
  }
}
/deep/.el-rate__icon {
  color: #c0c4cc;
}
</style>