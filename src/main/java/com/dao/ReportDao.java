package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ReportEntity;
import com.entity.view.ReportCount;
import com.entity.view.ReportLocationCount;
import com.entity.view.ReportView;
import com.entity.vo.ReportVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportDao extends BaseMapper<ReportEntity> {

    List<ReportVO> selectListVO(@Param("ew") Wrapper<ReportEntity> wrapper);

    ReportVO selectVO(@Param("ew") Wrapper<ReportEntity> wrapper);

    List<ReportView> selectListView(@Param("ew") Wrapper<ReportEntity> wrapper);

    List<ReportView> selectListView(Pagination page, @Param("ew") Wrapper<ReportEntity> wrapper);

    ReportView selectView(@Param("ew") Wrapper<ReportEntity> wrapper);

    List<ReportCount> queryCount(@Param("userId")String userId);

    List<ReportCount> queryLineCount(@Param("userId")String userId);

    List<ReportLocationCount> queryLocationCount(@Param("userId")String userId,@Param("type")String type);

    List<ReportLocationCount> queryLocationLineCount(@Param("userId")String userId,@Param("type")String type);
}
