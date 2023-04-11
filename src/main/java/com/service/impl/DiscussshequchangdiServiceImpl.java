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


import com.dao.DiscussshequchangdiDao;
import com.entity.DiscussshequchangdiEntity;
import com.service.DiscussshequchangdiService;
import com.entity.vo.DiscussshequchangdiVO;
import com.entity.view.DiscussshequchangdiView;

@Service("discussshequchangdiService")
public class DiscussshequchangdiServiceImpl extends ServiceImpl<DiscussshequchangdiDao, DiscussshequchangdiEntity> implements DiscussshequchangdiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshequchangdiEntity> page = this.selectPage(
                new Query<DiscussshequchangdiEntity>(params).getPage(),
                new EntityWrapper<DiscussshequchangdiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshequchangdiEntity> wrapper) {
		  Page<DiscussshequchangdiView> page =new Query<DiscussshequchangdiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshequchangdiVO> selectListVO(Wrapper<DiscussshequchangdiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshequchangdiVO selectVO(Wrapper<DiscussshequchangdiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshequchangdiView> selectListView(Wrapper<DiscussshequchangdiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshequchangdiView selectView(Wrapper<DiscussshequchangdiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
