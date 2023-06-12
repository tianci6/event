package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.MaterialEntity;
import com.entity.UserMaterialEntity;
import com.service.UserMaterialService;
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
import java.util.List;
import java.util.Map;

/**
 * 商品收藏
 *
 * @author
 * @date 2023/6/7 13:19
 **/
@RestController
@RequestMapping("/userMaterial")
public class UserMaterialController {
    @Autowired
    private UserMaterialService userMaterialService;


    /**
     * 后端列表
     */
    @IgnoreAuth
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, UserMaterialEntity materialEntity,
                  HttpServletRequest request) {
        /*String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("jumin")) {
            materialEntity.setJuminhao((String) request.getSession().getAttribute("username"));
        }*/
        EntityWrapper<UserMaterialEntity> ew = new EntityWrapper<UserMaterialEntity>();

        PageUtils page = userMaterialService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, materialEntity), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端查询
     *
     * @param params:
     * @param materialEntity:
     * @param request:
     * @return com.utils.R
     * @method list
     * @date 2023/6/10 21:53
     **/
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, UserMaterialEntity materialEntity,
                  HttpServletRequest request) {
        EntityWrapper<UserMaterialEntity> ew = new EntityWrapper<UserMaterialEntity>();

        PageUtils page = userMaterialService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, materialEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(UserMaterialEntity materialEntity) {
        EntityWrapper<UserMaterialEntity> ew = new EntityWrapper<UserMaterialEntity>();
        // TODO
        ew.allEq(MPUtil.allEQMapPre(materialEntity, "huodongbaoming"));
        return R.ok().put("data", userMaterialService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(UserMaterialEntity materialEntity) {
        EntityWrapper<UserMaterialEntity> ew = new EntityWrapper<UserMaterialEntity>();
        // TODO
        ew.allEq(MPUtil.allEQMapPre(materialEntity, "huodongbaoming"));
        UserMaterialEntity data = userMaterialService.selectView(ew);
        return R.ok("查询活动报名成功").put("data", data);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        UserMaterialEntity materialEntity = userMaterialService.selectById(id);
        return R.ok().put("data", materialEntity);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        UserMaterialEntity materialEntity = userMaterialService.selectById(id);
        return R.ok().put("data", materialEntity);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserMaterialEntity materialEntity, HttpServletRequest request) {
        userMaterialService.insert(materialEntity);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody UserMaterialEntity materialEntity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        materialEntity.setUserId(userId);
        userMaterialService.insert(materialEntity);
        return R.ok();
    }

    /**
     * Change
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody UserMaterialEntity materialEntity, HttpServletRequest request) {
        // 全部更新
        userMaterialService.updateById(materialEntity);
        return R.ok();
    }


    /**
     * Delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        userMaterialService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 我的收藏
     * @method list
     * @param request:
     * @return com.utils.R
     * @date 2023/6/10 21:53
     **/
    @RequestMapping("/selectMyCollect")
    public R selectMyCollect(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        List<MaterialEntity> list = userMaterialService.selectMyCollect(userId);

        return R.ok().put("data", list);
    }

    /**
     * 收藏/取消收藏
     * @method list
     * @param request:
     * @return com.utils.R
     * @date 2023/6/10 21:53
     **/
    @GetMapping("/collectMaterial")
    public R collectMaterial(@RequestParam("materialId") Long materialId,
                             @RequestParam("type") String type,
                             HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");

        return userMaterialService.collectMaterial(userId, materialId, type);
    }

    /**
     * 检查是否收藏
     * @method list
     * @param request:
     * @return com.utils.R
     * @date 2023/6/10 21:53
     **/
    @GetMapping("/checkCollect")
    public R checkCollect(@RequestParam("materialId") Long materialId,
                          HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");

        return R.ok().put("data", userMaterialService.selectByUserIdAndMaterialId(userId, materialId));
    }


}
