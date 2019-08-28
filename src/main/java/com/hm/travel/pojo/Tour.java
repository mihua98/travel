package com.hm.travel.pojo;
/**
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `tour_Num` varchar(50) DEFAULT NULL COMMENT ' 产品编号 ',
 *   `tour_Name` varchar(50) DEFAULT NULL COMMENT '	产品名称(路线名称)',
 *   `city_Name` varchar(50) DEFAULT NULL COMMENT '	出发城市',
 *   `departure_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '	出发时间 ',
 *   `tour_Price` double(5,2) DEFAULT NULL COMMENT '产品价格 ',
 *   `tour_Desc` varchar(500) DEFAULT NULL COMMENT '	产品描述',
 *   `tour_Status` int(11) DEFAULT NULL COMMENT '状态 (0关闭 1开启)',
 *   `tour_Photo` varchar(100) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 */

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
    /**
     * 浏览量
     */
    private int tourHead;


   }