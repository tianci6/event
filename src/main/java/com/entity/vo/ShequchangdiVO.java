package com.entity.vo;

import com.entity.ShequchangdiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 社区场地
 * 手机端接口返回实体辅助类 

 */
public class ShequchangdiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 场地设施
	 */
	
	private String changdisheshi;
		
	/**
	 * 场地图片
	 */
	
	private String changditupian;
		
	/**
	 * 场地区域
	 */
	
	private String changdiquyu;
		
	/**
	 * 场地安排
	 */
	
	private String changdianpai;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 场地详情
	 */
	
	private String changdixiangqing;
		
	/**
	 * 使用时间
	 */
	
	private String shiyongshijian;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：场地设施
	 */
	 
	public void setChangdisheshi(String changdisheshi) {
		this.changdisheshi = changdisheshi;
	}
	
	/**
	 * 获取：场地设施
	 */
	public String getChangdisheshi() {
		return changdisheshi;
	}
				
	
	/**
	 * 设置：场地图片
	 */
	 
	public void setChangditupian(String changditupian) {
		this.changditupian = changditupian;
	}
	
	/**
	 * 获取：场地图片
	 */
	public String getChangditupian() {
		return changditupian;
	}
				
	
	/**
	 * 设置：场地区域
	 */
	 
	public void setChangdiquyu(String changdiquyu) {
		this.changdiquyu = changdiquyu;
	}
	
	/**
	 * 获取：场地区域
	 */
	public String getChangdiquyu() {
		return changdiquyu;
	}
				
	
	/**
	 * 设置：场地安排
	 */
	 
	public void setChangdianpai(String changdianpai) {
		this.changdianpai = changdianpai;
	}
	
	/**
	 * 获取：场地安排
	 */
	public String getChangdianpai() {
		return changdianpai;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：场地详情
	 */
	 
	public void setChangdixiangqing(String changdixiangqing) {
		this.changdixiangqing = changdixiangqing;
	}
	
	/**
	 * 获取：场地详情
	 */
	public String getChangdixiangqing() {
		return changdixiangqing;
	}
				
	
	/**
	 * 设置：使用时间
	 */
	 
	public void setShiyongshijian(String shiyongshijian) {
		this.shiyongshijian = shiyongshijian;
	}
	
	/**
	 * 获取：使用时间
	 */
	public String getShiyongshijian() {
		return shiyongshijian;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
