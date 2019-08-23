package com.hm.travel.mapper;

import com.hm.travel.pojo.HotleRoom;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author jlz
 * @date 2019/8/23 14:16
 */
@Repository
public interface HotleRoomMapper {
    //面向用户: 订购房间(更改房间余量)
    //面向管理员:修改房间余量,修改房间价格

    /**管理员操作
     *
     * 修改房间余量,房间价格
     * @param hotleRoom
     * @return
     */
    @Update("update hotleRoom(sigle_Room,double_Room,business_Room,couple_Room,sigle_Room_Price,double_Room_Price,business_Room_Price,couple_Room_Price)" +
            "values(#{sigleRoom},#{doubleRoom},#{businessRoom},#{coupleRoom},#{sigleRoomPrice},#{doubleRoomPrice},#{businessRoomPrice},#{coupleRoomPrice} where id = #{id})")
    int updateRoomNum(HotleRoom hotleRoom);


}
