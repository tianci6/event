package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MaterialEntity;
import com.entity.UserMaterialEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 商品收藏
 */
public interface UserMaterialDao extends BaseMapper<UserMaterialEntity> {

    List<UserMaterialEntity> selectListVO(@Param("ew") Wrapper<UserMaterialEntity> wrapper);

    UserMaterialEntity selectVO(@Param("ew") Wrapper<UserMaterialEntity> wrapper);

    List<UserMaterialEntity> selectListView(@Param("ew") Wrapper<UserMaterialEntity> wrapper);

    List<UserMaterialEntity> selectListView(Pagination page, @Param("ew") Wrapper<UserMaterialEntity> wrapper);

    UserMaterialEntity selectView(@Param("ew") Wrapper<UserMaterialEntity> wrapper);


    /**
     * 查询我的收藏
     * @method selectMyCollect
     * @param userId:
     * @return java.util.List<com.entity.MaterialEntity>
     * @date 2023/6/12 11:15
     **/
    List<MaterialEntity> selectMyCollect(Long userId);

    /**
     * 根据用户ID + 商品ID查询
     * @method selectByUserIdAndMaterialId
     * @param userId:
     * @param materialId:
     * @return com.entity.UserMaterialEntity
     * @date 2023/6/12 11:25
     **/
    UserMaterialEntity selectByUserIdAndMaterialId(@Param("userId") Long userId, @Param("materialId") Long materialId);
}
