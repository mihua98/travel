package com.hm.travel.pojo;

import lombok.Data;

@Data
public class Account {
    private Integer id;

    private String accountNumber;

    private String password;

    private UserInfo userInfo;


}