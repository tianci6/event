package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MaterialEntity;
import com.entity.MaterialEvaluateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 商品评论
 */
public interface MaterialEvaluateDao extends BaseMapper<MaterialEvaluateEntity> {

    List<MaterialEvaluateEntity> selectListVO(@Param("ew") Wrapper<MaterialEvaluateEntity> wrapper);

    MaterialEvaluateEntity selectVO(@Param("ew") Wrapper<MaterialEvaluateEntity> wrapper);

    List<MaterialEvaluateEntity> selectListView(@Param("ew") Wrapper<MaterialEvaluateEntity> wrapper);

    List<MaterialEvaluateEntity> selectListView(Pagination page, @Param("ew") Wrapper<MaterialEvaluateEntity> wrapper);

    MaterialEvaluateEntity selectView(@Param("ew") Wrapper<MaterialEvaluateEntity> wrapper);


    /**
     * 商品评论查询
     * @param id
     * @return
     */
    List<MaterialEvaluateEntity> getByMaterial(Long id);
}
