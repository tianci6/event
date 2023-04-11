package com.dao;

import com.entity.DiscussshequchangdiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshequchangdiVO;
import com.entity.view.DiscussshequchangdiView;


/**
 * 社区场地评论表
 * 
 * @author 
 * @email 
 * @date 2022-08-01 07:36:10
 */
public interface DiscussshequchangdiDao extends BaseMapper<DiscussshequchangdiEntity> {
	
	List<DiscussshequchangdiVO> selectListVO(@Param("ew") Wrapper<DiscussshequchangdiEntity> wrapper);
	
	DiscussshequchangdiVO selectVO(@Param("ew") Wrapper<DiscussshequchangdiEntity> wrapper);
	
	List<DiscussshequchangdiView> selectListView(@Param("ew") Wrapper<DiscussshequchangdiEntity> wrapper);

	List<DiscussshequchangdiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshequchangdiEntity> wrapper);
	
	DiscussshequchangdiView selectView(@Param("ew") Wrapper<DiscussshequchangdiEntity> wrapper);
	

}
