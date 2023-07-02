<template>
  <el-main style="padding: 10px 20px;
				background: url(http://codegen.caihongy.cn/20220121/90c9da3f7bbc4d549542899a7fe33c41.png);
						boxShadow: 0 0 6px rgba(0,0,0,0);
                height:calc(100% - ${template2.back.menulist.menulistHeight});
        		">
    <bread-crumbs class="bread-crumbs"></bread-crumbs>
    <router-view class="router-view" style="height:auto;background: transparent;"></router-view>
  </el-main>
</template>

<script>
import menu from "@/utils/menu";
export default {
  data () {
    return {

    };
  },
  mounted () {

  },
  created () {

  },

};
</script>
<style lang="scss" scoped>
a {
  text-decoration: none;
  color: #555;
}

a:hover {
  background: #00c292;
}

.nav-list {
  width: 100%;
  margin: 0 auto;
  text-align: left;
  margin-top: 20px;

  .nav-title {
    display: inline-block;
    font-size: 15px;
    color: #333;
    padding: 15px 25px;
    border: none;
  }

  .nav-title.active {
    color: #555;
    cursor: default;
    background-color: #fff;
  }
}

.nav-item {
  margin-top: 20px;
  background: #ffffff;
  padding: 15px 0;

  .menu {
    padding: 15px 25px;
  }
}

.el-main {
  // background-color: #F6F8FA;
  padding: 0 24px;
  min-height: 100vh;
  // padding-top: 60px;
}

.router-view {
  padding: 10px;
  margin-top: 10px;
  background: #ffffff;
  box-sizing: border-box;
}

.bread-crumbs {
  width: 100%;
  // border-bottom: 1px solid #e9eef3;
  // border-top: 1px solid #e9eef3;
  margin-top: 10px;
  box-sizing: border-box;
}

.detail-form-content {
  background: transparent;
}
</style>
