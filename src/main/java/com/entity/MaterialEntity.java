/**
 * Copyright (c) 2019-2099
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description material
 * @author
 * @date 2023-06-07
 */
@Data
@TableName("b_material")
public class MaterialEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 最后更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date updateTime;

    /**
     * 最近更新人
     */
    private String updateBy;

    /**
     * 状态：1-有效；0-无效
     */
    private String state;

    /**
     * 发布人用户id
     */
    private Long userId;

    /**
     * 商品类型：a-活动；b-商店；c-二手商品；
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    /**
     * 邮件
     */
    private String email;

    /**
     * 介绍
     */
    private String content;

    /**
     * 描述
     */
    private String describe;

    /**
     * 地址
     */
    private String address;

    /**
     * 图片信息
     */
    private String imgUrl;

    public MaterialEntity() {}
}
