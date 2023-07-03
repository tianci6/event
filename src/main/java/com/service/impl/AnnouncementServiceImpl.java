package com.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AnnouncementDao;
import com.entity.AnnoucementEntity;
import com.entity.view.AnnouncementView;
import com.service.AnnouncementService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service("announcementService")
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementDao, AnnoucementEntity> implements AnnouncementService {
	
	@Autowired
	private AnnouncementDao announcementDao;

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnnoucementEntity> wrapper) {
		  Page<AnnouncementView> page =new Query<AnnouncementView>(params).getPage();
		List<AnnouncementView> announcementViews = baseMapper.selectListView(page, wrapper);

		page.setRecords(announcementViews);
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

	@Override
	public void deleteBatchIdList(List<Long> ids) {
		for (Long id : ids) {
			announcementDao.deleteById(id);
		}
	}

	@Override
	public AnnoucementEntity queryById(Long id) {
		return announcementDao.queryById(id);
	}

	@Override
	public void insertItem(AnnoucementEntity param) {
		announcementDao.insertItem(param);
	}

	@Override
	public void updateItem(AnnoucementEntity param) {
		announcementDao.updateItem(param);
	}

	@Override
	public List<AnnoucementEntity> queryList() {
		return announcementDao.queryList();
	}


}
