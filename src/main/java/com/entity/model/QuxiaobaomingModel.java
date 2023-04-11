package com.entity.model;

import com.entity.QuxiaobaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 


public class QuxiaobaomingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 活动类型
	 */
	
	private String huodongleixing;
		
	/**
	 * 活动地点
	 */
	
	private String huodongdidian;
		
	/**
	 * 开始时间
	 */
	
	private String kaishishijian;
		
	/**
	 * 结束时间
	 */
	
	private String jieshushijian;
		
	/**
	 * 报名截止
	 */
	
	private String baomingjiezhi;
		
	/**
	 * 报名人数
	 */
	
	private Integer baomingrenshu;
		
	/**
	 * 联系人
	 */
	
	private String lianxiren;
		
	/**
	 * 联络电话
	 */
	
	private String lianluodianhua;
		
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
	 * 取消原因
	 */
	
	private String quxiaoyuanyin;
		
	/**
	 * 取消时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date quxiaoshijian;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：活动类型
	 */
	 
	public void setHuodongleixing(String huodongleixing) {
		this.huodongleixing = huodongleixing;
	}
	
	/**
	 * 获取：活动类型
	 */
	public String getHuodongleixing() {
		return huodongleixing;
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
	 * 设置：开始时间
	 */
	 
	public void setKaishishijian(String kaishishijian) {
		this.kaishishijian = kaishishijian;
	}
	
	/**
	 * 获取：开始时间
	 */
	public String getKaishishijian() {
		return kaishishijian;
	}
				
	
	/**
	 * 设置：结束时间
	 */
	 
	public void setJieshushijian(String jieshushijian) {
		this.jieshushijian = jieshushijian;
	}
	
	/**
	 * 获取：结束时间
	 */
	public String getJieshushijian() {
		return jieshushijian;
	}
				
	
	/**
	 * 设置：报名截止
	 */
	 
	public void setBaomingjiezhi(String baomingjiezhi) {
		this.baomingjiezhi = baomingjiezhi;
	}
	
	/**
	 * 获取：报名截止
	 */
	public String getBaomingjiezhi() {
		return baomingjiezhi;
	}
				
	
	/**
	 * 设置：报名人数
	 */
	 
	public void setBaomingrenshu(Integer baomingrenshu) {
		this.baomingrenshu = baomingrenshu;
	}
	
	/**
	 * 获取：报名人数
	 */
	public Integer getBaomingrenshu() {
		return baomingrenshu;
	}
				
	
	/**
	 * 设置：联系人
	 */
	 
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	
	/**
	 * 获取：联系人
	 */
	public String getLianxiren() {
		return lianxiren;
	}
				
	
	/**
	 * 设置：联络电话
	 */
	 
	public void setLianluodianhua(String lianluodianhua) {
		this.lianluodianhua = lianluodianhua;
	}
	
	/**
	 * 获取：联络电话
	 */
	public String getLianluodianhua() {
		return lianluodianhua;
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
				
	
	/**
	 * 设置：取消原因
	 */
	 
	public void setQuxiaoyuanyin(String quxiaoyuanyin) {
		this.quxiaoyuanyin = quxiaoyuanyin;
	}
	
	/**
	 * 获取：取消原因
	 */
	public String getQuxiaoyuanyin() {
		return quxiaoyuanyin;
	}
				
	
	/**
	 * 设置：取消时间
	 */
	 
	public void setQuxiaoshijian(Date quxiaoshijian) {
		this.quxiaoshijian = quxiaoshijian;
	}
	
	/**
	 * 获取：取消时间
	 */
	public Date getQuxiaoshijian() {
		return quxiaoshijian;
	}
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
