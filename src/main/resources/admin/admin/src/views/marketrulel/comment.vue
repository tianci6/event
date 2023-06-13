<template>
  <div class="comment">
    <div>
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="发布人">
          <el-input v-model="name" placeholder="请输入发布人"></el-input>
        </el-form-item>
        <el-form-item label="商品类型">
          <el-select clearable v-model="type" placeholder="请输入商品类型">
            <el-option label="活动" value="A"></el-option>
            <el-option label="商品" value="B"></el-option>
            <el-option label="二手商品" value="C"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="发布人用户id" width="180">
      </el-table-column>
      <el-table-column prop="name" label="发布人">
      </el-table-column>
      <el-table-column prop="type" label="商品类型" width="180">
      </el-table-column>
      <el-table-column prop="email" label="邮件" width="180">
      </el-table-column>
      <el-table-column prop="content" label="介绍" width="180">
      </el-table-column>
      <el-table-column prop="describe" label="描述" width="180">
      </el-table-column>
      <el-table-column prop="address" label="地址" width="180">
      </el-table-column>
      <el-table-column prop="imgUrl" label="图片" width="180">
        <template slot-scope="scope">
          <!-- <div v-if="scope.row.value"> -->
          <img :src="$base.url+scope.row.imgUrl" width="100" height="100">
          <!-- </div> -->
          <!-- <div v-else>no photo</div> -->
        </template>
      </el-table-column>
      <el-table-column fixed="right" prop="address" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="dalogshow(scope.row,true)" type="success" icon="el-icon-tickets" size="mini">
            评论记录</el-button>
          <el-button @click="dalogshow(scope.row,false)" type="success" icon="el-icon-tickets" size="mini">
            收藏记录</el-button>
          <el-button @click="del(scope.row,false)" type="success" icon="el-icon-tickets" size="mini">
            删除</el-button>
        </template>
      </el-table-column>

    </el-table>
    <div class="pagination">
      <el-pagination layout="prev, pager, next" :total="total">
      </el-pagination>
    </div>
    <el-dialog :title="title" :visible.sync="dialogVisible" width="60%" :before-close="handleClose">
      <el-table v-if="title=='评论记录'" :data="ptableData" style="width: 100%">
        <el-table-column prop="username" label="评论用户" width="180">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true" prop="content" label="评论内容">
        </el-table-column>
        <el-table-column prop="createTime" label="评论时间">
        </el-table-column>

      </el-table>
      <el-table v-else :data="cangtableData" style="width: 100%">
        <el-table-column prop="username" label="收藏人" width="180">
        </el-table-column>

      </el-table>

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import {
  list,
  page,
  userMaterial
} from "@/assets/api/api.js";
export default {
  data () {
    return {
      cangtableData: [],
      ptableData: [],
      url: "http://192.168.31.92:8080/",
      tableData: [],
      name: "",
      type: "",
      total: 0,
      page: 1,
      limit: 10,
      title: "评论记录",
      dialogVisible: false,
      materialId: ""
    }

  },
  mounted () {
    this.getlist()

  },
  methods: {
    del () { },
    dalogshow (item, value) {
      if (value) {
        this.title = "评论记录"
        this.getplist()
      } else {
        this.title = "收藏记录"
        this.materialId = item.id
        this.getcanglist()
      }
      this.dialogVisible = true
    },
    getcanglist () {
      let params = {
        materialId: this.materialId
      }
      userMaterial(params).then(res => {
        // console.log(res);
        if (res.data.code == '0') {
          this.cangtableData = res.data.data.list
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    },
    getplist () {
      let params = {

      }

      page(params).then(res => {
        // console.log(res);
        if (res.data.code == '0') {
          this.ptableData = res.data.data.list
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((erro) => {
        this.$message.error(erro.msg);
      });
    },
    onSubmit () {
      this.page = 1
      this.getlist()
    },
    getlist () {
      let params = {
        name: "%" + this.name + "%",
        page: this.page,
        limit: this.limit,
        // type: this.values
      }
      if (this.type != "") {
        params.type = this.type
      }
      list(params).then(res => {
        console.log(res);
        if (res.data.code == '0') {
          this.tableData = res.data.data.list
          this.tableData.sort((a, b) => new Date(a.createTime).getTime() - new
            Date(b.createTime).getTime())
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
    }
  }

}
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