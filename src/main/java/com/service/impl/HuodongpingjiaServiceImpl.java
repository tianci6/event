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


import com.dao.HuodongpingjiaDao;
import com.entity.HuodongpingjiaEntity;
import com.service.HuodongpingjiaService;
import com.entity.vo.HuodongpingjiaVO;
import com.entity.view.HuodongpingjiaView;

@Service("huodongpingjiaService")
public class HuodongpingjiaServiceImpl extends ServiceImpl<HuodongpingjiaDao, HuodongpingjiaEntity> implements HuodongpingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongpingjiaEntity> page = this.selectPage(
                new Query<HuodongpingjiaEntity>(params).getPage(),
                new EntityWrapper<HuodongpingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongpingjiaEntity> wrapper) {
		  Page<HuodongpingjiaView> page =new Query<HuodongpingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongpingjiaVO> selectListVO(Wrapper<HuodongpingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongpingjiaVO selectVO(Wrapper<HuodongpingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongpingjiaView> selectListView(Wrapper<HuodongpingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongpingjiaView selectView(Wrapper<HuodongpingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
