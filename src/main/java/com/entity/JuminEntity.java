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
 * 居民
 * 数据库通用操作实体类（普通增删改查）

 */
@TableName("jumin")
public class JuminEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JuminEntity() {
		
	}
	
	public JuminEntity(T t) {
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
	 * 居民号
	 */
					
	private String juminhao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 居民姓名
	 */
					
	private String juminxingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private Integer nianling;
	
	/**
	 * 居民照片
	 */
					
	private String juminzhaopian;
	
	/**
	 * 居民手机
	 */
					
	private String juminshouji;
	
	/**
	 * 居住地址
	 */
					
	private String juzhudizhi;
	
	/**
	 * 门牌号
	 */
					
	private String menpaihao;
	
	/**
	 * 单元号
	 */
					
	private String danyuanhao;
	
	
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
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
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
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
	/**
	 * 设置：居民照片
	 */
	public void setJuminzhaopian(String juminzhaopian) {
		this.juminzhaopian = juminzhaopian;
	}
	/**
	 * 获取：居民照片
	 */
	public String getJuminzhaopian() {
		return juminzhaopian;
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
	 * 设置：居住地址
	 */
	public void setJuzhudizhi(String juzhudizhi) {
		this.juzhudizhi = juzhudizhi;
	}
	/**
	 * 获取：居住地址
	 */
	public String getJuzhudizhi() {
		return juzhudizhi;
	}
	/**
	 * 设置：门牌号
	 */
	public void setMenpaihao(String menpaihao) {
		this.menpaihao = menpaihao;
	}
	/**
	 * 获取：门牌号
	 */
	public String getMenpaihao() {
		return menpaihao;
	}
	/**
	 * 设置：单元号
	 */
	public void setDanyuanhao(String danyuanhao) {
		this.danyuanhao = danyuanhao;
	}
	/**
	 * 获取：单元号
	 */
	public String getDanyuanhao() {
		return danyuanhao;
	}

}
