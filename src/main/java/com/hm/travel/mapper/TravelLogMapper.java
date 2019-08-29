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
     * 游记推荐调用,根据点击量查询前三条游记
     * @return
     */
    List<TravelLog> getHotTravelLog();

    /**
     *
     * 首页展示,查询4条数据
     * @return 游记集合
     */
    List<TravelLog> getIndexTravelLog();


    /**
     * 查询可读游记总数
     * @return
     */
    @Select("select count(1) from travelLog t where t.tl_status = 0  ")
    int getTravelLogNum();

    /**
     * 根据ID查询游记,即用户查看该游记详情
     * @param id
     * @return
     */
    TravelLog selectTravellogById(Integer id);


    /**
     * 管理员更新游记状态
     *
     * @return
     */
    @Update("update travelLog set TL_Status = #{tlStatus} where id = #{id}")
    int updateTravellogStatus(TravelLog travelLog);


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
     * 查询所有可读游记
     * @return 游记集合
     */
    List<TravelLog> getAllTravelLog();

    /**
     * 查询所有游记(包含不可读游记,管理员调用)
     * @return
     */
    List<TravelLog> getAnyTravelLog();

    /**
     * 用户新增游记
     *@param travelLog 游记
     * @return
     */
    @Insert("insert into " +
            "travellog(tl_Title,tl_Summary,tl_Key_Word," +
            "tl_Click_Count,tl_Like_Count,tl_Favorite_Count,userInfo_Id,tl_Status,tl_Content,tl_Photo) " +
            "values(#{tlTitle},#{tlSummary},#{tlKeyWord},#{tlClickCount}," +
            "#{tlLikeCount},#{tlFavoriteCount},#{userInfo.id},#{tlStatus},#{tlContent},#{tlPhoto}) ")
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
