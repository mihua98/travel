package com.hm.travel.pojo;

import lombok.Data;

@Data
public class Account {
    private Integer id;

    private String accountNumber;

    private String password;

    private UserInfo userInfo;

    public Account(){

    }
    public Account(Integer id,String accountNumber,String password){
        this.id=id;
        this.accountNumber=accountNumber;
        this.password=password;
    }

}