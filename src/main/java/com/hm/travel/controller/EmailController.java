package com.hm.travel.controller;


import com.hm.travel.config.EmailConfig;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author jlz
 * @date 2019/8/26 21:07
 */
@Controller
public class EmailController {


    /**
     * 向用户邮箱发送验证码
     * @param email 用户邮箱
     * @param request 设置Session
     * @return  无关的返回项
     */
    @RequestMapping("/getVerCode")
    @ResponseBody
    public String sendEmail1(@RequestParam("email") String email, HttpServletRequest request){
        System.out.println("11111111111111111111111");
        String substring = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        System.out.println(substring);
        request.getSession().setAttribute("VerCode",substring);
       EmailConfig.sendEmail(email,"您的验证码为",substring);
        return "1";
    }


    /**
     * 验证用户输入的验证码是否正确
     * @param verCode 用户输入的验证码
     * @param request 得到session
     * @return
     */
    @RequestMapping("/verifyVerCode")
    @ResponseBody
    public String VerifyEmail(@RequestParam("verCode") String verCode,HttpServletRequest request){
        String verCode1 = (String)request.getSession().getAttribute("VerCode");
        String s = verCode1.toUpperCase();
        if (s.equals(verCode)){
            return "验证码正确";
        }else{
            return "验证码错误";
        }
    }

}
