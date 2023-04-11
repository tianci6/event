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


import com.dao.ShequchangdiDao;
import com.entity.ShequchangdiEntity;
import com.service.ShequchangdiService;
import com.entity.vo.ShequchangdiVO;
import com.entity.view.ShequchangdiView;

@Service("shequchangdiService")
public class ShequchangdiServiceImpl extends ServiceImpl<ShequchangdiDao, ShequchangdiEntity> implements ShequchangdiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShequchangdiEntity> page = this.selectPage(
                new Query<ShequchangdiEntity>(params).getPage(),
                new EntityWrapper<ShequchangdiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShequchangdiEntity> wrapper) {
		  Page<ShequchangdiView> page =new Query<ShequchangdiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShequchangdiVO> selectListVO(Wrapper<ShequchangdiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShequchangdiVO selectVO(Wrapper<ShequchangdiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShequchangdiView> selectListView(Wrapper<ShequchangdiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShequchangdiView selectView(Wrapper<ShequchangdiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
