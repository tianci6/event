<template>
  <div class="markethome">
    <div class="home-bgc">
      <p class="font-one">INPROEAST</p>
      <p class="font-twp">Community Support System</p>
      <div>
        <p class="buttom">Learn more</p>
      </div>
    </div>
    <div>
      <h2 class="title">Local Bussiness Marketing Category</h2>
      <div class="conter">
        <div @click="gotomarkte('C')" class="conter-box">
          <p>Bussiness</p>
        </div>
        <div @click="gotomarkte('A')" class="conter-box conter-boxs">
          <p>prodouct</p>
        </div>
        <div @click="gotomarkte('B')" class="conter-box conter-boxss">
          <p>promotio</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    gotomarkte (value) {
      this.$router.push({
        path: "/event/marketking",
        query: value
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.markethome {
  .home-bgc {
    // margin-top: 20px;
    width: 100%;
    height: 400px;
    background-image: url(https://www.inproeast.com/wp-content/uploads/2023/04/untitled.png);
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
    padding: 30px;
    text-align: center;
    .font-one {
      color: #d5a97a;
      font-family: "Oswald", Sans-serif;
      font-size: 40px;
      font-weight: 500;
      text-transform: uppercase;
      line-height: 1.2em;
      letter-spacing: -0.3px;
    }
    .font-twp {
      margin-top: 30px;
      color: #d5a97a;
      font-family: "Oswald", Sans-serif;
      font-size: 96px;
      font-weight: 500;
      font-style: normal;
      line-height: 1.2em;
    }
    .buttom {
      margin: 0px auto;
      margin-top: 30px;
      width: 200px;
      font-family: "Oswald", Sans-serif;
      font-size: 21px;
      font-weight: 700;
      text-transform: uppercase;
      font-style: normal;
      line-height: 1.4em;
      fill: #000000cc;
      color: #000000cc;
      background-color: #d5a97a;
      border-radius: 7px 7px 7px 7px;
      padding: 20px 0px 20px 0px;
    }
  }
  .title {
    line-height: 200px;
    text-align: center;
    font-size: 30px;
    // line-height: inherit;
    color: #d5a97a;
  }
  .conter {
    display: flex;
    align-items: center;
    justify-content: center;
    padding-left: 200px;
    padding-right: 200px;
    padding-bottom: 300px;
    .conter-box {
      margin-right: 20px;
      flex: 1;
      height: 230px;
      text-align: center;
      line-height: 230px;
      font-size: 30px;
      // line-height: inherit;
      color: #d5a97a;
      // background-color: pink;
      background-image: url(https://www.inproeast.com/wp-content/uploads/2023/04/国王大道.png);
      background-size: auto;
    }
    .conter-boxs {
      background-image: url(https://www.inproeast.com/wp-content/uploads/2023/04/企业中心.png);
      background-size: cover;
    }
    .conter-boxss {
      background-image: url(https://www.inproeast.com/wp-content/uploads/2023/04/河谷区街道.png);
      background-size: cover;
    }
    :last-child {
      margin-right: 0px;
    }
  }
}
</style>