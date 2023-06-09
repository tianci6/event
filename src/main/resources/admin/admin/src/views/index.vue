<template>
  <div>
    <router-view v-if="viewshows"></router-view>
    <el-container v-if="!viewshows">
      <index-header></index-header>
      <el-container>
        <index-aside></index-aside>
        <index-main></index-main>
      </el-container>
    </el-container>
  </div>

</template>

<script>
import IndexHeader from '@/components/index/IndexHeader'
import IndexAside from '@/components/index/IndexAsideStatic'
import IndexMain from '@/components/index/IndexMain'
export default {
  components: {
    IndexHeader,
    IndexAside,
    IndexMain
  },
  created () {
    this.viewshow()
  },
  data () {
    return {
      viewshows: false
    }
  },
  methods: {
    viewshow () {
      console.log(this.$route.path.indexOf("event") > -1);

      if (this.$route.path.indexOf("event") > -1) {
        this.viewshows = true
      } else {
        this.viewshows = false
      }
    }
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
