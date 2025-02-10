package com.jioon.deploy_project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.DTO.projectDTO;

public interface ProjectService {
    public void uploadProject(String userId, String projectName, String projectDescription, String projectTag, String projectVersion, byte[] dockerfile, byte[] buildFile, String dockerfileName ,String buildfileName);
    
    public List<projectDTO> getProjectList(String userId);

    public void deleteProject(int projectid);

    public void updateProject(int projectId, String userId, String projectName, String projectDescription, String projectTag, String projectVersion, MultipartFile dockerfile, MultipartFile buildFile, String dockerName, String buildName);

    public List<projectDTO> getAllProject();

    public projectDTO getProject(int projectId);
}
