package com.jioon.deploy_project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.DTO.projectDTO;
import com.jioon.deploy_project.service.ProjectService;
import com.jioon.deploy_project.mapper.ProjectMapper;
@Service
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void uploadProject(String userId, String projectName, String projectDescription, String projectTag, String projectVersion, byte[] dockerfile, byte[] buildfile, String dockerfileName ,String buildfileName) {
        
        /* 
        byte[] dockerfileContent = null;
        byte[] buildfileContent = null;
        
        try {
            dockerfileContent = dockerfile.getBytes();
            buildfileContent = buildFile.getBytes();
        } catch(Exception e) {
            e.printStackTrace();
        }
        */
        
        projectDTO project = new projectDTO();
        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        project.setProjectTag(projectTag);
        project.setProjectVersion(projectVersion);
        project.setBuildfile(dockerfile);
        project.setBuildfile(buildfile);
        project.setUserId(userId);
        project.setDockerName(dockerfileName);
        project.setBuildName(buildfileName);

        projectMapper.insertProject(project);
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
    public void updateProject(int projectId, String userId, String projectName, String projectDescription, String projectTag, String projectVersion, MultipartFile dockerfile, MultipartFile buildFile) {

        //projectDTO project = new projectDTO();

        byte[] dockerfileContent = null;
        byte[] buildfileContent = null;
        
        try {
            dockerfileContent = dockerfile.getBytes();
            buildfileContent = buildFile.getBytes();
        } catch(Exception e) {
            e.printStackTrace();
        }

        /*
        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        project.setProjectTag(projectTag);
        project.setProjectVersion(projectVersion);
        project.setBuildfile(dockerfileContent);
        project.setBuildfile(buildfileContent);
        project.setUserId(userId); 
         */

        Map<String, Object> params = new HashMap<>();
        params.put("projectName", projectName);
        params.put("projectDescription", projectDescription);
        params.put("projectTag", projectTag);
        params.put("projectVersion", projectVersion);
        params.put("projectDockerfile", dockerfileContent);
        params.put("projectBuildfile", buildfileContent);
        params.put("projectId", projectId);
        
        
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

