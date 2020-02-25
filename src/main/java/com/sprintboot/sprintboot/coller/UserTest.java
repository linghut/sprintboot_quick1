package com.sprintboot.sprintboot.coller;

import com.sprintboot.sprintboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserTest {

    @Autowired
    private UserImpl userImpl;

    @ResponseBody
    @RequestMapping("/hello2")
    public List<User> findall(){
        List<User> users=userImpl.findAll();
        return users;
    }

}
