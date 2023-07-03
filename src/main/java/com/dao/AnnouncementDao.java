package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AnnoucementEntity;
import com.entity.view.AnnouncementView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 居民
 */
public interface AnnouncementDao extends BaseMapper<AnnoucementEntity> {
	

	List<AnnouncementView> selectListView(Pagination page, @Param("ew") Wrapper<AnnoucementEntity> wrapper);


	void deleteById(@Param("id")Long id);

	AnnoucementEntity queryById(@Param("id")Long id);

	void insertItem(@Param("params")AnnoucementEntity param);

	void updateItem(@Param("params")AnnoucementEntity param);

	List<AnnoucementEntity> queryList();

}
