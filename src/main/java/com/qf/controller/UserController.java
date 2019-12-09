package com.qf.controller;

import com.qf.domain.User;
import com.qf.response.UserResponse;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;
    //分页查询
    @RequestMapping("/findAll/{size}/{page}")
    public UserResponse findAll(@PathVariable("size")Integer size, @PathVariable("page")Integer page){
        return userService.findAll(size,page);
    }
    //修改查询一条信息
    @RequestMapping("/findOne")
    public User findOne(@RequestBody User user){
        Integer id = user.getId();
        return userService.findOne(id);
    }
    //修改或增加 修改一条信息
    @RequestMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.saveAndFlush(user);
    }
    //根据id删除一条信息
    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    public String deleteById(@RequestBody User user){
        return userService.deleteById(user);
    }
}
