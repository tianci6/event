package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MaterialDao;
import com.dao.MaterialEvaluateDao;
import com.entity.MaterialEntity;
import com.entity.MaterialEvaluateEntity;
import com.service.MaterialEvaluateService;
import com.service.MaterialService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品评论
 */
@Service("materialEvaluateService")
public class MaterialEvaluateServiceImpl extends ServiceImpl<MaterialEvaluateDao, MaterialEvaluateEntity> implements MaterialEvaluateService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MaterialEvaluateEntity> page = this.selectPage(
                new Query<MaterialEvaluateEntity>(params).getPage(),
                new EntityWrapper<MaterialEvaluateEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<MaterialEvaluateEntity> wrapper) {
        Page<MaterialEvaluateEntity> page = new Query<MaterialEvaluateEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<MaterialEvaluateEntity> selectListVO(Wrapper<MaterialEvaluateEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public MaterialEvaluateEntity selectVO(Wrapper<MaterialEvaluateEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<MaterialEvaluateEntity> selectListView(Wrapper<MaterialEvaluateEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public MaterialEvaluateEntity selectView(Wrapper<MaterialEvaluateEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    /**
     * 商品评论查询
     * @param id
     * @return
     */
    @Override
    public List<MaterialEvaluateEntity> getByMaterial(Long id){
        return baseMapper.getByMaterial(id);
    }


}
