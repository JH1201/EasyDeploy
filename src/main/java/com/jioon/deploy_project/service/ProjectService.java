package com.jioon.deploy_project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.DTO.projectDTO;

public interface ProjectService {
    public void uploadProject(String userId, String projectName, String projectDescription, String projectTag, String projectVersion, MultipartFile dockerfile, MultipartFile buildFile);
    public List<projectDTO> getProjectList(String userId);
}
