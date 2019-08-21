package com.hm.travel.pojo;

import lombok.Data;

@Data
public class Admin {
    private Integer id;

    private String accountNumber;

    private String password;

    private AdminInfo adminInfo;


}