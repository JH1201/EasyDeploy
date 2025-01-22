package com.jioon.deploy_project.service;

import com.jioon.deploy_project.DTO.userDTO;

public interface UserLoginService {
    public userDTO userLogin(String userid, String password);


    public void userRegister(userDTO user);

    public boolean isUserIdExists(String userid);

    public boolean isUserEmailExists(String useremail);
    
}
