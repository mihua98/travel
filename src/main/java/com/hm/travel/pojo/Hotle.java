package com.hm.travel.pojo;

import lombok.Data;

@Data
public class Hotle {
    private Integer id;

    private String hotleName;

    private String hotlePhoto;

    private Double hotleGrade;

    private String hotleStart;

    private String hotleInfo;

    private City city;

    private HotleRoom hotleRoom;

    }