package com.xiaomikasa.springbootdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaomikasa.springbootdemo.bean.User;
import com.xiaomikasa.springbootdemo.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() throws JsonProcessingException {
        //1从redis中获得数据,数据的形式为JSON字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        //2.判断redis中是否存在数据
        if (null==userListJson){
            //3.不存在数据,从数据库查询
            List<User> userList = userDao.findAll();
            //4.将查询出的数据存到redis缓存中
            //将List转为json格式的字符串,使用jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(userList);
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("从数据库中获得user数据");
        }else{
            System.out.println("从redis中获得user数据");
        }

        //打印数据
        System.out.println(userListJson);

    }

}
