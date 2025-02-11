package com.jioon.deploy_project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.DTO.fileDTO;
import com.jioon.deploy_project.DTO.projectDTO;
import com.jioon.deploy_project.service.ProjectService;
import com.jioon.deploy_project.mapper.ProjectMapper;
@Service
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void uploadProject(String userId, String projectName, String projectDescription, String projectTag, String projectVersion, String dockerfileName, String buildfileName) {
        
        projectDTO project = new projectDTO();
        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        project.setProjectTag(projectTag);
        project.setProjectVersion(projectVersion);
        project.setUserId(userId);
        project.setDfileName(dockerfileName);
        project.setBfileName(buildfileName);

        projectMapper.insertProject(project);
    }

    @Override
    public void uploadProjectFile(String userId, byte[] dockerfile, String dockerfileName, byte[] buildfile, String buildfileName) {
        fileDTO fileDTO = new fileDTO();
        fileDTO.setUserId(userId);
        fileDTO.setDockerFile(dockerfile);
        fileDTO.setDfileName(dockerfileName);
        fileDTO.setBuildFile(buildfile);
        fileDTO.setBfileName(buildfileName);

        projectMapper.insertProjectFile(fileDTO);
    }

    
    @Override
    public List<projectDTO> getProjectList(String userId) {
        List<projectDTO> projects = projectMapper.getProjectList(userId);
        return projects;
    }

    @Override
    public void deleteProject(int projectid) {
        projectMapper.deleteProject(projectid);
    } 

    @Override
    public void updateProject(int projectId, String userId, String projectName, String projectDescription, String projectTag, String projectVersion, MultipartFile dockerfile, MultipartFile buildFile, String dockerName, String buildName) {

        Map<String, Object> params = new HashMap<>();
        params.put("projectName", projectName);
        params.put("projectDescription", projectDescription);
        params.put("projectTag", projectTag);
        params.put("projectVersion", projectVersion);
        params.put("projectId", projectId);
        params.put("dfileName", dockerName);
        params.put("bfileName", buildName);
        
        projectMapper.updateProject(params);
    }

    @Override
    public List<projectDTO> getAllProject() {
        return projectMapper.getAllProject();
    }

    @Override
    public projectDTO getProject(int projectId) {
        return projectMapper.getProject(projectId);
    }

}

