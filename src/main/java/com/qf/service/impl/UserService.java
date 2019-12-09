package com.qf.service.impl;

import com.qf.domain.User;
import com.qf.repository.IUserRepository;
import com.qf.response.UserResponse;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

   @Autowired
   private IUserRepository userRepository;

   //分页查询
    @Override
    public UserResponse findAll(Integer size,Integer page) {
        if (page<0){
            page=0;
        }else {
            page=page-1;
        }

        PageRequest pages = PageRequest.of(page, size);
        Page<User> all = userRepository.findAll(pages);
        List<User> content = all.getContent();
        UserResponse urs = new UserResponse();
        urs.setList(content);
        urs.setPage(all.getTotalPages());
        urs.setTotal(all.getTotalElements());
        return urs;
    }
    //修改 查询一条信息
    @Override
    public User findOne(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        User user=null;
        if (byId.isPresent()){
            user = byId.get();
        }
        return user;
    }
    //修改或增加 修改一条信息
    @Override
    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }
    //根据id删除一条信息
    @Override
    public String deleteById(User user) {
        try{
            System.out.println(user.getId()+"=========================");
            userRepository.deleteById(user.getId());
            return "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "fail";
    }
}
