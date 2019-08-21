package com.hm.travel.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class TravelLog {
    private Integer id;

    private String tlTitle;

    private String tlSummary;

    private Date tlReleaseDate;

    private String tlKeyWord;

    private Integer tlClickCount;

    private Integer tlLikeCount;

    private Integer tlFavoriteCount;

    private Integer userinfoId;

    private Integer tlStatus;

    private String tlContent;

    }