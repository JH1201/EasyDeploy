package com.jioon.deploy_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jioon.deploy_project.DTO.projectDTO;

@Mapper
public interface ProjectMapper {
    
    public void insertProject(projectDTO project);

    public List<projectDTO> getProjectList(String userId);

    public List<String> getProjecttags(String userid);

    public void deleteProject(int projectId);

    public void updateProject(Map map);

    public List<projectDTO> getAllProject();

    public projectDTO getProject(int projectId);

}

