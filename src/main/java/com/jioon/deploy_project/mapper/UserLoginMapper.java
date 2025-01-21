package com.jioon.deploy_project.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.jioon.deploy_project.DTO.userDTO;

@Mapper
public interface UserLoginMapper {
    userDTO userLogin(String userid, String password);

    void userRegister(userDTO user);

    boolean isUserIdExists(String userid);
}

