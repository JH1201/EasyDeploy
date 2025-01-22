package com.jioon.deploy_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.service.ProjectService;
import jakarta.servlet.http.HttpSession;

@Controller
public class projectController {
    
    @Autowired
    ProjectService projectService;

    @PostMapping("/uploadProject")
    public String uploadProject(@RequestParam("projectName") String projectName,
                                @RequestParam("projectDescription") String projectDescription,
                                @RequestParam("projectTag") String projectTag,
                                @RequestParam("projectVersion") String projectVersion,
                                @RequestParam("dockerfile") MultipartFile dockerfile,
                                @RequestParam("buildFile") MultipartFile buildFile,
                                HttpSession session) {

        // 세션에서 데이터 가져오기
        String userId = (String) session.getAttribute("userid");

        System.out.println("userId : " + userId);
        
        projectService.uploadProject(userId,projectName, projectDescription, projectTag, projectVersion, dockerfile, buildFile);
    
        return "redirect:/";
    }
}

