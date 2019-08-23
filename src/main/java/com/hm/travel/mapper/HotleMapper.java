package com.hm.travel.mapper;

import com.hm.travel.pojo.Hotle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/23 10:06
 */
@Repository
public interface HotleMapper {
    //面向用户:查所有,根据酒店名模糊查询,
    //面向管理员:查所有,根据酒店名模糊查询,根据ID查询(编辑时),编辑酒店信息,新增酒店,删除酒店

    /**
     * 查询所有酒店集合
     * @return
     */
    List<Hotle> getAllHotle();

    /**
     * 根据酒店名模糊查询酒店
     * @param hotleName
     * @return 酒店
     */
    List<Hotle> selectHotleByLikeName(String hotleName);

    /**
     * 根据ID查询酒店
     * @param id
     * @return
     */
    Hotle selectHotleById(Integer id);

    /**
     * 修改酒店信息,评分除外
     * @return
     */
    int updateHotle(Hotle hotle);


    /**
     * 添加酒店
     * @param hotle
     * @return
     */
    @Insert("insert into hotle(hotle_Name,hotle_Photo,hotle_Grade,hotle_Start,hotle_Info,city_id,hotleroom_id) " +
            "values(#{hotleName},#{hotlePhoto},#{hotleGrade},#{hotleStart},#{hotleInfo},#{city.id})")
    int addHotle(Hotle hotle);

    /**
     * 根据ID删除酒店
     * @return
     */
    @Delete("delete from hotle where id = #{id}")
    int delectHotleById(Integer id);
}
