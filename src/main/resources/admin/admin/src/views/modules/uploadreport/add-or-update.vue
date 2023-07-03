<template>
  <div class="addEdit-block">
    
	<div style="width: 100%;height: 500px;">
		<div style="width: 50%;height: 500px;float: left;">
			<div id="echart1" style="width: 100%;height: 100%;"></div>
		</div>
		<div style="width: 50%;height: 500px;float: left;">
			<div id="echart2" style="width: 100%;height: 100%;"></div>
		</div>
	</div>
	<div style="white-space: pre-wrap;">
		<h2>Accident Report Statistics</h2>
		<p id="totalReports">Number of Accident Reports: {{accidentNum}}</p>
		<p id="top3Locations">Top 3 Accident Location: {{accidentLocations}}</p>
	</div>
	<div style="width: 100%;height: 500px;">
		<div style="width: 50%;height: 500px;float: left;">
			<div id="echart3" style="width: 100%;height: 100%;"></div>
		</div>
		<div style="width: 50%;height: 500px;float: left;">
			<div id="echart4" style="width: 100%;height: 100%;"></div>
		</div>
	</div>
	<div style="white-space: pre-wrap;">
		<h2>Crime Report Statistics</h2>
		<p id="totalReports">Number of Crime Reports: {{crimeNum}}</p>
		<p id="top3Locations">Top 3 Crime Location: {{crimeLocations}}</p>
	</div>
	<div style="width: 100%;height: 500px;">
		<div style="width: 50%;height: 500px;float: left;">
			<div id="echart5" style="width: 100%;height: 100%;"></div>
		</div>
		<div style="width: 50%;height: 500px;float: left;">
			<div id="echart6" style="width: 100%;height: 100%;"></div>
		</div>
	</div>
	<el-button class="btn-close" @click="back()">Back</el-button>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验

import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    return {
      accidentNum: 0,
	  accidentLocations: '',
	  crimeNum: 0,
	  crimeLocations: ''
    };
  },
  props: ["parent"],
  computed: {
  },
  created() {
	
  },
  methods: {
	back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.juminCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
	  getLoadEcharts() {
		  let self = this;
		  this.$http({
		    url: "report/queryReportCount/admin",
		    method: "get",
		    params: {}
		  }).then(({ data }) => {
		    if (data && data.code === 0) {
		      var dataList = data.data.numCount;
			  
			  var myChart = this.$echarts.init(
			      document.getElementById("echart1")
			    );
			    var colorList = ["#4FE894", "#EF0C27", "#FEE7EA"];
				
				var listData = [
				  // { name: "不明", value: 20 },
				  // { name: "已判明", value: 20 },
				  // { name: "已判明", value: 20 }
				];
				for (var i = 0; i <dataList.length;i++ ){
					// listData[i]['name'] = dataList[i]['reportType'];
					// listData[i]['value'] = parseFloat(dataList[i]['typeNum']);
					
					
					listData[i] = { name: dataList[i]['reportType'], value: parseFloat(dataList[i]['typeNum']) };
				}
			    
			    var option = {
			      color: colorList,
			      title: {
			        x: "center",
			        y: "center",
			        textStyle: {
			          color: "#000",
			          fontSize: 20
			        }
			      },
			      legend: {
			        orient: "vertical",
			        bottom: 5,
			        align: "right",
			        right: 15,
			        textStyle: {
			          color: "#000",
			          fontSize: 20
			        },
			        selectedMode: false,
			        data: ["元素1", "元素2"]
			      },
			      tooltip: {
			        trigger: "item"
			      },
			      series: [
			        {
			          type: "pie",
			          center: ['50%', '50%'],
			          radius: ['55%', '35%'],
			          itemStyle: {
			            normal: {
			              color: function(params) {
			                return colorList[params.dataIndex];
			              }
			            }
			          },
			          label: {
			            show: true,
			            fontSize: 10,
			            color: "#000",
			            formatter: function(data) {
			              return data.name + ":" + data.percent.toFixed(0) + "%";
			            }
			          },
			          labelLine: {
			            normal: {
			              length: 15,
			              length2: 15,
			              lineStyle: {
			                width: 2
			              }
			            }
			          },
			          data: listData
			        }
			      ]
			    };
			    myChart.setOption(option);
				
				
				
				
				var myChart2 = this.$echarts.init(
				    document.getElementById("echart2")
				  );
				const monthlyData = Object.entries(data.data.lineData).map(([month, { total, accident, crime }]) => ({
				                month,
				                total,
				                accident,
				                crime
				            }));
				
				var op = {
							xAxis: {
								type: 'category',
								data: monthlyData.map(item => item.month)
							},
							yAxis: {
								type: 'value'
							},
							legend: {
								data: ['Total Reports', 'Accident Reports','Crime Reports'],
								left: 'right'
						},
							series: [{
								name:'Total Reports',
								data: monthlyData.map(item => item.total),
								type: 'line',
								smooth: true
							},
							{
								name:'Accident Reports',
								data: monthlyData.map(item => item.accident),
								type: 'line',
								smooth: true
							},
							{
								name:'Crime Reports',
								data: monthlyData.map(item => item.crime),
								type: 'line',
								smooth: true
							}]
						};
				
				myChart2.setOption(op);
		    } 
		    this.dataListLoading = false;
		  });
		  
		  
		  this.$http({
		    url: "report/queryReportCount/admin/1",
		    method: "get",
		    params: {}
		  }).then(({ data }) => {
			  console.log(data)
		    if (data && data.code === 0) {
				var total = 0;
				for (var i = 0; i <data.data.numCount.length;i++ ){
					if (data.data.numCount[i]['reportType'] == 'Traffic Accident') {
						total = data.data.numCount[i]['typeNum'];
					}
				}
				
			   console.log(total)
				self.accidentNum = total;
			   console.log(self.accidentNum)
				
				var top3Data = [];
				var top3Percentages = [];
				for (var i = 0; i <data.data.locationCount.length;i++ ){
					if (top3Data.length < 3) {
						top3Data[i] = data.data.locationCount[i].location;
						top3Percentages[i] = data.data.locationCount[i].percentage;
					}
				}
			   console.log(top3Data)
				self.accidentLocations = top3Data.join(',');
			   console.log(self.accidentLocations)
				
		  			  
				var myChart = this.$echarts.init(
				  document.getElementById("echart3")
				);
				var colorList = ["#4FE894", "#EF0C27", "#FEE7EA"];
				
				var listData = [
				  // { name: "不明", value: 20 },
				  // { name: "已判明", value: 20 },
				  // { name: "已判明", value: 20 }
				];
				for (var i = 0; i <top3Data.length;i++ ){
					// listData[i]['name'] = top3Data[i];
					// listData[i]['value'] = parseFloat(top3Percentages[i]);
					listData[i] = { name: top3Data[i], value: parseFloat(top3Percentages[i]) };
				}
				
				var option = {
				  color: colorList,
				  title: {
					x: "center",
					y: "center",
					textStyle: {
					  color: "#000",
					  fontSize: 20
					}
				  },
				  legend: {
					orient: "vertical",
					bottom: 5,
					align: "right",
					right: 15,
					textStyle: {
					  color: "#000",
					  fontSize: 20
					},
					selectedMode: false,
					data: ["元素1", "元素2", "元素3"]
				  },
				  tooltip: {
					trigger: "item"
				  },
				  series: [
					{
					  type: "pie",
					  center: ['50%', '50%'],
					  radius: ['55%', '35%'],
					  itemStyle: {
						normal: {
						  color: function(params) {
							return colorList[params.dataIndex];
						  }
						}
					  },
					  label: {
						show: true,
						fontSize: 10,
						color: "#000",
						formatter: function(data) {
						  return data.name + ":" + data.percent.toFixed(0) + "%";
						}
					  },
					  labelLine: {
						normal: {
						  length: 15,
						  length2: 15,
						  lineStyle: {
							width: 2
						  }
						}
					  },
					  data: listData
					}
				  ]
				};
				myChart.setOption(option);
		  				
		  				
		  				
				var dates = [];
				var values = [];
				for (var i = 0; i <data.data.locationLineCount.length;i++ ){
					dates[i] = data.data.locationLineCount[i].dateStr;
					values[i] = data.data.locationLineCount[i].lotNum;
				}
				var myChart2 = this.$echarts.init(
				    document.getElementById("echart4")
				  );
				var op = {
							xAxis: {
								type: 'category',
								data: dates
							},
							yAxis: {
								type: 'value'
							},
							legend: {
								data: ['Location report quantity'],
								left: 'right'
						},
							series: [{
								name:'Location report quantity',
								data: values,
								type: 'line',
								smooth: true
							}]
						};
				
				myChart2.setOption(op);
		    } 
		    this.dataListLoading = false;
		  });
		  
		  
		  this.$http({
		    url: "report/queryReportCount/admin/2",
		    method: "get",
		    params: {}
		  }).then(({ data }) => {
		  			  console.log(data)
		    if (data && data.code === 0) {
		  				var total = 0;
		  				for (var i = 0; i <data.data.numCount.length;i++ ){
		  					if (data.data.numCount[i]['reportType'] == 'Crime Sence') {
		  						total = data.data.numCount[i]['typeNum'];
		  					}
		  				}
		  				
		  			   console.log(total)
		  				self.crimeNum = total;
		  			   console.log(self.crimeNum)
		  				
		  				var top3Data = [];
		  				var top3Percentages = [];
		  				for (var i = 0; i <data.data.locationCount.length;i++ ){
		  					if (top3Data.length < 3) {
		  						top3Data[i] = data.data.locationCount[i].location;
		  						top3Percentages[i] = data.data.locationCount[i].percentage;
		  					}
		  				}
		  			   console.log(top3Data)
		  				self.crimeLocations = top3Data.join(',');
		  			   console.log(self.crimeLocations)
		  				
		  			  
		  				var myChart = this.$echarts.init(
		  				  document.getElementById("echart5")
		  				);
		  				var colorList = ["#4FE894", "#EF0C27", "#FEE7EA"];
		  				
		  				var listData = [
		  				  // { name: "不明", value: 20 },
		  				  // { name: "已判明", value: 20 },
		  				  // { name: "已判明", value: 20 }
		  				];
		  				for (var i = 0; i <top3Data.length;i++ ){
		  					// listData[i]['name'] = top3Data[i];
		  					// listData[i]['value'] = parseFloat(top3Percentages[i]);
							
							listData[i] = { name: top3Data[i], value: parseFloat(top3Percentages[i]) };
		  				}
		  				
		  				var option = {
		  				  color: colorList,
		  				  title: {
		  					x: "center",
		  					y: "center",
		  					textStyle: {
		  					  color: "#000",
		  					  fontSize: 20
		  					}
		  				  },
		  				  legend: {
		  					orient: "vertical",
		  					bottom: 5,
		  					align: "right",
		  					right: 15,
		  					textStyle: {
		  					  color: "#000",
		  					  fontSize: 20
		  					},
		  					selectedMode: false,
		  					data: ["元素1", "元素2", "元素3"]
		  				  },
		  				  tooltip: {
		  					trigger: "item"
		  				  },
		  				  series: [
		  					{
		  					  type: "pie",
		  					  center: ['50%', '50%'],
		  					  radius: ['55%', '35%'],
		  					  itemStyle: {
		  						normal: {
		  						  color: function(params) {
		  							return colorList[params.dataIndex];
		  						  }
		  						}
		  					  },
		  					  label: {
		  						show: true,
		  						fontSize: 10,
		  						color: "#000",
		  						formatter: function(data) {
		  						  return data.name + ":" + data.percent.toFixed(0) + "%";
		  						}
		  					  },
		  					  labelLine: {
		  						normal: {
		  						  length: 15,
		  						  length2: 15,
		  						  lineStyle: {
		  							width: 2
		  						  }
		  						}
		  					  },
		  					  data: listData
		  					}
		  				  ]
		  				};
		  				myChart.setOption(option);
		  				
		  				
		  				
		  				var dates = [];
		  				var values = [];
		  				for (var i = 0; i <data.data.locationLineCount.length;i++ ){
		  					dates[i] = data.data.locationLineCount[i].dateStr;
		  					values[i] = data.data.locationLineCount[i].lotNum;
		  				}
		  				var myChart2 = this.$echarts.init(
		  				    document.getElementById("echart6")
		  				  );
		  				var op = {
		  							xAxis: {
		  								type: 'category',
		  								data: dates
		  							},
		  							yAxis: {
		  								type: 'value'
		  							},
		  							legend: {
		  								data: ['Location report quantity'],
		  								left: 'right'
		  						},
		  							series: [{
		  								name:'Location report quantity',
		  								data: values,
		  								type: 'line',
		  								smooth: true
		  							}]
		  						};
		  				
		  				myChart2.setOption(op);
		    } 
		    this.dataListLoading = false;
		  });
	        
	  }
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
