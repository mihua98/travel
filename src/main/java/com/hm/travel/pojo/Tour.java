package com.hm.travel.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Tour {
    private Integer id;

    private String tourNum;

    private String tourName;

    private String cityName;

    private Date departureTime;

    private Double tourPrice;

    private String tourDesc;

    private Integer tourStatus;

    private String tourPhoto;

    private int tourHead;


   }