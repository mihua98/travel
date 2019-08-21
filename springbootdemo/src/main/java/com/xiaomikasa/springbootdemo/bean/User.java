package com.xiaomikasa.springbootdemo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 陈敏华
 * @date: 2019/8/15
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;

}
