package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.CallSOSEntity;
import com.entity.view.CallSOSView;
import com.entity.vo.CallSOSVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CallSOSService extends IService<CallSOSEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<CallSOSVO> selectListVO(Wrapper<CallSOSEntity> wrapper);

    CallSOSVO selectVO(@Param("ew") Wrapper<CallSOSEntity> wrapper);

    List<CallSOSView> selectListView(Wrapper<CallSOSEntity> wrapper);

    CallSOSView selectView(@Param("ew") Wrapper<CallSOSEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<CallSOSEntity> wrapper);
}
