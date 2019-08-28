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

    private Tour tour;

    private UserInfo userInfo;

    private Traveller traveller;

    private int travellerPrice;
}