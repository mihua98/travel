package com.hm.travel.mapper;

import com.hm.travel.pojo.TravelLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author jlz
 * @date 2019/8/23 21:59
 */
@Repository
public interface TravelLogMapper {
    //面向用户:新增游记,点击,点赞,收藏,查询所有游记,根据标题模糊查询
    //面向管理员:更改游记状态,查询所有游记,删除游记,根据标题模糊查询


    /**
     * 根据ID查询游记,即用户查看该游记详情
     * @param id
     * @return
     */
    TravelLog selectTravellogById(Integer id);


    /**
     * 管理员更新游记状态
     * @param id
     * @param tlStatus
     * @return
     */
    @Update("update travellog set tl_Status = #{tlStatus} where id = #{id}")
    int updateTravellogStatus(Integer id,Integer tlStatus);


    /**
     * 根据ID删除游记
     * @param id
     * @return
     */
    @Delete("delete from travellog where id = #{id}")
    int deleteTravellogById(Integer id);


    /**
     * 根据标题模糊查询游记
     * @param tlTitle 标题
     * @return
     */
    List<TravelLog> selectTravelLogLikeTitle(String tlTitle);

    /**
     * 查询所有游记
     * @return 游记集合
     */
    List<TravelLog> getAllTravelLog();

    /**
     * 用户新增游记
     *@param travelLog 游记
     * @return
     */
    @Insert("insert into " +
            "travellog(tl_Title,tl_Summary,tl_Key_Word," +
            "tl_Click_Count,tl_Like_Count,tl_Favorite_Count,userinfo_Id,tl_Status,tl_Content) " +
            "values(#{tlTitle},#{tlSummary},#{tlKeyWord},#{tlClickCount}," +
            "#{tlLikeCount},#{tlFavoriteCount},#{userinfoId},#{tlStatus},#{tlContent}) ")
    int addTravelLog(TravelLog travelLog);


    /**
     * 增加收藏数,每次掉用+1
     *
     * @param id 游记ID
     * @return
     */
    @Update("update travellog set tl_Favorite_Count = tl_Favorite_Count+1 where id = #{id}")
    int addFavoriteCountNum(Integer id);

    /**
     * 减少收藏数,每次掉用-1
     *
     * @param id 游记ID
     * @return
     */
    @Update("update travellog set tl_Favorite_Count = tl_Favorite_Count-1 where id = #{id}")
    int lowerFavoriteCountNum(Integer id);


    /**
     * 修改游记点击量,每次调用则点击量+1
     *
     * @param id 游记ID
     * @return
     */
    @Update("update travellog set tl_Click_Count = tl_Click_Count+1 where id = #{id}")
    int clickCount(Integer id);

    /**
     * 增加点赞数,每次掉用+1
     *
     * @param id 游记ID
     * @return
     */
    @Update("update travellog set tl_Like_Count = tl_Like_Count+1 where id = #{id}")
    int addLikeCountNum(Integer id);

    /**
     * 减少点赞数,每次掉用-1
     *
     * @param id 游记ID
     * @return
     */
    @Update("update travellog set tl_Like_Count = tl_Like_Count-1 where id = #{id}")
    int lowerLikeCountNum(Integer id);
}
