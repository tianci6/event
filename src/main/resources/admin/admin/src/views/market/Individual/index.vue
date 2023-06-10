<template>
  <div>
    <div class="headers">
      <div class="active">
        <p> USER/ CENTER</p>
        <p> INDIVIDUALCENTER</p>
      </div>
      <div class="Individual-nav">
        <div class="Individual-left">
          <div @click="active(item,index)" :key="index" v-for="(item,index) in userlist" :class="indexs==index ? 'active':''">{{item.name}}</div>
        </div>
        <div class="Individual-right">

        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      indexs: 0,
      userlist: [
        {
          name: "个人中心"
        },
        {
          name: "我的发布"
        },
        {
          name: "我的收藏"
        },
      ]
    }
  },
  methods: {
    active (item, index) {
      this.indexs = index
    }
  }
}
</script>

<style lang="scss" scoped>
.headers {
  margin: 0px auto;
  margin-top: 20px;
  //   display: flex;
  width: 70%;

  margin-bottom: 30px;
  text-align: center;
}
.Individual-nav {
  margin-top: 30px;
}
.active {
  padding: 20px;
  // width: 60%;
  width: 100%;
  color: #fff;
  // height: 100px;

  font-size: 23px;
  border-radius: 10px;
  border-width: 10px 0 0;
  border-style: solid;
  border-color: rgba(213, 169, 122, 1);
  background-color: rgba(223, 195, 153, 1);
  box-shadow: 0 0 0px rgba(255, 0, 0, 0.8);
}
.Individual-left {
  width: 15%;
  div {
    display: inline-block;
    width: auto;
    line-height: 34px;
    // padding: 0px 30px;
    padding-left: 20px;
    padding-right: 20px;
    margin: 0 5px;
    padding: 20px;
    color: rgba(0, 0, 0, 1);
    font-size: 16px;
    border-radius: 10px;
    border-width: 10px 0 0;
    border-style: solid;
    border-color: rgba(143, 143, 143, 1);
    background-color: rgba(217, 217, 217, 1);
    box-shadow: 0 0 0px rgba(0, 0, 0, 0.1);
    text-align: center;
    box-sizing: border-box;
    cursor: pointer;
    width: 100%;
  }
  :hover {
    color: rgba(0, 0, 0, 1);
    font-size: 16px;
    border-radius: 10px;
    border-width: 10px 0 0;
    border-style: solid;
    border-color: rgba(213, 169, 122, 1);
    background-color: rgba(223, 195, 153, 1);
    box-shadow: 0 0 0px rgba(255, 0, 0, 0.8);
  }
}
.Individual-right {
  padding: 40px;
}
</style>