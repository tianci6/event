package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MaterialEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 商品
 */
public interface MaterialDao extends BaseMapper<MaterialEntity> {

    List<MaterialEntity> selectListVO(@Param("ew") Wrapper<MaterialEntity> wrapper);

    MaterialEntity selectVO(@Param("ew") Wrapper<MaterialEntity> wrapper);

    List<MaterialEntity> selectListView(@Param("ew") Wrapper<MaterialEntity> wrapper);

    List<MaterialEntity> selectListView(Pagination page, @Param("ew") Wrapper<MaterialEntity> wrapper);

    MaterialEntity selectView(@Param("ew") Wrapper<MaterialEntity> wrapper);

    /**
     * 查询用户商品
     * @method selectByUserId
     * @param userId:
     * @return java.util.List<com.entity.MaterialEntity>
     * @date 2023/6/12 11:06
     **/
    List<MaterialEntity> selectByUserId(Long userId);

}
