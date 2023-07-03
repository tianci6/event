package com.controller;//package com.controller;
//
//import com.annotation.IgnoreAuth;
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.entity.CallSOSEntity;
//import com.entity.view.CallSOSView;
//import com.service.CallSOSService;
//import com.utils.MPUtil;
//import com.utils.PageUtils;
//import com.utils.R;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Map;
//
//
///**
// * 提交sos
// * 后端接口
// *
// *
// */
//@RestController
//@RequestMapping("/CallSOS")
//public class CallSOSController {
//    @Autowired
//    private CallSOSService callSOSService;
//
//    /**
//     * 后端列表
//     *
//     */
//    @RequestMapping("/page")
//    public R page(@RequestParam Map<String, Object> params, CallSOSEntity callSOS,
//                  HttpServletRequest request){
//        String tableName = request.getSession().getAttribute("tableName").toString();
//        if(tableName.equals("sos")) {
//            callSOS.setUserID((long)request.getSession().getAttribute("CurrentLocation"));
//        }
//        EntityWrapper<CallSOSEntity> ew = new EntityWrapper<CallSOSEntity>();
//
//        PageUtils page = callSOSService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, callSOS), params), params));
//
//        return R.ok().put("data", page);
//    }
//
//    /**
//     * 前端列表
//     *
//     */
//    @IgnoreAuth
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params,CallSOSEntity callSOS,
//                  HttpServletRequest request){
//        EntityWrapper<CallSOSEntity> ew = new EntityWrapper<CallSOSEntity>();
//
//        PageUtils page = callSOSService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, callSOS), params), params));
//        return R.ok().put("data", page);
//    }
//
//    /**
//     * 列表
//     *
//     */
//    @RequestMapping("/lists")
//    public R list( CallSOSEntity callSOS){
//        EntityWrapper<CallSOSEntity> ew = new EntityWrapper<CallSOSEntity>();
//        ew.allEq(MPUtil.allEQMapPre( callSOS, "callSOS"));
//        return R.ok().put("data", callSOSService.selectListView(ew));
//    }
//
//    /**
//     * 查询
//     */
//    @RequestMapping("/query")
//    public R query(CallSOSEntity callSOS){
//        EntityWrapper< CallSOSEntity> ew = new EntityWrapper< CallSOSEntity>();
//        ew.allEq(MPUtil.allEQMapPre( callSOS, "callSOS"));
//        CallSOSView callSOSView =  callSOSService.selectView(ew);
//        return R.ok("查询上传sos成功").put("data", callSOSView);
//    }
//
//    /**
//     * 后端详情
//     */
//    @RequestMapping("/info/{id}")
//    public R info(@PathVariable("id") Long id){
//        CallSOSEntity callSOS = callSOSService.selectById(id);
//        return R.ok().put("data", callSOS);
//    }
//
//    /**
//     * 前端详情
//     */
//    @IgnoreAuth
//    @RequestMapping("/detail/{id}")
//    public R detail(@PathVariable("id") Long id){
//        CallSOSEntity callSOS = callSOSService.selectById(id);
//        return R.ok().put("data", callSOS);
//    }
//
//    /**
//     * 后端保存
//     *///这里这里这里
//    @RequestMapping("/save")
//    public R save(@RequestBody CallSOSEntity callSOS, HttpServletRequest request){
//        callSOS.setUserID(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(callSOS);
//        callSOSService.insert(callSOS);
//        return R.ok();
//    }
//
//    /**
//     * 前端保存
//     *///这里这里这里
//    @RequestMapping("/add")
//    public R add(@RequestBody CallSOSEntity callSOS, HttpServletRequest request){
//        callSOS.setUserID(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(callSOS);
//        callSOSService.insert(callSOS);
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @Transactional
//    public R update(@RequestBody CallSOSEntity callSOS, HttpServletRequest request){
//        //ValidatorUtils.validateEntity(callSOS);
//        callSOSService.updateById(callSOS);//全部更新
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Long[] ids){
//        callSOSService.deleteBatchIds(Arrays.asList(ids));
//        return R.ok();
//    }
//
//    /**
//     * 提醒接口
//     */
//    @RequestMapping("/remind/{columnName}/{type}")
//    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
//                         @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
//        map.put("column", columnName);
//        map.put("type", type);
//
//        if(type.equals("2")) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar c = Calendar.getInstance();
//            Date remindStartDate = null;
//            Date remindEndDate = null;
//            if(map.get("remindstart")!=null) {
//                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
//                c.setTime(new Date());
//                c.add(Calendar.DAY_OF_MONTH,remindStart);
//                remindStartDate = c.getTime();
//                map.put("remindstart", sdf.format(remindStartDate));
//            }
//            if(map.get("remindend")!=null) {
//                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
//                c.setTime(new Date());
//                c.add(Calendar.DAY_OF_MONTH,remindEnd);
//                remindEndDate = c.getTime();
//                map.put("remindend", sdf.format(remindEndDate));
//            }
//        }
//
//        Wrapper<CallSOSEntity> wrapper = new EntityWrapper<CallSOSEntity>();
//        if(map.get("remindstart")!=null) {
//            wrapper.ge(columnName, map.get("remindstart"));
//        }
//        if(map.get("remindend")!=null) {
//            wrapper.le(columnName, map.get("remindend"));
//        }
//
//        String tableName = request.getSession().getAttribute("tableName").toString();
//        if(tableName.equals("sos")) {
//            wrapper.eq("UserID", (String)request.getSession().getAttribute("CurrentLocation"));
//        }
//
//        int count = callSOSService.selectCount(wrapper);
//        return R.ok().put("count", count);
//    }
//}
