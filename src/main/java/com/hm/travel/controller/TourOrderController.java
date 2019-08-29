package com.hm.travel.controller;

import com.hm.travel.pojo.TourOrder;
import com.hm.travel.service.TourOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
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




}
