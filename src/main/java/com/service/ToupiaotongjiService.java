package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ToupiaotongjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ToupiaotongjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ToupiaotongjiView;


/**
 * 投票统计

 */
public interface ToupiaotongjiService extends IService<ToupiaotongjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ToupiaotongjiVO> selectListVO(Wrapper<ToupiaotongjiEntity> wrapper);
   	
   	ToupiaotongjiVO selectVO(@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);
   	
   	List<ToupiaotongjiView> selectListView(Wrapper<ToupiaotongjiEntity> wrapper);
   	
   	ToupiaotongjiView selectView(@Param("ew") Wrapper<ToupiaotongjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ToupiaotongjiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ToupiaotongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ToupiaotongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ToupiaotongjiEntity> wrapper);
}

