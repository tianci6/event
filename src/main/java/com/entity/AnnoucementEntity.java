package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 居民
 * 数据库通用操作实体类（普通增删改查）

 */
@TableName("announcement")
public class AnnoucementEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AnnoucementEntity() {

	}

	public AnnoucementEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 公告序号
	 */
	@TableId
	private Long annoucementid;
	/**
	 * 公告位置纬度
	 */
					
	private String announcementlatitude;
	
	/**
	 * 公告位置经度
	 */
					
	private String announcemnetlongitude;
	
	/**
	 * 公告内容
	 */
					
	private String announcementdescription;
	
	/**
	 * 公告照片
	 */
					
	private String announcementphoto;
	
	/**
	 * 公告日期
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date announcementdate;

	public Long getAnnoucementid() {
		return annoucementid;
	}

	public void setAnnoucementid(Long annoucementid) {
		this.annoucementid = annoucementid;
	}

	public String getAnnouncementlatitude() {
		return announcementlatitude;
	}

	public void setAnnouncementlatitude(String announcementlatitude) {
		this.announcementlatitude = announcementlatitude;
	}

	public String getAnnouncemnetlongitude() {
		return announcemnetlongitude;
	}

	public void setAnnouncemnetlongitude(String announcemnetlongitude) {
		this.announcemnetlongitude = announcemnetlongitude;
	}

	public String getAnnouncementdescription() {
		return announcementdescription;
	}

	public void setAnnouncementdescription(String announcementdescription) {
		this.announcementdescription = announcementdescription;
	}

	public String getAnnouncementphoto() {
		return announcementphoto;
	}

	public void setAnnouncementphoto(String announcementphoto) {
		this.announcementphoto = announcementphoto;
	}

	public Date getAnnouncementdate() {
		return announcementdate;
	}

	public void setAnnouncementdate(Date announcementdate) {
		this.announcementdate = announcementdate;
	}
}
