<template>
  <div class="comment">
    <div>
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="Account">
          <el-input
            v-model="name"
            placeholder="Input Account Name"
            clearable
          ></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">Search</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="juminhao" label="Account"> </el-table-column>
      <el-table-column prop="juminshouji" label="Mobile"> </el-table-column>
      <el-table-column prop="juminxingming" label="Name"> </el-table-column>
      <el-table-column prop="nianling" label="Age"> </el-table-column>
      <el-table-column prop="juzhudizhi" label="Address"> </el-table-column>
      <el-table-column prop="menpaihao" label="HouseNumber"> </el-table-column>
      <el-table-column prop="danyuanhao" label="UnitNumber"> </el-table-column>
      <el-table-column prop="xingbie" label="Sex"> </el-table-column>
      <el-table-column label="Image" width="180">
        <template slot-scope="scope">
          <!-- <div v-if="scope.row.value"> -->
          <img
            :src="$base.url + scope.row.juminzhaopian"
            width="100"
            height="100"
          />
          <!-- </div> -->
          <!-- <div v-else>no photo</div> -->
        </template>
      </el-table-column>
      <el-table-column prop="addtime" label="Create-Time">
        <template slot-scope="scope">
          <p>
            {{ $moment(scope.row.createDate).format("YYYY/MM/DD HH:mm:ss") }}
          </p>
        </template>
      </el-table-column>

      <el-table-column fixed="right" prop="address" label="operate" width="180">
        <template slot-scope="scope">
          <el-button
            @click="dalogshow(scope.row, false)"
            type="success"
            icon="el-icon-tickets"
            size="mini"
          >
            Renew Password</el-button
          >
          <el-button
            @click="del(scope.row, false)"
            type="success"
            icon="el-icon-tickets"
            size="mini"
          >
            delete</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination">
      <el-pagination layout="prev, pager, next" :total="total"> </el-pagination>
    </div>
  </div>
</template>

<script>
import { ddusers, resetPass, deletes } from "@/assets/api/api.js";
export default {
  data() {
    return {
      name: "",
      tableData: [],
      total: 0,
      page: 1,
      limit: 10,
    };
  },
  mounted() {
    this.getlist();
  },
  methods: {
    del(item, value) {
      let params = [];
      params.push(item.id);
      deletes(params)
        .then((res) => {
          if (res.data.code == "0") {
            this.$message({
              message: "Delete Successful",
              type: "success",
            });
            this.getlist();
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {});
    },
    dalogshow(item, value) {
      let params = {
        username: item.juminhao,
      };
      resetPass(params)
        .then((res) => {
          if (res.data.code == "0") {
            this.$message({
              message: "Renew Successful",
              type: "success",
            });
            this.getlist();
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {});
    },
    onSubmit() {
      this.page = 1;
      this.getlist();
    },
    getlist() {
      let params = {
        page: this.page,
        limit: 10,
      };
      if (this.name) {
        params.juminhao = this.name;
      }
      ddusers(params)
        .then((res) => {
          // console.log(res);
          if (res.data.code == "0") {
            this.tableData = res.data.data.list;
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {
          this.$message.error(erro.msg);
        });
    },
  },
};
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