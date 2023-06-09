<template>
  <div class="detali">
    <div class="detali-box">
      <img src="https://www.inproeast.com/wp-content/uploads/2023/04/3-1-200x200.jpg" alt="">
      <div class="detali-info">
        <div>
          <p class="name">7-Eleven</p>
          <p class="name-type">7-11 University Place</p>
        </div>
        <div style="margin-top:30px">
          <p class="title">Introduce:
          </p>
          <p class="conter">A convenience store chain that sells take-out food and beverages and a variety of book and newsstand items.</p>
          <p class="title">Address:
          </p>
          <p class="conter">6, Halaman Bukit Gambir, Sunway Bukit Gambier, 11700 Gelugor, Pulau Pinang.</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
.detali {
  //   padding: 50px;
  padding: 50px 150px;

  .detali-box {
    display: flex;
    img {
      width: 50%;
      height: 700px;
    }
  }
  .detali-info {
    padding: 40px;
  }
  .name {
    font-size: 26px;
  }
  .name-type {
    margin-top: 20px;
    font-size: 30px;
  }
  .title {
    font-size: 26px;
  }
  .conter {
    margin-top: 10px;
    font-size: 23px;
  }
}
</style>