package com.service.impl;//package com.service.impl;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
//import com.dao.CallSOSDao;
//import com.entity.CallSOSEntity;
//import com.entity.view.CallSOSView;
//import com.entity.vo.CallSOSVO;
//import com.service.CallSOSService;
//import com.utils.PageUtils;
//import com.utils.Query;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service("callSOSService")
//public class CallSOSServiceImpl extends ServiceImpl<CallSOSDao, CallSOSEntity> implements CallSOSService {
//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        Page<CallSOSEntity> page = this.selectPage(
//                new Query<CallSOSEntity>(params).getPage(),
//                new EntityWrapper<CallSOSEntity>()
//        );
//        return new PageUtils(page);
//    }
//
//    @Override
//    public List<CallSOSVO> selectListVO(Wrapper<CallSOSEntity> wrapper) {
//        return baseMapper.selectListVO(wrapper);
//    }
//
//    @Override
//    public CallSOSVO selectVO(Wrapper<CallSOSEntity> wrapper) {
//        return baseMapper.selectVO(wrapper);
//    }
//
//    @Override
//    public List<CallSOSView> selectListView(Wrapper<CallSOSEntity> wrapper) {
//        return baseMapper.selectListView(wrapper);
//    }
//
//    @Override
//    public CallSOSView selectView(Wrapper<CallSOSEntity> wrapper) {
//        return baseMapper.selectView(wrapper);
//    }
//
//    @Override
//    public PageUtils queryPage(Map<String, Object> params, Wrapper<CallSOSEntity> wrapper) {
//        Page<CallSOSView> page =new Query<CallSOSView>(params).getPage();
//        page.setRecords(baseMapper.selectListView(page,wrapper));
//        PageUtils pageUtil = new PageUtils(page);
//        return pageUtil;
//    }
//}
