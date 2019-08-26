package com.hm.travel.service;

import com.hm.travel.pojo.View;

import java.util.List;

public interface ViewService {

    /**
     * 根据id查询view
     * @param id
     * @return
     */
    public View searchById(int id);

    /**
     * 根据id删除view
     * @param id
     */
    public  void  removeViewById(int id);



    /**
     * 通过viewName查询view
     *
     */

    public boolean findViewByName(String name);


    /**
     * 查询所有view
     * @return
     */
    public List<View> getAllView();


    /**
     * 新增view
     */
    public  void  addView(View view);


    /**
     * 修改view
     */
    public void  updateView(View view);


    /**
     * 模糊查询
     * @return
     */
    public List<View> searchByWord(String word);


    /**
     * 模糊查询2
     */
    public List<View> searchByWord2(String word);

    /**
     * 修改景点点击量,每次调用则点击量+1
     *
     * @param id 景点ID
     * @return
     */
    int clickCount(Integer id);

    /**
     * 查询4个最热门的景点
     */
    List<View> searchHotView();

    /**
     * 根据城市id找出3个景点
     */
    List<View> searchHotViewByCityId(int id);

}
