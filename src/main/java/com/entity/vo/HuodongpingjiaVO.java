package com.entity.vo;

import com.entity.HuodongpingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 活动评价
 * 手机端接口返回实体辅助类 

 */
public class HuodongpingjiaVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 活动名称
	 */
	
	private String huodongmingcheng;
		
	/**
	 * 活动时间
	 */
	
	private String huodongshijian;
		
	/**
	 * 活动地点
	 */
	
	private String huodongdidian;
		
	/**
	 * 报名时间
	 */
	
	private String baomingshijian;
		
	/**
	 * 活动评价
	 */
	
	private String huodongpingjia;
		
	/**
	 * 评价时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pingjiashijian;
		
	/**
	 * 居民号
	 */
	
	private String juminhao;
		
	/**
	 * 居民姓名
	 */
	
	private String juminxingming;
		
	/**
	 * 居民手机
	 */
	
	private String juminshouji;
				
	
	/**
	 * 设置：活动名称
	 */
	 
	public void setHuodongmingcheng(String huodongmingcheng) {
		this.huodongmingcheng = huodongmingcheng;
	}
	
	/**
	 * 获取：活动名称
	 */
	public String getHuodongmingcheng() {
		return huodongmingcheng;
	}
				
	
	/**
	 * 设置：活动时间
	 */
	 
	public void setHuodongshijian(String huodongshijian) {
		this.huodongshijian = huodongshijian;
	}
	
	/**
	 * 获取：活动时间
	 */
	public String getHuodongshijian() {
		return huodongshijian;
	}
				
	
	/**
	 * 设置：活动地点
	 */
	 
	public void setHuodongdidian(String huodongdidian) {
		this.huodongdidian = huodongdidian;
	}
	
	/**
	 * 获取：活动地点
	 */
	public String getHuodongdidian() {
		return huodongdidian;
	}
				
	
	/**
	 * 设置：报名时间
	 */
	 
	public void setBaomingshijian(String baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	
	/**
	 * 获取：报名时间
	 */
	public String getBaomingshijian() {
		return baomingshijian;
	}
				
	
	/**
	 * 设置：活动评价
	 */
	 
	public void setHuodongpingjia(String huodongpingjia) {
		this.huodongpingjia = huodongpingjia;
	}
	
	/**
	 * 获取：活动评价
	 */
	public String getHuodongpingjia() {
		return huodongpingjia;
	}
				
	
	/**
	 * 设置：评价时间
	 */
	 
	public void setPingjiashijian(Date pingjiashijian) {
		this.pingjiashijian = pingjiashijian;
	}
	
	/**
	 * 获取：评价时间
	 */
	public Date getPingjiashijian() {
		return pingjiashijian;
	}
				
	
	/**
	 * 设置：居民号
	 */
	 
	public void setJuminhao(String juminhao) {
		this.juminhao = juminhao;
	}
	
	/**
	 * 获取：居民号
	 */
	public String getJuminhao() {
		return juminhao;
	}
				
	
	/**
	 * 设置：居民姓名
	 */
	 
	public void setJuminxingming(String juminxingming) {
		this.juminxingming = juminxingming;
	}
	
	/**
	 * 获取：居民姓名
	 */
	public String getJuminxingming() {
		return juminxingming;
	}
				
	
	/**
	 * 设置：居民手机
	 */
	 
	public void setJuminshouji(String juminshouji) {
		this.juminshouji = juminshouji;
	}
	
	/**
	 * 获取：居民手机
	 */
	public String getJuminshouji() {
		return juminshouji;
	}
			
}
