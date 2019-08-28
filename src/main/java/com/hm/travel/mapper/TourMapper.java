package com.hm.travel.mapper;

import com.hm.travel.pojo.Tour;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourMapper {
    // 实现对跟团游表的crud操作

    /**
     * 查询所有跟团游
     * @return所有跟团游集合
     */
    @Select ("select * from tour")
    List<Tour> findAll();

    /**
     * 添加tour
     * @param tour
     * @return
     */
    @Insert("INSERT INTO `tour`( `tour_Num`, `tour_Name`, `city_Name`, `departure_Time`, `tour_Price`, `tour_Desc`, `tour_Status`, `tour_Photo`) VALUES " +
            "( #{tourNum}, #{tourName}, #{cityName}, #{departureTime}, #{tourPrice}, #{tourDesc}, #{tourStatus}, #{tourPhoto})")
    int addTour(Tour tour);

    /**
     * 修改tour
     * @param id
     * @return
     */
    @Update("UPDATE `travel`.`tour` SET `tour_Num` = #{tourNum}, `tour_Name` = #{tourName}, `city_Name` = #{cityName}," +
            " `departure_Time` = #{departureTime}, `tour_Price` = #{tourPrice}, `tour_Desc` = #{tourDesc}, `tour_Status` = #{tourStatus}, `tour_Photo` = #{tourPhoto} " +
            "WHERE `id` = #{id}")
    int updateTour(Integer id);

    /**
     * 按条件查询
     * @param district
     * @return
     */
    @Select("select * from tour where tour_Name like '%#{district}%'")
    List<Tour> findTourByCondition(String district);

    /**
     *通过id获得Tour
     * @param id
     * @return
     */
    @Select("select * from tour where id =#{id}")
    Tour selectTourById(Integer id);
    /**
     * 通过tourHead获得Tour
     * @param
     * @return 前6
     */
    @Select("select * from (SELECT *from tour order by tour_Head desc) t LIMIT 6")
    Tour selectTourByHead();
    /**
     * 通过tourHead获得Tour
     * @param
     * @return 前1
     */
    @Select("select * from (SELECT *from tour order by tour_Head desc) t LIMIT 1")
    Tour selectTourByHeadOne();
    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from tour where id=#{id}")
    int deleteTour(Integer id);
}

