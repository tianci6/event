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

    /**
     * 查询用户商品
     * @method selectByUserId
     * @param userId:
     * @return java.util.List<com.entity.MaterialEntity>
     * @date 2023/6/12 11:05
     **/
    List<MaterialEntity> selectByUserId(Long userId);

}

