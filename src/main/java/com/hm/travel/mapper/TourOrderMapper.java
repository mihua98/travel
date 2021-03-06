package com.hm.travel.mapper;

import com.hm.travel.pojo.TourOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourOrderMapper {
// 实现对跟团游表订单的crud操作

    /**
     * 查询所有跟团游
     *
     * @return所有跟团游集合
     */
    List<TourOrder> findAll();

    /**
     * 添加TourOrder
     *
     * @param TourOrder
     * @return
     */
    //@Insert("INSERT INTO `tourorder`( `tour_Order_Num`, `tour_Order_Time`, `people_Count`, `tour_Order_Status`, `tour_Id`, `userInfo_Id`, `userInfo_Name`, `traveller_Id`,`traveller_Price`,`traveller_Oneprice`) VALUES " +
    //        "( #{tourOrderNum}, #{tourOrderTime}, #{peopleCount}, #{tourOrderStatus}, #{tour.tourId}, #{userInfoId}, #{userInfoName}, #{travellerId}, #{travellerPrice},#{travellerOnerice})")
    int addTourOrder(TourOrder TourOrder);

    /**
     * 修改TourOrder
     *
     * @param
     * @return
     */
    @Update("UPDATE `travel`.`tourorder` SET `tour_Order_Num` = #{tourOrderNum}, `tour_Order_Time` = #{tourOrderTime}, `people_Count` = #{peopleCount}, `tour_Order_Status` =#{tourOrderStatus},tour_Order_Price = #{tourOrderPrice}" +
            " WHERE `Id` = #{id}")
    int updateTourOrder(TourOrder tourOrder);

    /**
     * 按条件查询
     *
     * @param district
     * @return
     */
    @Select("select * from tourOrder where  like '%#{district}%'")
    List<TourOrder> findTourOrderByCondition(String district);

    /**
     * 通过id获得TourOrder
     *
     * @param id
     * @return
     */

    TourOrder selectTourOrderById(Integer id);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Delete("delete from tourOrder where id=#{id}")
    int deleteTourOrder(Integer id);
}
