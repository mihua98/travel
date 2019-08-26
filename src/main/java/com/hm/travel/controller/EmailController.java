package com.hm.travel.controller;


import org.apache.commons.mail.EmailException;
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
    private static final String SMPT_POST="smtp.qq.com";
    private static final String USER_NAME="171113323@qq.com";
    private static final String PASS_WORD="981021lz";


    public static void sendEmail(String fromEmail,String toEmail,String subject,String content){
        SimpleEmail email = new SimpleEmail();
        try {
            email.setHostName(SMPT_POST);
            email.setAuthentication(USER_NAME,PASS_WORD);
            email.setFrom(fromEmail);
            email.addTo(toEmail);
            email.setSubject(subject);
            email.setMsg(content);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向用户邮箱发送验证码
     * @param email 用户邮箱
     * @param request 设置Session
     * @return  无关的返回项
     */
    @RequestMapping("/getVerCode")
    @ResponseBody
    public String sendEmail1(@RequestParam("email") String email, HttpServletRequest request){

        String substring = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        System.out.println(substring);
        request.getSession().setAttribute("VerCode",substring);
        sendEmail(USER_NAME,email,"您的验证码为",substring);
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
