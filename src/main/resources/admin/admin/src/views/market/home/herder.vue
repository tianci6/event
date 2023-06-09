<template>
  <div>
    <div class="herder">
      <p>Community Support System</p>
    </div>
    <div class="headers">
      <p @click="gotorouter(item,index)" :class="indexs ==index ?'active':''" :key="index" v-for="(item,index) in list">{{item.name}}</p>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      indexs: 0,
      list: [
        {
          name: "Home",
          path: "/event/home"
        },
        {
          name: "Marketking",
          path: "/event/marketking"
        },
        {
          name: "Uplode",
          path: "/event/Uplode"
        }
      ]
    }
  },
  methods: {
    gotorouter (item, index) {
      this.indexs = index
      this.$router.push(item.path)
    }
  }
}
</script>

<style lang="scss" scoped>
.herder {
  width: 100%;
  display: flex;
  align-items: center;
  //   padding: 0 20px;
  font-size: 16px;
  color: #2a8a15;
  box-sizing: border-box;
  height: 50px;
  background: #cb945c;
  box-shadow: 0 0px 0px rgba(0, 0, 0, 0.3);
  justify-content: center;

  //   position: relative;
  z-index: 1;
  p {
    line-height: 40px;
    font-size: 20px;
    color: rgba(255, 255, 255, 1);
    padding: 0 10px;
    margin: 0 10px;
    border-radius: 6px;
    border-width: 0;
    border-style: solid;
    border-color: rgba(0, 0, 0, 0.3);
    background-color: rgba(0, 0, 0, 0);
    box-shadow: 0 0 0px rgba(0, 0, 0, 0.3);
  }
}
.headers {
  margin-top: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 30px;
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
  .active {
    color: rgba(0, 0, 0, 1);
    font-size: 16px;
    border-radius: 10px;
    border-width: 10px 0 0;
    border-style: solid;
    border-color: rgba(213, 169, 122, 1);
    background-color: rgba(223, 195, 153, 1);
    box-shadow: 0 0 0px rgba(255, 0, 0, 0.8);
  }
  p {
    display: inline-block;
    width: auto;
    line-height: 34px;
    padding: 0 20px;
    margin: 0 5px;
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
  }
}
</style>