package com.sprintboot.sprintboot;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintboot.sprintboot.coller.UserImpl;
import com.sprintboot.sprintboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SprintbootQuickApplication.class)
public class juittest {

    @Autowired
    private UserImpl userImpl;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test(){
        List<User> users=userImpl.findAll();
        System.out.println(users);
        System.out.println("你好");
        String name = new String("nihao");
        System.out.println(name);
    }

    @Test
    public void redisTest() throws JsonProcessingException {
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
            if (null == userListJson) {
            List<User> all = userImpl.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(all);
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("=========从数据库中获取数据============" + all);
        } else {
            System.out.println("=========从redis缓存中获取数据============" + userListJson);
        }

    }

    @Test
    public void testRun(){
        System.out.println("你好");
    }

}
