package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 投票信息
 * 数据库通用操作实体类（普通增删改查）

 */
@TableName("toupiaoxinxi")
public class ToupiaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ToupiaoxinxiEntity() {
		
	}
	
	public ToupiaoxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 投票标题
	 */
					
	private String toupiaobiaoti;
	
	/**
	 * 开始时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date kaishishijian;
	
	/**
	 * 截止时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiezhishijian;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 投票内容
	 */
					
	private String toupiaoneirong;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：投票标题
	 */
	public void setToupiaobiaoti(String toupiaobiaoti) {
		this.toupiaobiaoti = toupiaobiaoti;
	}
	/**
	 * 获取：投票标题
	 */
	public String getToupiaobiaoti() {
		return toupiaobiaoti;
	}
	/**
	 * 设置：开始时间
	 */
	public void setKaishishijian(Date kaishishijian) {
		this.kaishishijian = kaishishijian;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getKaishishijian() {
		return kaishishijian;
	}
	/**
	 * 设置：截止时间
	 */
	public void setJiezhishijian(Date jiezhishijian) {
		this.jiezhishijian = jiezhishijian;
	}
	/**
	 * 获取：截止时间
	 */
	public Date getJiezhishijian() {
		return jiezhishijian;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：投票内容
	 */
	public void setToupiaoneirong(String toupiaoneirong) {
		this.toupiaoneirong = toupiaoneirong;
	}
	/**
	 * 获取：投票内容
	 */
	public String getToupiaoneirong() {
		return toupiaoneirong;
	}

}
