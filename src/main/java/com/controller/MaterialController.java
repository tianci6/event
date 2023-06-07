package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.MaterialEntity;
import com.service.MaterialService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 商品
 *
 * @author
 * @date 2023/6/7 13:19
 **/
@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, MaterialEntity materialEntity,
                  HttpServletRequest request) {
        /*String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("jumin")) {
            materialEntity.setJuminhao((String) request.getSession().getAttribute("username"));
        }*/
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<MaterialEntity>();

        PageUtils page = materialService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, materialEntity), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, MaterialEntity materialEntity,
                  HttpServletRequest request) {
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<MaterialEntity>();

        PageUtils page = materialService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, materialEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(MaterialEntity materialEntity) {
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<MaterialEntity>();
        // TODO
        ew.allEq(MPUtil.allEQMapPre(materialEntity, "huodongbaoming"));
        return R.ok().put("data", materialService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MaterialEntity materialEntity) {
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<MaterialEntity>();
        // TODO
        ew.allEq(MPUtil.allEQMapPre(materialEntity, "huodongbaoming"));
        MaterialEntity data = materialService.selectView(ew);
        return R.ok("查询活动报名成功").put("data", data);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        MaterialEntity materialEntity = materialService.selectById(id);
        return R.ok().put("data", materialEntity);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        MaterialEntity materialEntity = materialService.selectById(id);
        return R.ok().put("data", materialEntity);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialEntity materialEntity, HttpServletRequest request) {
        materialService.insert(materialEntity);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MaterialEntity materialEntity, HttpServletRequest request) {
        materialService.insert(materialEntity);
        return R.ok();
    }

    /**
     * Change
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MaterialEntity materialEntity, HttpServletRequest request) {
        // 全部更新
        materialService.updateById(materialEntity);
        return R.ok();
    }


    /**
     * Delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        materialService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}
