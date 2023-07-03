package com.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 报告
 * 数据库通用操作实体类（普通增删改查）

 */
@TableName("report")
public class ReportEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *主键
     */
    @TableId
    private long userid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 类型
     */
    private String reporttype;

    /**
     * 分类
     */
    private String classification;

    /**
     * 时间
     */
    private String datetime;

    /**
     * 地点
     */
    private String location;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 电话
     */
    private String phone;

    /**
     * 描述
     */
    private String description;

    /**
     * 照片
     */
    private String photo;

    @Override
    public String toString() {
        return "ReportEntity{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", reporttype='" + reporttype + '\'' +
                ", classification='" + classification + '\'' +
                ", datetime='" + datetime + '\'' +
                ", location='" + location + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReporttype() {
        return reporttype;
    }

    public void setReporttype(String reporttype) {
        this.reporttype = reporttype;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
