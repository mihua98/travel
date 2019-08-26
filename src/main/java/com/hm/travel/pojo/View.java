package com.hm.travel.pojo;

import lombok.Data;

@Data
public class View {
    private Integer id;

    private String viewName;

    private String viewIntroduce;

    private String viewImage;

    private int viewClickCount;

    private City city;

    private Integer cityId;




}