package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ToupiaotongjiDao;
import com.entity.ToupiaotongjiEntity;
import com.service.ToupiaotongjiService;
import com.entity.vo.ToupiaotongjiVO;
import com.entity.view.ToupiaotongjiView;

@Service("toupiaotongjiService")
public class ToupiaotongjiServiceImpl extends ServiceImpl<ToupiaotongjiDao, ToupiaotongjiEntity> implements ToupiaotongjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ToupiaotongjiEntity> page = this.selectPage(
                new Query<ToupiaotongjiEntity>(params).getPage(),
                new EntityWrapper<ToupiaotongjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ToupiaotongjiEntity> wrapper) {
		  Page<ToupiaotongjiView> page =new Query<ToupiaotongjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ToupiaotongjiVO> selectListVO(Wrapper<ToupiaotongjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ToupiaotongjiVO selectVO(Wrapper<ToupiaotongjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ToupiaotongjiView> selectListView(Wrapper<ToupiaotongjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ToupiaotongjiView selectView(Wrapper<ToupiaotongjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ToupiaotongjiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ToupiaotongjiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ToupiaotongjiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
