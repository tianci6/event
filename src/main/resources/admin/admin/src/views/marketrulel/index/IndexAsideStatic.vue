<template>
  <el-aside class="index-aside" width="200px">
    <div class="index-aside-inner menulist">
      <div class="menulist-item">
        <el-menu :mode="2 == 1? 'horizontal':'vertical'" :unique-opened="true" class="el-menu-demo" default-active="0">
          <el-menu-item index="1" @click="menuHandler('/event/homerulel/')">用户管理</el-menu-item>
          <el-menu-item index="0" @click="menuHandler('/event/homerulel/config')">轮播图管理</el-menu-item>

          <el-menu-item index="2" @click="menuHandler('/event/homerulel/comment')">商品管理</el-menu-item>

        </el-menu>
      </div>
    </div>
  </el-aside>
</template>

<script>
import menu from '@/utils/menu'
export default {
  data () {
    return {
      menuList: [

      ]
    }
  },
  methods: {
    menuHandler (value) {
      this.$router.push(value)
    },
    gotopingjia () {
      this.$router.push("/event/homerulel/comment")
    }
  }



}
</script>
<style lang="scss" scoped>
.el-container {
  display: block;
}
.index-aside {
  position: relative;
  overflow: hidden;
  display: flex;
  flex-wrap: wrap;

  .menulistImg {
    font-size: 0;
    box-sizing: border-box;

    .el-image {
      margin: 0 auto;
      width: 100px;
      height: 100px;
      border-radius: 100%;
      display: block;
    }
  }

  .index-aside-inner {
    // margin-top: 20px;
    width: 100%;
    height: 100%;
    margin-right: -17px;
    margin-bottom: -17px;
    // overflow: scroll;
    // overflow-x: hidden !important;
    padding-top: 80px;
    box-sizing: border-box;
    // padding-left: 20px;
    // padding-right: 20px;
    // padding-top: 20px;
    &:focus {
      outline: none;
    }

    & /deep/ .el-menu {
      border: 0;
      background-color: transparent;
    }
  }

  .index-aside .index-aside-inner.menulist {
    height: auto !important;
  }
  .menulist-item {
    width: 200px;
    padding: 15px 20px;
    margin: 0;
    border-radius: 0;
    border-width: 0 !important;
    border-style: solid !important;
    border-color: rgba(0, 0, 0, 0.3) !important;
    background: #eeddc5 !important;
    box-shadow: 0 0 0px rgba(30, 144, 255, 0.2);
    box-sizing: border-box;
  }
  .el-menu-demo {
    box-sizing: border-box;
    min-height: calc(100vh - 80px);

    & > .el-menu-item {
      width: auto;
      height: auto !important;
      line-height: 30px !important;
      padding: 0 10px;
      margin: 0 0 10px 0;
      color: rgba(0, 0, 0, 1);
      font-size: 14px;
      border-radius: 40px 40px 0 40px;
      border-width: 5px;
      border-style: solid;
      border-color: rgba(194, 161, 49, 1) !important;
      background-color: rgba(238, 221, 197, 1) !important;
      box-shadow: 0 0 6px rgba(255, 255, 255, 0);
      box-sizing: initial;
      display: flex;
      align-items: center;
      justify-content: flex-start;
      box-sizing: border-box;

      .el-icon-menu {
        margin: 0 5px 0 0;
        padding: 0;
        width: 24px;
        line-height: 24px;
        color: rgba(199, 21, 133, 1);
        font-size: 16px;
        border-radius: 0;
        border-width: 0;
        border-style: solid;
        border-color: #fff;
        background-color: rgba(255, 255, 255, 0);
        box-shadow: 0 0 6px rgba(255, 255, 255, 0);
      }
    }

    .el-submenu {
      margin: 0 0 10px 0;
    }

    & /deep/ .el-submenu__title {
      width: auto;
      height: auto !important;
      line-height: 30px !important;
      padding: 0 10px;
      color: rgba(0, 0, 0, 1);
      font-size: 14px;
      border-radius: 40px 40px 0 40px;
      border-width: 5px;
      border-style: solid;
      border-color: rgba(194, 161, 49, 1) !important;
      background-color: rgba(238, 221, 197, 1) !important;
      box-shadow: 0 0 6px rgba(255, 255, 255, 0);
      box-sizing: initial;
      display: flex;
      align-items: center;
      justify-content: flex-start;
      box-sizing: border-box;

      .el-icon-menu {
        margin: 0 5px 0 0;
        padding: 0;
        width: 24px;
        line-height: 24px;
        color: rgba(199, 21, 133, 1);
        font-size: 16px;
        border-radius: 0;
        border-width: 0;
        border-style: solid;
        border-color: #fff;
        background-color: rgba(255, 255, 255, 0);
        box-shadow: 0 0 6px rgba(255, 255, 255, 0);
      }

      .el-submenu__icon-arrow {
        margin: 0 10px 0 0;
        padding: 0;
        width: 12px;
        line-height: 12px;
        color: rgba(6, 6, 6, 1) !important;
        font-size: 12px;
        border-radius: 0;
        border-width: 0;
        border-style: solid;
        border-color: #fff;
        background-color: rgba(255, 255, 255, 0);
        box-shadow: 0 0 6px rgba(255, 255, 255, 0);
        position: absolute;
        top: 50%;
        right: 0;
        transform: translateY(-50%);
        text-align: center;
        display: block;
      }
    }

    & /deep/ .el-menu.el-menu--inline {
      width: 60%;
      height: auto;
      padding: 0;
      margin: 5px auto 10px;
      border-radius: 4px;
      border-width: 0;
      border-style: solid;
      border-color: rgba(0, 0, 0, 0.3);
      background-color: rgba(255, 255, 255, 0);
      box-shadow: 0 0 0px rgba(0, 0, 0, 0.3);

      .el-menu-item {
        width: 100%;
        height: 30px;
        line-height: 30px;
        padding: 0 !important;
        margin: 5px 0;
        color: #000 !important;
        font-size: 14px;
        border-radius: 20px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0, 0, 0, 0);
        background-color: #fff !important;
        box-shadow: 0 0 6px rgba(30, 144, 255, 0);
        text-align: center;
        min-width: auto;

        &.is-active {
          width: 100%;
          height: 30px;
          line-height: 30px;
          padding: 0 !important;
          margin: 5px 0;
          color: rgba(255, 255, 255, 1) !important;
          font-size: 14px;
          border-radius: 20px;
          border-width: 0;
          border-style: solid;
          border-color: rgba(0, 0, 0, 0);
          background-color: rgba(194, 161, 49, 1) !important;
          box-shadow: 0 0 6px rgba(30, 144, 255, 0);
          text-align: center;
        }

        &:hover {
          width: 100%;
          height: 30px;
          line-height: 30px;
          padding: 0 !important;
          margin: 5px 0;
          color: #fff !important;
          font-size: 14px;
          border-radius: 20px;
          border-width: 0;
          border-style: solid;
          border-color: rgba(0, 0, 0, 0);
          background-color: rgba(194, 161, 49, 1) !important;
          box-shadow: 0 0 6px rgba(30, 144, 255, 0);
          text-align: center;
        }
      }
    }
  }
}
</style>
<style>
.el-menu--horizontal .el-menu--popup {
  width: 60%;
  height: auto;
  padding: 0;
  margin: 5px auto 10px;
  border-radius: 4px;
  border-width: 0;
  border-style: solid;
  border-color: rgba(0, 0, 0, 0.3);
  background-color: rgba(255, 255, 255, 0);
  box-shadow: 0 0 0px rgba(0, 0, 0, 0.3);
  min-width: auto;
}
.el-menu--horizontal .el-menu--popup .el-menu-item {
  width: 100%;
  height: 30px;
  line-height: 30px;
  padding: 0;
  margin: 5px 0;
  color: #000 !important;
  font-size: 14px;
  border-radius: 20px;
  border-width: 0;
  border-style: solid;
  border-color: rgba(0, 0, 0, 0);
  background-color: #fff !important;
  box-shadow: 0 0 6px rgba(30, 144, 255, 0);
  text-align: center;
  min-width: auto;
}
.el-menu--horizontal .el-menu--popup .el-menu-item:hover {
  width: 100%;
  height: 30px;
  line-height: 30px;
  padding: 0;
  margin: 5px 0;
  color: #fff !important;
  font-size: 14px;
  border-radius: 20px;
  border-width: 0;
  border-style: solid;
  border-color: rgba(0, 0, 0, 0);
  background-color: rgba(194, 161, 49, 1) !important;
  box-shadow: 0 0 6px rgba(30, 144, 255, 0);
  text-align: center;
}
</style>
<style lang="scss" scoped>
/deep/.el-submenu__title {
  height: 100%;
  padding: 0 10px;
  margin: 0 0 10px 0;
  color: black;
  font-size: 14px;
  border-radius: 40px 40px 0 40px;
  border-width: 5px;
  border-style: solid;
  border-color: #c2a131 !important;
  background-color: #eeddc5 !important;
}
</style>
