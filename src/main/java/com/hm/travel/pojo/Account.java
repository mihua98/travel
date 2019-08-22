package com.hm.travel.pojo;

import lombok.Data;

@Data
public class Account {
    private Integer id;

    private String accountNumber;

    private String password;

    private String email;

    private UserInfo userInfo;

    public Account(Integer id, String accountNumber, String password, String email) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.password = password;
        this.email = email;
    }

    public Account(){

    }
    public Account(Integer id,String accountNumber,String password){
        this.id=id;
        this.accountNumber=accountNumber;
        this.password=password;
    }

}