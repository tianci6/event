package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AnnoucementEntity;
import com.service.AnnouncementService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/annoucement")
public class AnnoucementController {

    @Autowired
    private AnnouncementService announcementService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, AnnoucementEntity annoucement,
                  HttpServletRequest request){
        EntityWrapper<AnnoucementEntity> ew = new EntityWrapper<AnnoucementEntity>();

        PageUtils page = announcementService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, annoucement), params), params));

        return R.ok().put("data", page);
    }

    /**
     * Delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        announcementService.deleteBatchIdList(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AnnoucementEntity annoucement = announcementService.queryById(id);
        return R.ok().put("data", annoucement);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AnnoucementEntity annoucement, HttpServletRequest request){
        annoucement.setAnnoucementid(new Date().getTime()/1000);
        annoucement.setAnnouncementdate(new Date());
        announcementService.insertItem(annoucement);
        return R.ok();
    }


    /**
     * Change
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AnnoucementEntity annoucement, HttpServletRequest request){
        announcementService.updateItem(annoucement);//全部更新
        return R.ok();
    }

    @RequestMapping("/queryList")
    public R queryList(){
        return R.ok().put("data", announcementService.queryList());
    }
}
