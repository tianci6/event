package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongpingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongpingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongpingjiaView;


/**
 * 活动评价
 */
public interface HuodongpingjiaService extends IService<HuodongpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongpingjiaVO> selectListVO(Wrapper<HuodongpingjiaEntity> wrapper);
   	
   	HuodongpingjiaVO selectVO(@Param("ew") Wrapper<HuodongpingjiaEntity> wrapper);
   	
   	List<HuodongpingjiaView> selectListView(Wrapper<HuodongpingjiaEntity> wrapper);
   	
   	HuodongpingjiaView selectView(@Param("ew") Wrapper<HuodongpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongpingjiaEntity> wrapper);
   	

}

