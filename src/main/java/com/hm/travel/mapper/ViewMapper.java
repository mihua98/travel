package com.hm.travel.mapper;

import com.hm.travel.pojo.View;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewMapper {
    //根据id删除景点
    public void  removeViewById(int id);

    //根据viewname查询景点
    public List<View> findViewByName(String name);

    //获得所有view
    public List<View> getAllView();

    //新增view
    public void addView(View view);

    //根据id修改数据
    public void updateViewById(View view);

    //模糊查询
    public List<View> searchByWord(String word);

    //模糊查询2
    public List<View> searchByWord2(String word);

    //根据id查询view
    public View searchById(int id);

    //修改景点点击量，每次调用点击量加1，id是景点id
    public int cilckCount(int id);

    //查询最热门的4个景点
    public List<View> searchHotView();

    //根据城市id查询3个景点
    public List<View> searchHotViewByCityId(int id);
}
