package com.entity.model;

import java.io.Serializable;

public class CallSOSModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public long getUserID() {
        return UserID;
    }

    public void setUserID(long userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSOSLatitude() {
        return SOSLatitude;
    }

    public void setSOSLatitude(String SOSLatitude) {
        this.SOSLatitude = SOSLatitude;
    }

    public String getSOSLongitude() {
        return SOSLongitude;
    }

    public void setSOSLongitude(String SOSLongitude) {
        this.SOSLongitude = SOSLongitude;
    }

    public String getCurrentLocation() {
        return CurrentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        CurrentLocation = currentLocation;
    }

    /**
     * 用户id主键
     */
    private long UserID;

    /**
     * 姓名
     */
    private String Name;

    /**
     * 纬度
     */
    private String SOSLatitude;

    /**
     * 经度
     */
    private String SOSLongitude;

    /**
     * 位置
     */
    private String CurrentLocation;
}
