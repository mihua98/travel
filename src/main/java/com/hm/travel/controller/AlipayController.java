package com.hm.travel.controller;

import com.hm.travel.config.AlipayConfig;
import com.alipay.api.*;
import com.alipay.api.request.*;
import com.hm.travel.pojo.TourOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author jlz
 * @date 2019/8/24 19:59
 */
@Controller
@RequestMapping("/alipay")
public class AlipayController {


    /**
     * 查询订单
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public String AlipayQuery(@RequestParam("OrderNum") String orderNum,
                              @RequestParam("AlipayNum") String alipayNum ) throws UnsupportedEncodingException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = new String(orderNum.getBytes("ISO-8859-1"),"UTF-8");
        //支付宝交易号
        String trade_no = new String(alipayNum.getBytes("ISO-8859-1"),"UTF-8");
        //请二选一设置

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","+"\"trade_no\":\""+ trade_no +"\"}");

        //请求
        String result = null;
        try {
            result = alipayClient.execute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //输出
       return result;
    }


    /**
     * 支付,付款
     * @param
     * @return 付款页面
     * @throws IOException
     */
    @RequestMapping("/pay")
    @ResponseBody
    public String Alipay(HttpServletRequest request)throws IOException{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        TourOrder tourOrder = (TourOrder)request.getSession().getAttribute("TourOrder");
        System.out.println("alipay  tourOrder :"+ tourOrder);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(tourOrder.getTourOrderNum().getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        // TODO: 2019/8/24 付款金额不能写死
        String total_amount = new String((tourOrder.getTravellerPrice()+"").getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String(tourOrder.getTour().getTourName().getBytes("ISO-8859-1"),"UTF-8");
        //商品描述，可空

        String body = new String("aa".getBytes("ISO-8859-1"),"UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //输出
        return result;
    }
}
