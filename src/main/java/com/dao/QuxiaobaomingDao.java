package com.dao;

import com.entity.QuxiaobaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuxiaobaomingVO;
import com.entity.view.QuxiaobaomingView;


/**
 * 取消报名
 * 
 * @author 
 * @email 
 * @date 2022-08-01 07:36:10
 */
public interface QuxiaobaomingDao extends BaseMapper<QuxiaobaomingEntity> {
	
	List<QuxiaobaomingVO> selectListVO(@Param("ew") Wrapper<QuxiaobaomingEntity> wrapper);
	
	QuxiaobaomingVO selectVO(@Param("ew") Wrapper<QuxiaobaomingEntity> wrapper);
	
	List<QuxiaobaomingView> selectListView(@Param("ew") Wrapper<QuxiaobaomingEntity> wrapper);

	List<QuxiaobaomingView> selectListView(Pagination page,@Param("ew") Wrapper<QuxiaobaomingEntity> wrapper);
	
	QuxiaobaomingView selectView(@Param("ew") Wrapper<QuxiaobaomingEntity> wrapper);
	

}
