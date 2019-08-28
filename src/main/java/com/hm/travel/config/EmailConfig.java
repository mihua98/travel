package com.hm.travel.config;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author jlz
 * @date 2019/8/27 11:52
 */
public class EmailConfig {
    private static final String SMPT_POST="smtp.qq.com";
    private static final String USER_NAME="171113323@qq.com";
    private static final String PASS_WORD="tpdrjbbjahihcafc";


    public static void sendEmail(String toEmail,String subject,String content){
        SimpleEmail email = new SimpleEmail();
        System.out.println("222222");
        try {
            email.setHostName(SMPT_POST);
            email.setAuthentication(USER_NAME,PASS_WORD);
//            email.setSmtpPort(465);
            email.setFrom(USER_NAME);
            email.addTo(toEmail);
            email.setSubject(subject);
            email.setMsg(content);
            System.out.println("333");
            System.out.println(email.send());
            System.out.println("444");
        } catch (EmailException e) {
            System.out.println("555");
            e.printStackTrace();
        }
    }
}
