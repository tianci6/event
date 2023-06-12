package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MaterialDao;
import com.dao.UserMaterialDao;
import com.entity.ForumEntity;
import com.entity.MaterialEntity;
import com.entity.UserMaterialEntity;
import com.service.MaterialService;
import com.service.UserMaterialService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.Query;
import com.utils.R;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品收藏
 */
@Service("userMaterialService")
public class UserMaterialServiceImpl extends ServiceImpl<UserMaterialDao, UserMaterialEntity> implements UserMaterialService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserMaterialEntity> page = this.selectPage(
                new Query<UserMaterialEntity>(params).getPage(),
                new EntityWrapper<UserMaterialEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<UserMaterialEntity> wrapper) {
        Page<UserMaterialEntity> page = new Query<UserMaterialEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<UserMaterialEntity> selectListVO(Wrapper<UserMaterialEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public UserMaterialEntity selectVO(Wrapper<UserMaterialEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<UserMaterialEntity> selectListView(Wrapper<UserMaterialEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public UserMaterialEntity selectView(Wrapper<UserMaterialEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


    /**
     * 查询我的收藏
     * @method selectMyCollect
     * @param userId:
     * @return java.util.List<com.entity.MaterialEntity>
     * @date 2023/6/12 11:14
     **/
    @Override
    public List<MaterialEntity> selectMyCollect(Long userId){
        return baseMapper.selectMyCollect(userId);
    }

    /**
     * 收藏/取消收藏
     * @method collectMaterial
     * @param userId:
     * @param materialId:
     * @param type:
     * @return int
     * @date 2023/6/12 11:24
     **/
    @Override
    public R collectMaterial(Long userId, Long materialId, String type){
        UserMaterialEntity userMaterial = baseMapper.selectByUserIdAndMaterialId(userId, materialId);
        if(type.equals("A")){
            if(null != userMaterial){
                return R.error("你已收藏此商品，请勿重复操作");
            }
            // 收藏
            UserMaterialEntity bean = new UserMaterialEntity();
            bean.setUserId(userId);
            bean.setMaterialId(materialId);
            insert(bean);
        }else{
            // 取消收藏
            if(null == userMaterial){
                return R.error("当前用户未收藏此商品");
            }
            EntityWrapper<UserMaterialEntity> ew = new EntityWrapper< UserMaterialEntity>();
            ew.eq("user_id", userId).eq("material_id",materialId);
            baseMapper.delete(ew);
        }
        return R.ok("操作成功");
    }

    /**
     * 根据用户ID + 商品ID查询
     * @param userId
     * @param materialId
     * @return
     */
    @Override
    public UserMaterialEntity selectByUserIdAndMaterialId(Long userId, Long materialId){
        return baseMapper.selectByUserIdAndMaterialId(userId, materialId);
    }


}
