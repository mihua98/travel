package com.hm.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.TravelLog;
import com.hm.travel.pojo.UserInfo;
import com.hm.travel.service.TravelLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author jlz
 * @date 2019/8/24 13:57
 */
@Controller
@RequestMapping("/travelLog")
public class TravelLogController {
    //面向用户:新增游记,点击,点赞,收藏,查询所有游记,根据标题模糊查询,根据ID查询(即查看该游记)
    //面向管理员:更改游记状态,查询所有游记,删除游记,根据标题模糊查询,根据ID查询

    @Autowired
    private TravelLogService travelLogService;



    /**
     * 游记推荐调用,查询点击量前三的游记
     * @return 游记集合
     */
    @RequestMapping("/HotTravelLog")
    @ResponseBody
    public  List<TravelLog> getHotTravelLog(){
        List<TravelLog> list = travelLogService.getHotTravelLog();
        return list;
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping("/selectTravelLogById")
    @ResponseBody
    public TravelLog selectTravelLogById(@RequestParam("id") Integer id){
        TravelLog travelLog = travelLogService.selectTravellogById(id);
        return travelLog;
    }


    /**
     * 首页展示,查询4条数据
     *
     * @return 游记集合
     */
    @RequestMapping("/indexTravelLog")
    @ResponseBody
    public List<TravelLog> getIndexTravelLog() {
        List<TravelLog> list = travelLogService.getIndexTravelLog();
        return list;
    }

    /**
     * 得到总用户数量
     *
     * @return
     */
    @RequestMapping("/getTravelLogNum")
    @ResponseBody
    public int getTravelLogNum() {
        int travelLogNum = travelLogService.getTravelLogNum();
        return travelLogNum;
    }


    /**
     * 更改游记状态  0可读  1 不可读
     * @param travelLog 游记
     * @return
     */
    @RequestMapping("/updateTravelLog")
    @ResponseBody
    public String updateTravelLog(@RequestBody TravelLog travelLog){
        Integer id = travelLog.getId();
        Integer tlStatus = travelLog.getTlStatus();
        int i = travelLogService.updateTravellogStatus(travelLog);
        if(i>0){
            return "更改状态成功";
        }
        return "更改状态失败";
    }

    /**
     * 根据ID删除游记
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteTravelLog")
    @ResponseBody
    public String deleteTravelLog(@RequestParam("id") Integer id) {
        int i = travelLogService.deleteTravellogById(id);
        if (i > 0) {
            return "删除成功";
        }
        return "删除失败";
    }


    /**
     * 根据标题模糊查询游记
     *
     * @param search
     * @return 游记集合
     */
    @RequestMapping("/selectTravelLogLikeTitle")
    @ResponseBody
    public PageInfo<TravelLog> selectTravelLogLikeTitle(@RequestParam(value = "start", defaultValue = "1") int start,
                                                        @RequestParam(value = "size", defaultValue = "4") int size,
                                                        @RequestParam("search") String search) {
        PageHelper.startPage(start, size);
        List<TravelLog> list = travelLogService.selectTravelLogLikeTitle(search);
        PageInfo<TravelLog> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 查询所有游记(包括不可读)   管理员调用!!!!!!!!
     * @return travelLogs 游记集合
     */
    @RequestMapping("/getAnyTravelLog")
    @ResponseBody
    public PageInfo<TravelLog> getAnyTravelLog(@RequestParam(value = "start", defaultValue = "0") int start,
                                               @RequestParam(value = "size", defaultValue = "3") int size){
        PageHelper.startPage(start, size);
        List<TravelLog> list = travelLogService.getAnyTravelLog();
        PageInfo<TravelLog> page = new PageInfo<>(list);
        return page;
    }



    /**
     * 查询所有可读游记   用户调用!!!!!!!!
     * @return travelLogs 游记集合
     */
    @RequestMapping("/getAllTravelLog")
    @ResponseBody
    public PageInfo<TravelLog> getAllTravelLog(@RequestParam(value = "start", defaultValue = "1") int start,
                                               @RequestParam(value = "size", defaultValue = "4") int size) {
        PageHelper.startPage(start, size);
        List<TravelLog> list = travelLogService.getAllTravelLog();
        PageInfo<TravelLog> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 用户对游记收藏
     *
     * @param id 被收藏的游记ID
     * @return
     */
    @RequestMapping("/lowerFavoriteCountNum")
    @ResponseBody
    public String lowerFavoriteCountNum(@RequestParam("id") Integer id) {
        int i = travelLogService.lowerFavoriteCountNum(id);
        if (i > 0) {
            return "取消收藏成功";
        }
        return "取消收藏失败";
    }

    /**
     * 用户对游记收藏
     *
     * @param id 被收藏的游记ID
     * @return
     */
    @RequestMapping("/addFavoriteCountNum")
    @ResponseBody
    public String addFavoriteCountNum(@RequestParam("id") Integer id) {
        int i = travelLogService.addFavoriteCountNum(id);
        if (i > 0) {
            return "收藏成功";
        }
        return "收藏失败";
    }

    /**
     * 用户查看游记,该游记点击量+1,转发至游记详情页
     *
     * @param id  游记id
     * @param model 将查询到的游记存于model中
     * @return 游记详情页
     */
    @RequestMapping("/selectTravellogById")
    public String selectTravellogById(Integer id, Model model) {
        travelLogService.clickCount(id);
        TravelLog travelLog = travelLogService.selectTravellogById(id);
        model.addAttribute("travelLog", travelLog);
        return "userPage/travel-log-detail";
    }


    /**
     * 用户对游记取消赞
     *
     * @param id 被取消赞的游记ID
     * @return
     */
    @RequestMapping("/lowerLikeCountNum")
    @ResponseBody
    public String lowerLikeCountNum(@RequestParam("id") Integer id) {
        int i = travelLogService.lowerLikeCountNum(id);
        if (i > 0) {
            return "取消赞成功";
        }
        return "取消赞失败";
    }

    /**
     * 用户对游记点赞
     *
     * @param id 被点赞的游记ID
     * @return
     */
    @RequestMapping("/addLikeCountNum")
    @ResponseBody
    public String addLikeCountNum(@RequestParam("id") Integer id) {
        int i = travelLogService.addLikeCountNum(id);
        if (i > 0) {
            return "点赞成功";
        }
        return "点赞失败";
    }


    /**
     * 用户提交游记,不需要用户写发布时间和ID
     *
     * @param travelLog
     * @return
     */
    @RequestMapping("/addTravelLog")
    public String addTravelLog(TravelLog travelLog) {
        System.out.println(travelLog);
        int i = travelLogService.addTravelLog(travelLog);
        if (i > 0) {
            // TODO: 2019/8/24  转发至游记列表页
            return "userPage/travel-log";
        }
        return "添加失败";
    }
}
