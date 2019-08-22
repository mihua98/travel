package com.hm.travel.pojo;

import lombok.Data;

@Data
public class Admin {
    private Integer id;

    private String accountNumber;

    private String password;


    public Admin() {
    }

    public Admin(Integer id, String accountNumber, String password) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.password = password;
    }
}