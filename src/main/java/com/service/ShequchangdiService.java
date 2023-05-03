package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShequchangdiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShequchangdiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShequchangdiView;


/**
 * 社区场地
 */
public interface ShequchangdiService extends IService<ShequchangdiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShequchangdiVO> selectListVO(Wrapper<ShequchangdiEntity> wrapper);
   	
   	ShequchangdiVO selectVO(@Param("ew") Wrapper<ShequchangdiEntity> wrapper);
   	
   	List<ShequchangdiView> selectListView(Wrapper<ShequchangdiEntity> wrapper);
   	
   	ShequchangdiView selectView(@Param("ew") Wrapper<ShequchangdiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShequchangdiEntity> wrapper);
   	

}

