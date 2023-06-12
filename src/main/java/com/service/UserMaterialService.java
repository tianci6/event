package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.MaterialEntity;
import com.entity.UserMaterialEntity;
import com.utils.PageUtils;
import com.utils.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品收藏
 */
public interface UserMaterialService extends IService<UserMaterialEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<UserMaterialEntity> selectListVO(Wrapper<UserMaterialEntity> wrapper);

    UserMaterialEntity selectVO(@Param("ew") Wrapper<UserMaterialEntity> wrapper);

    List<UserMaterialEntity> selectListView(Wrapper<UserMaterialEntity> wrapper);

    UserMaterialEntity selectView(@Param("ew") Wrapper<UserMaterialEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<UserMaterialEntity> wrapper);

    /**
     * 查询我的收藏
     * @method selectMyCollect
     * @param userId:
     * @return java.util.List<com.entity.MaterialEntity>
     * @date 2023/6/12 11:14
     **/
    List<MaterialEntity> selectMyCollect(Long userId);

    /**
     * 收藏/取消收藏
     * @method collectMaterial
     * @param userId:
     * @param material:
     * @param type:
     * @return int
     * @author TJ
     * @date 2023/6/12 11:24
     **/
    R collectMaterial(Long userId, Long material, String type);

    /**
     * 根据用户ID + 商品ID查询
     * @param userId
     * @param materialId
     * @return
     */
    public UserMaterialEntity selectByUserIdAndMaterialId(Long userId, Long materialId);
}

