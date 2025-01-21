package com.jioon.deploy_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jioon.deploy_project.DTO.userDTO;
import com.jioon.deploy_project.mapper.UserLoginMapper;
import com.jioon.deploy_project.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userMapper;

    @Override
    public userDTO userLogin(String userid, String password) {
        return userMapper.userLogin(userid, password);
    }

    @Override
    public void userRegister(userDTO user) {
        userMapper.userRegister(user);
    }

    @Override
    public boolean isUserIdExists(String userid) {
        return userMapper.isUserIdExists(userid);
    }
}
