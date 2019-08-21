package com.hm.travel.pojo;

import lombok.Data;

@Data
public class HotleOrder {
    private Integer id;

    private Hotle hotle;

    private UserInfo userInfo;



    private String hoCheckTime;

    private String hoLeaveTime;

    private String hoOrderNum;

    }