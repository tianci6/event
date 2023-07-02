package com.controller;

import cn.hutool.core.date.DateUtil;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.MaterialEvaluateEntity;
import com.service.MaterialEvaluateService;
import com.service.MaterialService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 商品评价
 *
 * @author
 * @date 2023/6/7 13:19
 **/
@RestController
@RequestMapping("/materialEvaluate")
public class MaterialEvaluateController {
    @Autowired
    private MaterialEvaluateService materialEvaluateService;


    /**
     * 后端列表
     */
    @IgnoreAuth
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, MaterialEvaluateEntity materialEntity,
                  HttpServletRequest request) {
        /*String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("jumin")) {
            materialEntity.setJuminhao((String) request.getSession().getAttribute("username"));
        }*/
        EntityWrapper<MaterialEvaluateEntity> ew = new EntityWrapper<MaterialEvaluateEntity>();

        PageUtils page = materialEvaluateService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, materialEntity), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端查询
     * @method list
     * @param params:
     * @param materialEntity:
     * @param request:
     * @return com.utils.R
     * @date 2023/6/10 21:53
     **/
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, MaterialEvaluateEntity materialEntity,
                  HttpServletRequest request) {
        EntityWrapper<MaterialEvaluateEntity> ew = new EntityWrapper<MaterialEvaluateEntity>();

        PageUtils page = materialEvaluateService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, materialEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(MaterialEvaluateEntity materialEntity) {
        EntityWrapper<MaterialEvaluateEntity> ew = new EntityWrapper<MaterialEvaluateEntity>();
        // TODO
        ew.allEq(MPUtil.allEQMapPre(materialEntity, "huodongbaoming"));
        return R.ok().put("data", materialEvaluateService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MaterialEvaluateEntity materialEntity) {
        EntityWrapper<MaterialEvaluateEntity> ew = new EntityWrapper<MaterialEvaluateEntity>();
        // TODO
        ew.allEq(MPUtil.allEQMapPre(materialEntity, "huodongbaoming"));
        MaterialEvaluateEntity data = materialEvaluateService.selectView(ew);
        return R.ok("查询活动报名成功").put("data", data);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        MaterialEvaluateEntity materialEntity = materialEvaluateService.selectById(id);
        return R.ok().put("data", materialEntity);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        MaterialEvaluateEntity materialEntity = materialEvaluateService.selectById(id);
        return R.ok().put("data", materialEntity);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialEvaluateEntity materialEntity, HttpServletRequest request) {
        materialEvaluateService.insert(materialEntity);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody MaterialEvaluateEntity materialEntity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        String username = (String) request.getSession().getAttribute("username");
        materialEntity.setUserId(userId);
        materialEntity.setState("1");
        materialEntity.setCreateBy(username);
        materialEntity.setCreateTime(DateUtil.date());
        materialEntity.setUpdateBy(username);
        materialEntity.setUpdateTime(DateUtil.date());
        materialEvaluateService.insert(materialEntity);
        return R.ok();
    }

    /**
     * Change
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MaterialEvaluateEntity materialEntity, HttpServletRequest request) {
        // 全部更新
        materialEvaluateService.updateById(materialEntity);
        return R.ok();
    }


    /**
     * Delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        materialEvaluateService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 查询商品评论
     */
    @GetMapping("/getByMaterial/{id}")
    public R getByMaterial(@PathVariable Long id, HttpServletRequest request) {
        return R.ok().put("data", materialEvaluateService.getByMaterial(id));
    }



}
