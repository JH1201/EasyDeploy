package com.jioon.deploy_project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.service.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;




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
        
        projectService.uploadProject(userId, projectName, projectDescription, projectTag, projectVersion, dockerfile, buildFile);
    
        return "redirect:/afterLog";
    }

    @PostMapping("/deleteProject")
    public ResponseEntity<Map<String, String>> deleteProjectMethod(@RequestParam int projectId) {
        
        projectService.deleteProject(projectId);

        // JSON 형태로 리다이렉트 정보를 반환
        Map<String, String> response = new HashMap<>();
        response.put("redirectUrl", "/afterLog");  // 리다이렉트 URL
            
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateProject")
    public ResponseEntity<Map<String, String>> updateProjectMethod(@RequestBody int projectId, Model model) {
        
        projectService.updateProject(projectId);

        // JSON 형태로 리다이렉트 정보를 반환
        Map<String, String> response = new HashMap<>();
        response.put("redirectUrl", "/afterLog");  // 리다이렉트 URL
        model.addAttribute("oneProject", projectService.getProject(projectId));

        return ResponseEntity.ok(response);
    }
    
}

