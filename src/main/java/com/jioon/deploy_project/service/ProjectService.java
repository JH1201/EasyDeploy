package com.jioon.deploy_project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.DTO.projectDTO;

public interface ProjectService {
    public void uploadProject(String userId, String projectName, String projectDescription, String projectTag, String projectVersion, String dockerfileName, String buildfileName);
    
    public void uploadProjectFile(String userId, String projectName, byte[] dockerFile, String dockerfileName, byte[] buildFile, String buildfileName);

    public List<projectDTO> getProjectList(String userId);

    public void deleteProject(int projectid);

    public void deleteProjectFile(String userId, String projectName);

    public void updateProject(int projectId, String userId, String projectName, String projectDescription, String projectTag, String projectVersion, MultipartFile dockerfile, MultipartFile buildFile, String dockerName, String buildName);

    public void updateProjectFile(String userId, String projectName, byte[] dockerfile, String dockerfileName, byte[] buildfile, String buildfileName);

    public List<projectDTO> getAllProject();

    public projectDTO getProject(int projectId);

}
