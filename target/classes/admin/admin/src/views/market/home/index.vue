<template>
  <div>
    <el-container>
      <el-header>
        <herders></herders>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import
herders
  from "./herder";
export default {
  components: { herders }

}
</script>

<style lang="scss" scoped>
/deep/.el-header {
  padding: 0px;
  height: 100% !important;
}
/deep/.el-main {
  padding: 0px;
}
</style>