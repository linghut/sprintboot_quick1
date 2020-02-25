package com.sprintboot.sprintboot.coller;

import com.sprintboot.sprintboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserImpl {
    public List<User> findAll();
}
