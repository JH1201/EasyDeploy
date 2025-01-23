package com.jioon.deploy_project.service.impl;

import java.util.List;

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

    public void uploadProject(String userId, String projectName, String projectDescription, String projectTag, String projectVersion, MultipartFile dockerfile, MultipartFile buildFile) {
        byte[] dockerfileContent = null;
        byte[] buildfileContent = null;
        
        try {
            dockerfileContent = dockerfile.getBytes();
            buildfileContent = buildFile.getBytes();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        projectDTO project = new projectDTO();
        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        project.setProjectTag(projectTag);
        project.setProjectVersion(projectVersion);
        project.setProjectDockerfile(dockerfileContent);
        project.setProjectBuildfile(buildfileContent);
        project.setUserId(userId);

        projectMapper.insertProject(project);
    }

    public List<projectDTO> getProjectList(String userId) {
        List<projectDTO> projects = projectMapper.getProjectList(userId);
        return projects;
    }

    public void deleteProject(int projectid) {
        projectMapper.deleteProject(projectid);
    } 
}

