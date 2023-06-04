package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QuxiaobaomingEntity;
import com.entity.view.QuxiaobaomingView;

import com.service.QuxiaobaomingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 取消报名
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-01 07:36:10
 */
@RestController
@RequestMapping("/quxiaobaoming")
public class QuxiaobaomingController {
    @Autowired
    private QuxiaobaomingService quxiaobaomingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuxiaobaomingEntity quxiaobaoming,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jumin")) {
			quxiaobaoming.setJuminhao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuxiaobaomingEntity> ew = new EntityWrapper<QuxiaobaomingEntity>();

		PageUtils page = quxiaobaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaobaoming), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuxiaobaomingEntity quxiaobaoming, 
		HttpServletRequest request){
        EntityWrapper<QuxiaobaomingEntity> ew = new EntityWrapper<QuxiaobaomingEntity>();

		PageUtils page = quxiaobaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaobaoming), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuxiaobaomingEntity quxiaobaoming){
       	EntityWrapper<QuxiaobaomingEntity> ew = new EntityWrapper<QuxiaobaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quxiaobaoming, "quxiaobaoming")); 
        return R.ok().put("data", quxiaobaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuxiaobaomingEntity quxiaobaoming){
        EntityWrapper< QuxiaobaomingEntity> ew = new EntityWrapper< QuxiaobaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quxiaobaoming, "quxiaobaoming")); 
		QuxiaobaomingView quxiaobaomingView =  quxiaobaomingService.selectView(ew);
		return R.ok("查询取消报名成功").put("data", quxiaobaomingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuxiaobaomingEntity quxiaobaoming = quxiaobaomingService.selectById(id);
        return R.ok().put("data", quxiaobaoming);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuxiaobaomingEntity quxiaobaoming = quxiaobaomingService.selectById(id);
        return R.ok().put("data", quxiaobaoming);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuxiaobaomingEntity quxiaobaoming, HttpServletRequest request){
    	quxiaobaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quxiaobaoming);
        quxiaobaomingService.insert(quxiaobaoming);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuxiaobaomingEntity quxiaobaoming, HttpServletRequest request){
    	quxiaobaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quxiaobaoming);
        quxiaobaomingService.insert(quxiaobaoming);
        return R.ok();
    }

    /**
     * Change
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuxiaobaomingEntity quxiaobaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaobaoming);
        quxiaobaomingService.updateById(quxiaobaoming);//全部更新
        return R.ok();
    }
    

    /**
     * Delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quxiaobaomingService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QuxiaobaomingEntity> wrapper = new EntityWrapper<QuxiaobaomingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jumin")) {
			wrapper.eq("juminhao", (String)request.getSession().getAttribute("username"));
		}

		int count = quxiaobaomingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
