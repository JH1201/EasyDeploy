package com.jioon.deploy_project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jioon.deploy_project.DTO.projectDTO;

@Mapper
public interface ProjectMapper {
    
    public void insertProject(projectDTO project);
}

