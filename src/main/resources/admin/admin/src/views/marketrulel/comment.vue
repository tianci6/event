<template>
  <div class="comment">
    <div>
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="Ttitle">
          <el-input v-model="name" placeholder="Ttitle"></el-input>
        </el-form-item>
        <el-form-item label="Category">
          <el-select clearable v-model="type" placeholder="Category">
            <el-option label="Promotion" value="A"></el-option>
            <el-option label="Business" value="B"></el-option>
            <el-option label="C2C/Trading" value="C"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">Search</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"> </el-table-column>
      <el-table-column prop="name" label="Ttitle"> </el-table-column>
      <el-table-column prop="type" label="Category" width="180">
      </el-table-column>
      <el-table-column prop="email" label="Email" width="180">
      </el-table-column>
      <el-table-column prop="content" label="Intrdouce" width="180">
      </el-table-column>
      <el-table-column prop="describe" label="Description" width="180">
      </el-table-column>
      <el-table-column prop="address" label="Address" width="180">
      </el-table-column>
      <el-table-column prop="imgUrl" label="Image" width="180">
        <template slot-scope="scope">
          <!-- <div v-if="scope.row.value"> -->
          <img :src="$base.url + scope.row.imgUrl" width="100" height="100" />
          <!-- </div> -->
          <!-- <div v-else>no photo</div> -->
        </template>
      </el-table-column>
      <el-table-column fixed="right" prop="address" label="operate" width="180">
        <template slot-scope="scope">
          <!-- <el-button @click="dalogshow(scope.row,true)" type="success" icon="el-icon-tickets" size="mini">
            评论记录</el-button> -->
          <el-button
            @click="dalogshow(scope.row, false)"
            type="success"
            icon="el-icon-tickets"
            size="mini"
          >
            Favourite History</el-button
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
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="60%"
      :before-close="handleClose"
    >
      <el-table
        v-if="title == 'Comment Record'"
        :data="ptableData"
        style="width: 100%"
      >
        <el-table-column prop="username" label="评论用户" width="180">
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="content"
          label="评论内容"
        >
        </el-table-column>
        <el-table-column prop="createTime" label="评论时间"> </el-table-column>
      </el-table>
      <el-table v-else :data="cangtableData" style="width: 100%">
        <el-table-column prop="username" label="Collect people" width="180">
        </el-table-column>
      </el-table>

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button @click="dialogVisible = false">Confirm</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="Prompt"
      :visible.sync="deldialogVisible"
      width="30%"
      :before-close="handleClose"
    >
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
  list,
  page,
  userMaterial,
  deletes,
  materialdel,
} from "@/assets/api/api.js";
export default {
  data() {
    return {
      deldialogVisible: false,
      cangtableData: [],
      ptableData: [],
      url: "http://192.168.31.92:8080/",
      tableData: [],
      name: "",
      type: "",
      total: 0,
      page: 1,
      limit: 10,
      title: "Comment Record",
      dialogVisible: false,
      materialId: "",
    };
  },
  mounted() {
    this.getlist();
  },
  methods: {
    handleClose() {},
    save() {
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
            this.getlist();
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {
          this.$message.error(erro.msg);
        });
    },
    del(item, value) {
      this.materialId = item.id;
      this.deldialogVisible = true;
    },
    dalogshow(item, value) {
      if (value) {
        this.title = "Comment Record";
        this.getplist();
      } else {
        this.title = "Favorite Records";
        this.materialId = item.id;
        this.getcanglist();
      }
      this.dialogVisible = true;
    },
    getcanglist() {
      let params = {
        materialId: this.materialId,
      };
      userMaterial(params)
        .then((res) => {
          // console.log(res);
          if (res.data.code == "0") {
            this.cangtableData = res.data.data.list;
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {
          this.$message.error(erro.msg);
        });
    },
    getplist() {
      let params = {};
      page(params)
        .then((res) => {
          // console.log(res);
          if (res.data.code == "0") {
            this.ptableData = res.data.data.list;
            this.ptableData
              .sort(
                (a, b) =>
                  new Date(a.createTime).getTime() -
                  new Date(b.createTime).getTime()
              )
              .reverse();
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch((erro) => {
          this.$message.error(erro.msg);
        });
    },
    onSubmit() {
      this.page = 1;
      this.getlist();
    },
    getlist() {
      let params = {
        name: "%" + this.name + "%",
        page: this.page,
        limit: this.limit,
        // type: this.values
      };
      if (this.type != "") {
        params.type = this.type;
      }
      list(params)
        .then((res) => {
          console.log(res);
          if (res.data.code == "0") {
            this.tableData = res.data.data.list;
            this.tableData
              .sort(
                (a, b) =>
                  new Date(a.createTime).getTime() -
                  new Date(b.createTime).getTime()
              )
              .reverse();

            // this.tableData.sort((a, b) => new Date(a.createTime).getTime() - new
            //   Date(b.createTime).getTime())
            this.tableData.forEach((item) => {
              if (item.type == "A") {
                item.type = "Promotion";
              } else if (item.type == "B") {
                item.type = "Business";
              } else if (item.type == "C") {
                item.type = "C2C/Trading";
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
  },
};
</script>

<style lang="scss" scoped>
.comment {
  padding-top: 50px;
}
/deep/.el-table th.el-table__cell {
  background-color: rgb(238, 221, 197);
  color: black;
}
p {
  cursor: pointer;
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
  margin-top: 20px;
  text-align: center;
}
</style>