package com.hm.travel.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class TravelLog {
    private Integer id;
    //游记标题
    private String tlTitle;
    //游记摘要
    private String tlSummary;
    //发布日期
    private Date tlReleaseDate;
    //关键字
    private String tlKeyWord;
    //点击数
    private Integer tlClickCount;
    //点赞数
    private Integer tlLikeCount;
    //收藏数
    private Integer tlFavoriteCount;
    //发布游记用户
    private UserInfo userInfo;
    //状态
    private Integer tlStatus;
    //游记内容
    private String tlContent;
    //游记照片
    private String tlPhoto;

    private String tlBgPhoto;

    private String tlCityName;


    }