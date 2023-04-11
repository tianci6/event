package com.dao;

import com.entity.ToupiaotongjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ToupiaotongjiVO;
import com.entity.view.ToupiaotongjiView;


/**
 * 投票统计
 * 可能用不到，希望
 */
public interface ToupiaotongjiDao extends BaseMapper<ToupiaotongjiEntity> {
	
	List<ToupiaotongjiVO> selectListVO(@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);
	
	ToupiaotongjiVO selectVO(@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);
	
	List<ToupiaotongjiView> selectListView(@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);

	List<ToupiaotongjiView> selectListView(Pagination page,@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);
	
	ToupiaotongjiView selectView(@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);
}
