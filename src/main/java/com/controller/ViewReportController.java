package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ReportEntity;
import com.entity.view.ReportView;
import com.service.ReportService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 上传报告
 * 后端接口
 *
 *
 */
@RestController
@RequestMapping("/vreport")
public class ViewReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 后端列表
     *
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ReportEntity viewReport,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("userdetails")) {
            viewReport.setUserid((long)request.getSession().getAttribute("Name"));
        }
        EntityWrapper<ReportEntity> ew = new EntityWrapper<ReportEntity>();

        PageUtils page = reportService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, viewReport), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     *
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ReportEntity viewReport,
                  HttpServletRequest request){
        EntityWrapper<ReportEntity> ew = new EntityWrapper<ReportEntity>();

        PageUtils page = reportService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, viewReport), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     *
     */
    @RequestMapping("/lists")
    public R list( ReportEntity viewReport){
        EntityWrapper<ReportEntity> ew = new EntityWrapper<ReportEntity>();
        ew.allEq(MPUtil.allEQMapPre( viewReport, "viewReport"));
        return R.ok().put("data", reportService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ReportEntity viewReport){
        EntityWrapper< ReportEntity> ew = new EntityWrapper< ReportEntity>();
        ew.allEq(MPUtil.allEQMapPre( viewReport, "viewReport"));
        ReportView viewReportView =  reportService.selectView(ew);
        return R.ok("查询报名成功").put("data", viewReportView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ReportEntity viewReport = reportService.selectById(id);
        return R.ok().put("data", viewReport);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ReportEntity viewReport = reportService.selectById(id);
        return R.ok().put("data", viewReport);
    }

    /**
     * 后端保存
     *///这里这里这里
    @RequestMapping("/save")
    public R save(@RequestBody ReportEntity viewReport, HttpServletRequest request){
        viewReport.setUserid(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(viewReport);
        reportService.insert(viewReport);
        return R.ok();
    }

    /**
     * 前端保存
     *///这里这里这里
    @RequestMapping("/add")
    public R add(@RequestBody ReportEntity viewReport, HttpServletRequest request){
        viewReport.setUserid(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(viewReport);
        reportService.insert(viewReport);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ReportEntity viewReport, HttpServletRequest request){
        //ValidatorUtils.validateEntity(viewReport);
        reportService.updateById(viewReport);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        reportService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if(type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if(map.get("remindstart")!=null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if(map.get("remindend")!=null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<ReportEntity> wrapper = new EntityWrapper<ReportEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("userdetails")) {
            wrapper.eq("User_Number", (String)request.getSession().getAttribute("Name"));
        }

        int count = reportService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}

