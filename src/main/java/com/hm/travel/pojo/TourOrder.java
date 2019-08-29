package com.hm.travel.pojo;
/**
 * `Id` int(11) NOT NULL AUTO_INCREMENT,
 *   `tour_Order_Num` timestamp NULL DEFAULT NULL COMMENT '	订单编号',
 *   `tour_Order_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
 *   `people_Count` int(11) DEFAULT NULL COMMENT '出行人数',
 *   `tour_Order_Status` int(11) DEFAULT NULL COMMENT '	订单状态(0未支付 1已支付)',
 *   `tour_Id` int(11) DEFAULT NULL COMMENT '	跟团游商品表ID(外键)',
 *   `userInfo_Id` int(11) DEFAULT NULL COMMENT '下单用户ID(外键)',
 *   `userInfo_Name` varchar(10) DEFAULT NULL COMMENT '下单用户姓名',
 *   `traveller_Id` int(11) DEFAULT NULL COMMENT '旅客信息表Id',
 *   travellerOneprice 单价
 *   travellerprice 总金额
 */

import lombok.Data;

import java.util.Date;
@Data
public class TourOrder {
    private Integer id;

    private String tourOrderNum;

    private String tourOrderTime;

    private Integer peopleCount;

    private Integer tourOrderStatus;

    private Tour tour;

    private UserInfo userInfo;

    private Traveller traveller;

    private double travellerPrice;
    /**
     * 产品单价
     */
    private double travellerOneprice;
}