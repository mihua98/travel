package com.hm.travel.service.impl;

import com.hm.travel.mapper.ViewMapper;
import com.hm.travel.pojo.View;
import com.hm.travel.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {

      @Autowired
    ViewMapper viewMapper;

    @Override
    public View searchById(int id) {
       return viewMapper.searchById(id);
    }

    /**
     * 根据id删除view
     * @param id
     */
    public  void  removeViewById(int id){
        viewMapper.removeViewById(id);
    }

    /**
     * 通过viewName查询view
     *
     */

    public boolean findViewByName(String name){
        List<View> list=viewMapper.findViewByName(name);
        return   list.isEmpty();
    }

    /**
     * 查询所有view
     * @return
     */
    public  List<View> getAllView(){
        List<View> views =viewMapper.getAllView();
        return  views;
    }

    /**
     * 新增view
     */
    public  void  addView(View view){
        viewMapper.addView(view);
    }

    /**
     * 修改view
     */
    public void  updateView(View view){
        viewMapper.updateViewById(view);
    }

    /**
     * 模糊查询
     * @return
     */
    public List<View> searchByWord(String word){
        List<View> views=viewMapper.searchByWord(word);
        return views;
    }

    /**
     * 模糊查询2
     */
    public List<View> searchByWord2(String word){

        return viewMapper.searchByWord2(word);
    }

    /**
     * 每次调用，点击数加1
     * @param id 景点ID
     * @return
     */
    @Override
    public int clickCount(Integer id) {
        return viewMapper.cilckCount(id);
    }

    /**
     *查询4个热门景点
     */
    @Override
    public List<View> searchHotView() {
        return viewMapper.searchHotView();
    }
    /**
     * 根据城市id找出3个景点
     */
    @Override
    public List<View> searchHotViewByCityId(int id) {
        return viewMapper.searchHotViewByCityId(id);
    }


}
