package com.dao;

import com.entity.ShequgonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShequgonggaoVO;
import com.entity.view.ShequgonggaoView;


/**
 * 社区公告
 */
public interface ShequgonggaoDao extends BaseMapper<ShequgonggaoEntity> {
	
	List<ShequgonggaoVO> selectListVO(@Param("ew") Wrapper<ShequgonggaoEntity> wrapper);
	
	ShequgonggaoVO selectVO(@Param("ew") Wrapper<ShequgonggaoEntity> wrapper);
	
	List<ShequgonggaoView> selectListView(@Param("ew") Wrapper<ShequgonggaoEntity> wrapper);

	List<ShequgonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<ShequgonggaoEntity> wrapper);
	
	ShequgonggaoView selectView(@Param("ew") Wrapper<ShequgonggaoEntity> wrapper);
	

}
