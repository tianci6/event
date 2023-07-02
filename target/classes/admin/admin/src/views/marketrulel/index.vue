<template>
  <div>
    <el-container>
      <index-header></index-header>
      <el-container>
        <index-aside></index-aside>
        <index-main></index-main>
      </el-container>
    </el-container>
  </div>

</template>

<script>
import IndexHeader from './index/IndexHeader'
import IndexAside from './index/IndexAsideStatic'
import IndexMain from './index/IndexMain'
export default {
  components: {
    IndexHeader,
    IndexAside,
    IndexMain
  },
  created () {

  },
  data () {
    return {
      viewshows: false
    }
  },
  methods: {

  }
}
</script>

<style lang="scss" scoped>
// 铺满全屏
.el-container {
  position: absolute;
  width: 100%;
  top: 0;
  left: 0;
  bottom: 0;
}
</style>
