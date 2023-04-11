package com.dao;

import com.entity.ShequchangdiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShequchangdiVO;
import com.entity.view.ShequchangdiView;


/**
 * 社区场地
 */
public interface ShequchangdiDao extends BaseMapper<ShequchangdiEntity> {
	
	List<ShequchangdiVO> selectListVO(@Param("ew") Wrapper<ShequchangdiEntity> wrapper);
	
	ShequchangdiVO selectVO(@Param("ew") Wrapper<ShequchangdiEntity> wrapper);
	
	List<ShequchangdiView> selectListView(@Param("ew") Wrapper<ShequchangdiEntity> wrapper);

	List<ShequchangdiView> selectListView(Pagination page,@Param("ew") Wrapper<ShequchangdiEntity> wrapper);
	
	ShequchangdiView selectView(@Param("ew") Wrapper<ShequchangdiEntity> wrapper);
	

}
