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
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品评论
 * @description material
 * @author
 * @date 2023-06-07
 */
@Data
@TableName("b_material_evaluate")
public class MaterialEvaluateEntity implements Serializable {

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
     * 评价用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long materialId;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 评分
     */
    private BigDecimal score;

    private String username;
    private String userphone;


    public MaterialEvaluateEntity() {}
}
