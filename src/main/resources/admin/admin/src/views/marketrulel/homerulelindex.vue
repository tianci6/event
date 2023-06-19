<template>
  <div class="comment">
    <div>
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="用户名">
          <el-input v-model="name" placeholder="请输入用户名"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="juminhao" label="用户名">
      </el-table-column>
      <el-table-column prop="juminshouji" label="手机号">
      </el-table-column>
      <el-table-column prop="juminxingming" label="姓名">
      </el-table-column>
      <el-table-column prop="nianling" label="年龄">
      </el-table-column>
      <el-table-column prop="juzhudizhi" label="地址">
      </el-table-column>
      <el-table-column prop="menpaihao" label="门牌号">
      </el-table-column>
      <el-table-column prop="danyuanhao" label="单元号">
      </el-table-column>
      <el-table-column prop="xingbie" label="性别">
      </el-table-column>
      <el-table-column label="图片" width="180">
        <template slot-scope="scope">
          <!-- <div v-if="scope.row.value"> -->
          <img :src="$base.url+scope.row.juminzhaopian" width="100" height="100">
          <!-- </div> -->
          <!-- <div v-else>no photo</div> -->
        </template>
      </el-table-column>
      <el-table-column prop="addtime" label="创建时间">
        <template slot-scope="scope">
          <p>{{$moment(scope.row.createDate).format("YYYY/MM/DD HH:mm:ss")}}</p>
        </template>
      </el-table-column>

      <el-table-column fixed="right" prop="address" label="操作" width="180">
        <template slot-scope="scope">

          <el-button @click="dalogshow(scope.row,false)" type="success" icon="el-icon-tickets" size="mini">
            重置密码</el-button>
          <el-button @click="del(scope.row,false)" type="success" icon="el-icon-tickets" size="mini">
            删除</el-button>
        </template>
      </el-table-column>

    </el-table>
    <div class="pagination">
      <el-pagination layout="prev, pager, next" :total="total">
      </el-pagination>
    </div>

  </div>
</template>

<script>

import {
  ddusers,
  resetPass,
  deletes
} from "@/assets/api/api.js";
export default {
  data () {
    return {
      name: "",
      tableData: [],
      total: 0,
      page: 1,
      limit: 10,
    }
  },
  mounted () {
    this.getlist()
  },
  methods: {
    del (item, value) {
      let params = []
      params.push(item.id)
      deletes(params).then(res => {
        if (res.data.code == '0') {
          this.$message({
            message: '删除成功',
            type: 'success'
          });
          this.getlist()
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {

      });
    },
    dalogshow (item, value) {
      let params = {
        username: item.juminhao
      }
      resetPass(params).then(res => {
        if (res.data.code == '0') {
          this.$message({
            message: '重置成功',
            type: 'success'
          });
          this.getlist()
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {

      });
    },
    onSubmit () {
      this.page = 1
      this.getlist()
    },
    getlist () {
      let params = {
        username: this.name,
        page: this.page,
        limit: 10,
      }
      ddusers(params).then(res => {
        // console.log(res);
        if (res.data.code == '0') {
          this.tableData = res.data.data.list
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
.comment {
  padding-top: 50px;
}
/deep/ .el-button--success {
  margin-top: 10px;
  height: 40px;
  color: #333;
  font-size: 14px;
  border-width: 4px;
  border-style: solid;
  border-color: rgba(204, 184, 154, 1);
  border-radius: 40px 40px 0 40px;
  background-color: #fff;
  margin-left: 0px;
}
/deep/ .el-button--primary {
  height: 40px;
  color: #333;
  font-size: 14px;
  border-width: 4px;
  border-style: solid;
  border-color: rgba(204, 184, 154, 1);
  border-radius: 40px 40px 0 40px;
  background-color: #fff;
}

/deep/ .el-button--danger {
  height: 40px;
  color: #333;
  font-size: 14px;
  border-width: 4px;
  border-style: solid;
  border-color: rgba(204, 184, 154, 1);
  border-radius: 40px 40px 0 40px;
  background-color: #fff;
}
.pagination {
  margin-top: 10px;
  text-align: center;
}
</style>