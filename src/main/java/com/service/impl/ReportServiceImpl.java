package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ReportDao;
import com.entity.ReportEntity;
import com.entity.view.ReportCount;
import com.entity.view.ReportView;
import com.entity.vo.ReportVO;
import com.service.ReportService;
import com.utils.PageUtils;
import com.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reportService")
public class ReportServiceImpl extends ServiceImpl<ReportDao, ReportEntity> implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ReportEntity> page = this.selectPage(
                new Query<ReportEntity>(params).getPage(),
                new EntityWrapper<ReportEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<ReportVO> selectListVO(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ReportVO selectVO(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ReportView> selectListView(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ReportView selectView(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ReportEntity> wrapper) {
        Page<ReportView> page =new Query<ReportView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,new EntityWrapper<ReportEntity>()));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public Map<String,Object> queryCount(String userId,String type) {
        Map<String,Object> result = new HashMap<>();
        result.put("numCount",reportDao.queryCount(userId));
        List<ReportCount> reportCounts = reportDao.queryLineCount(userId);
        Map<String,Map<String,Integer>> lineData = new HashMap<>();
        for (ReportCount reportCount : reportCounts) {
            if (lineData.get(reportCount.getDateStr()) == null) {
                lineData.put(reportCount.getDateStr(),new HashMap<>());
            }
            if ("Crime Sence".equals(reportCount.getReportType())) {
                reportCount.setReportType("crime");
            }
            if ("Traffic Accident".equals(reportCount.getReportType())) {
                reportCount.setReportType("accident");
            }
            lineData.get(reportCount.getDateStr()).put(reportCount.getReportType(),Integer.parseInt(reportCount.getTypeNum()));
        }

        for (String date : lineData.keySet()) {
            int total = 0;
            for (String s : lineData.get(date).keySet()) {
                total += lineData.get(date).get(s).intValue();
            }
            lineData.get(date).put("total",total);
        }
        result.put("lineData",lineData);

        if (StringUtils.isNotEmpty(type)) {
            type = "1".equals(type) ? "Traffic Accident" : "Crime Sence";
            result.put("locationCount",reportDao.queryLocationCount(userId,type));
            result.put("locationLineCount",reportDao.queryLocationLineCount(userId,type));
        }
        return result;
    }
}
