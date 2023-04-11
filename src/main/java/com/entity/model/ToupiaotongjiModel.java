package com.entity.model;

import com.entity.ToupiaotongjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 


public class ToupiaotongjiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 投票选项
	 */
	
	private String toupiaoxuanxiang;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 居民号
	 */
	
	private String juminhao;
		
	/**
	 * 居民姓名
	 */
	
	private String juminxingming;
				
	
	/**
	 * 设置：投票选项
	 */
	 
	public void setToupiaoxuanxiang(String toupiaoxuanxiang) {
		this.toupiaoxuanxiang = toupiaoxuanxiang;
	}
	
	/**
	 * 获取：投票选项
	 */
	public String getToupiaoxuanxiang() {
		return toupiaoxuanxiang;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
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
			
}
