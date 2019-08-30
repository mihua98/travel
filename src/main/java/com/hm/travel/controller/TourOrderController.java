package com.hm.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.TourOrder;
import com.hm.travel.service.TourOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Random;

@Controller
public class TourOrderController {
    @Autowired
    TourOrderService tourOrderService;

    /**
     * 根据时间+随机数生成订单号
     *
     * @return 订单号
     */
    public String getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }

    @PostMapping("topay")
    public String Tourtopay(TourOrder tourOrder, HttpServletRequest request) {
        System.out.println("tourOrde:   " + tourOrder);
        if (null == tourOrder.getTourOrderNum()) {
            tourOrder.setTourOrderNum(getOrderIdByTime());
        }
        if(tourOrderService.addTourOrder(tourOrder)>0){
            System.out.println("生成订单成功!");
        }else{
            System.out.println("生成订单失败!");
        }
        request.getSession().setAttribute("TourOrder", tourOrder);
        return "redirect:/alipay/pay";

    }


    /**
     * 更新
     * @param id
     * @param m
     * @return
     */
//    @RequestMapping("updateTourOrderpage")
//    public String updateTourOrderpage(Integer id,Model m){
//        TourOrder tourOrder = tourOrderService.selectTourOrderById(id);
//        m.addAttribute("tourOrder",tourOrder);
//        return "adminPage/updateTourOrder";
//    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteTourOrder")
    public String deleteTourOrder(Integer id) {
        tourOrderService.deleteTourOrder(id);
        return "redirect:TourOrderPage";
    }

    /**
     * 添加
     *
     * @param tourOrder
     * @return
     */

    @RequestMapping("insetTourOrderpage")
    public String insetTourpage(TourOrder tourOrder) {
        tourOrderService.addTourOrder(tourOrder);
        return "redirect:TourOrderPage";

    }

    /**
     * 后台分页
     *
     * @param start
     * @param size
     * @return
     */
    @GetMapping("/TourOrderListPage")
    @ResponseBody
    public PageInfo<TourOrder> TourOrderListPage(
            @RequestParam(value = "start", defaultValue = "1") int start,
            @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size);
        List<TourOrder> list = tourOrderService.findAll();
        // 将查询的数据以分页的形式展示
        PageInfo<TourOrder> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 后台更新 通过id获得tourOrder
     *
     * @param id
     * @return
     */
    @RequestMapping("/updateTourOrderById")
    @ResponseBody
    public void updateTourOrderById(@RequestBody TourOrder tourOrder) {
        System.out.println(tourOrder);
        tourOrderService.updateTourOrder(tourOrder);
    }

    /**
     * @param tourOrder
     * @return
     */

    @RequestMapping("/updateTourOrderpage")
    @ResponseBody
    public String updateTourOrderpage(@RequestBody TourOrder tourOrder) {
        System.out.println("状态--------" + tourOrder.getTourOrderStatus());
        int i = tourOrderService.updateTourOrder(tourOrder);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("/selectTourOrderById")
    @ResponseBody
    public TourOrder selectTourOrderById(Integer id) {
        return tourOrderService.selectTourOrderById(id);
    }


}
