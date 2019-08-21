package com.hm.travel.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class TourOrder {
    private Integer id;

    private String tourOrderNum;

    private Date tourOrderTime;

    private Integer peopleCount;

    private Integer tourOrderStatus;

    private Integer tourId;

    private Integer userinfoId;

    private String userinfoName;

    private Traveller traveller;


}