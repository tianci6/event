package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshequchangdiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshequchangdiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshequchangdiView;


/**
 * 社区场地评论表
	fengtianci
 */
public interface DiscussshequchangdiService extends IService<DiscussshequchangdiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshequchangdiVO> selectListVO(Wrapper<DiscussshequchangdiEntity> wrapper);
   	
   	DiscussshequchangdiVO selectVO(@Param("ew") Wrapper<DiscussshequchangdiEntity> wrapper);
   	
   	List<DiscussshequchangdiView> selectListView(Wrapper<DiscussshequchangdiEntity> wrapper);
   	
   	DiscussshequchangdiView selectView(@Param("ew") Wrapper<DiscussshequchangdiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshequchangdiEntity> wrapper);
   	

}

