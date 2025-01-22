package com.jioon.deploy_project.service;

import org.springframework.web.multipart.MultipartFile;

public interface ProjectService {
    public void uploadProject(String userId, String projectName, String projectDescription, String projectTag, String projectVersion, MultipartFile dockerfile, MultipartFile buildFile);
}
