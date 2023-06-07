package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MaterialDao;
import com.entity.MaterialEntity;
import com.service.MaterialService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialDao, MaterialEntity> implements MaterialService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MaterialEntity> page = this.selectPage(
                new Query<MaterialEntity>(params).getPage(),
                new EntityWrapper<MaterialEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<MaterialEntity> wrapper) {
        Page<MaterialEntity> page = new Query<MaterialEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<MaterialEntity> selectListVO(Wrapper<MaterialEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public MaterialEntity selectVO(Wrapper<MaterialEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<MaterialEntity> selectListView(Wrapper<MaterialEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public MaterialEntity selectView(Wrapper<MaterialEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
