package com.jioon.deploy_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jioon.deploy_project.DTO.fileDTO;
import com.jioon.deploy_project.DTO.projectDTO;

@Mapper
public interface ProjectMapper {
    
    public void insertProject(projectDTO project);

    public void insertProjectFile(fileDTO fileDTO);

    public List<projectDTO> getProjectList(String userId);

    public int getProjectCount(String userId);

    public List<String> getProjecttags(String userid);

    public void deleteProject(int projectId);

    public void deleteProjectFile(String userId, String projectName);

    public void updateProject(@SuppressWarnings("rawtypes") Map map);
    
    public void updateProjectFile(@SuppressWarnings("rawtypes") Map map);

    public List<projectDTO> getAllProject();

    public projectDTO getProject(int projectId);
}

