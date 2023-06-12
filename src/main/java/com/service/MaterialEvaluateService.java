package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.MaterialEvaluateEntity;
import com.entity.MaterialEvaluateEntity;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品评论
 */
public interface MaterialEvaluateService extends IService<MaterialEvaluateEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MaterialEvaluateEntity> selectListVO(Wrapper<MaterialEvaluateEntity> wrapper);

    MaterialEvaluateEntity selectVO(@Param("ew") Wrapper<MaterialEvaluateEntity> wrapper);

    List<MaterialEvaluateEntity> selectListView(Wrapper<MaterialEvaluateEntity> wrapper);

    MaterialEvaluateEntity selectView(@Param("ew") Wrapper<MaterialEvaluateEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<MaterialEvaluateEntity> wrapper);


}

