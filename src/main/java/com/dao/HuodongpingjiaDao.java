package com.dao;

import com.entity.HuodongpingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongpingjiaVO;
import com.entity.view.HuodongpingjiaView;


/**
 * 活动评价
 */
public interface HuodongpingjiaDao extends BaseMapper<HuodongpingjiaEntity> {
	
	List<HuodongpingjiaVO> selectListVO(@Param("ew") Wrapper<HuodongpingjiaEntity> wrapper);
	
	HuodongpingjiaVO selectVO(@Param("ew") Wrapper<HuodongpingjiaEntity> wrapper);
	
	List<HuodongpingjiaView> selectListView(@Param("ew") Wrapper<HuodongpingjiaEntity> wrapper);

	List<HuodongpingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongpingjiaEntity> wrapper);
	
	HuodongpingjiaView selectView(@Param("ew") Wrapper<HuodongpingjiaEntity> wrapper);
	

}
