package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.MaterialEntity;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品
 */
public interface MaterialService extends IService<MaterialEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MaterialEntity> selectListVO(Wrapper<MaterialEntity> wrapper);

    MaterialEntity selectVO(@Param("ew") Wrapper<MaterialEntity> wrapper);

    List<MaterialEntity> selectListView(Wrapper<MaterialEntity> wrapper);

    MaterialEntity selectView(@Param("ew") Wrapper<MaterialEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<MaterialEntity> wrapper);


}

