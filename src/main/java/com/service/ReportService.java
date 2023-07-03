package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ReportEntity;
import com.entity.view.ReportView;
import com.entity.vo.ReportVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReportService extends IService<ReportEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ReportVO> selectListVO(Wrapper<ReportEntity> wrapper);

    ReportVO selectVO(@Param("ew") Wrapper<ReportEntity> wrapper);

    List<ReportView> selectListView(Wrapper<ReportEntity> wrapper);

    ReportView selectView(@Param("ew") Wrapper<ReportEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ReportEntity> wrapper);


    Map<String,Object> queryCount(String userId,String type);
}
