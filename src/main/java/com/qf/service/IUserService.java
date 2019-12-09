package com.qf.service;

import com.qf.domain.User;
import com.qf.response.UserResponse;

import java.util.List;

public interface IUserService {
    //分页查询
    UserResponse findAll(Integer size, Integer page);
    //修改前查询一条信息
    User findOne(Integer id);
    //修改 修改一条信息
    User saveAndFlush(User user);
    //根据id删除一条信息
    String deleteById(User user);
}
