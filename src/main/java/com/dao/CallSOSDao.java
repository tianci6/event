package com.dao;//package com.dao;
//
//import com.baomidou.mybatisplus.mapper.BaseMapper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.baomidou.mybatisplus.plugins.pagination.Pagination;
//import com.entity.SOSEntity;
//import com.entity.view.SOSView;
//import com.entity.vo.SOSVO;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//
//public interface SOSDao extends BaseMapper<SOSEntity> {
//
//    List<SOSVO> selectListVO(@Param("ew") Wrapper<SOSEntity> wrapper);
//
//    SOSVO selectVO(@Param("ew") Wrapper<SOSEntity> wrapper);
//
//    List<SOSView> selectListView(@Param("ew") Wrapper<SOSEntity> wrapper);
//
//    List<SOSView> selectListView(Pagination page, @Param("ew") Wrapper<SOSEntity> wrapper);
//
//    SOSView selectView(@Param("ew") Wrapper<SOSEntity> wrapper);
//}
