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
}