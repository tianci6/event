<template>
  <div>
    <div class="seach">
      <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
      </el-input>
      <i class="el-icon-search seach"></i>
    </div>
    <div class="select">
      <div></div>
      <div>
        <el-form ref="form" :model="form" label-width="100px">
          <el-form-item label="排序规则：">
            <el-select v-model="value" placeholder="请选择">
              <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="分类：">
            <el-select v-model="value" placeholder="请选择">
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
            <img @click="gotodetali(item)" :src="item.url" alt="">
          </div>
          <div class="text-font">
            <p>{{item.type}}</p>
            <p class="name">{{item.name}}</p>
            <el-rate v-model="item.value" disabled show-score text-color="#334155" score-template="{value}">
            </el-rate>
          </div>
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      form: {},
      market: [
        {
          url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
          type: "Product",
          name: "The 25th-anniversary Ultimate Kaiba Set",
          value: 4
        },
        {
          url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
          type: "Product",
          name: "The 25th-anniversary Ultimate Kaiba Set",
          value: 4
        },
        {
          url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
          type: "Product",
          name: "The 25th-anniversary Ultimate Kaiba Set",
          value: 4
        },
        {
          url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
          type: "Product",
          name: "The 25th-anniversary Ultimate Kaiba Set",
          value: 4
        },
        {
          url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
          type: "Product",
          name: "The 25th-anniversary Ultimate Kaiba Set",
          value: 4
        },
        {
          url: "https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg",
          type: "Product",
          name: "The 25th-anniversary Ultimate Kaiba Set",
          value: 4
        },

      ],
      input3: "",
      options: [{
        value: '选项1',
        label: '黄金糕'
      }, {
        value: '选项2',
        label: '双皮奶'
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }, {
        value: '选项4',
        label: '龙须面'
      }, {
        value: '选项5',
        label: '北京烤鸭'
      }],
      value: ''
    }

  },
  methods: {
    gotodetali () {
      console.log(123);
      this.$router.push('/event/marketking/detali')
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
  //   height: 400px;
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