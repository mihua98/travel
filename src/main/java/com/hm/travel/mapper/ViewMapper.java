package com.hm.travel.mapper;

import com.hm.travel.pojo.View;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewMapper {
    /**
     * 根据id删除景点
     */
    void removeViewById(int id);

    /**
     * 根据viewname查询景点
     *
     * @param name
     * @return
     */
    List<View> findViewByName(String name);

    /**
     * 获得所有view
     *
     * @return
     */
    List<View> getAllView();

    /**
     * 新增view
     *
     * @param view
     */
    void addView(View view);

    /**
     * 根据id修改数据
     *
     * @param view
     */
    void updateViewById(View view);

    /**
     * 模糊查询
     */
    List<View> searchByWord(String search);

    /**
     * 模糊查询2
     *
     * @param word
     * @return
     */
    List<View> searchByWord2(String word);

    /**
     * 根据id查询view
     *
     * @param id
     * @return
     */
    View searchById(int id);

    /**
     * 修改景点点击量，每次调用点击量加1，id是景点id
     *
     * @param id
     * @return
     */
    int cilckCount(int id);

    /**
     * 查询最热门的4个景点
     *
     * @return
     */
    List<View> searchHotView();

    /**
     * 根据城市id查询3个景点
     *
     * @param id
     * @return
     */
    List<View> searchHotViewByCityId(int id);
}
