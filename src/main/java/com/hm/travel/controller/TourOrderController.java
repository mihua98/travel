package com.hm.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.TourOrder;
import com.hm.travel.service.TourOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @return 订单号
     */
    public  String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }

    @PostMapping("topay")
    public String Tourtopay(TourOrder tourOrder, HttpServletRequest request){
        System.out.println("tourOrde:   "+ tourOrder);
            if(null == tourOrder.getTourOrderNum()) {
                tourOrder.setTourOrderNum(getOrderIdByTime()) ;
            }
           request.getSession().setAttribute("TourOrder",tourOrder);
            return "redirect:/alipay/pay";

    }

    /**
     * 后台分页
     * @param m
     * @param start
     * @param size
     * @returnTourOrderPage
     */
    @GetMapping("/TourOrderPage")
    public String  TourListPage(Model m,
                                @RequestParam(value = "start",defaultValue = "0")int start,
                                @RequestParam(value = "size",defaultValue = "5")int size) {
        List<TourOrder> list = tourOrderService.findAll();
        // 将查询的数据以分页的形式展示
        PageHelper.startPage(start, size, "id desc");
        PageInfo<TourOrder> page = new PageInfo<>(list);
        m.addAttribute("page", page);
        return "TourOrderPage";
    }

    /**
     * 更新
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("updateTourOrderpage")
    public String updateTourOrderpage(Integer id,Model m){
        TourOrder tourOrder = tourOrderService.selectTourOrderById(id);
        m.addAttribute("tourOrder",tourOrder);
        return "adminPage/updateTourOrder";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deleteTourOrder")
    public String deleteTourOrder(Integer id){
        tourOrderService.deleteTourOrder(id);
        return "redirect:TourOrderPage";
    }
    /**
     * 添加
     * @param tourOrder
     * @return
     */

    @RequestMapping("insetTourOrderpage")
    public String insetTourpage(TourOrder tourOrder) {
        tourOrderService.addTourOrder(tourOrder);
        return "redirect:TourOrderPage";

    }

}
