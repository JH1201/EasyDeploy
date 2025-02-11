package com.jioon.deploy_project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jioon.deploy_project.DTO.projectDTO;
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
        
        System.out.println("[upload PostMapping]");


        // 세션에서 데이터 가져오기
        String userId = (String) session.getAttribute("userid");

        byte[] dockerfileContent = null;
        byte[] buildfileContent = null;
        
        try {
            dockerfileContent = dockerfile.getBytes();
            buildfileContent = buildFile.getBytes();
        } catch(Exception e) {
            e.printStackTrace();
        }

        String dockerfileName = dockerfile.getOriginalFilename();
        System.out.println(dockerfileName);
        String buildfileName = buildFile.getOriginalFilename();
        System.out.println(buildfileName);

        projectService.uploadProject(userId, projectName, projectDescription, projectTag, projectVersion);
        projectService.uploadProjectFile(userId, dockerfileContent, dockerfileName, buildfileContent, buildfileName);

        return "redirect:/afterLog";
    }

    @PostMapping("/deleteProject")
    public ResponseEntity<Map<String, String>> deleteProjectMethod(@RequestParam int projectId) {
        
        System.out.println("[delete PostMapping]");

        projectService.deleteProject(projectId);

        // JSON 형태로 리다이렉트 정보를 반환
        Map<String, String> response = new HashMap<>();
        response.put("redirectUrl", "/afterLog");  // 리다이렉트 URL
            
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateProject")
    public String updateProjectMethod(@RequestParam("projectName") String projectName,
                                                                   @RequestParam("projectDescription") String projectDescription,
                                                                   @RequestParam("projectTag") String projectTag,
                                                                   @RequestParam("projectVersion") String projectVersion,
                                                                   @RequestParam("dockerfile") MultipartFile dockerfile,
                                                                   @RequestParam("buildFile") MultipartFile buildFile,
                                                                   @RequestParam("projectId") String projectId,
                                                                   HttpSession session,
                                                                   Model model) 
    {
        
        System.out.println("[update PostMapping]");
        // 세션에서 데이터 가져오기
        String userId = (String) session.getAttribute("userid");
        int projectID = Integer.parseInt(projectId);

        String dockerfileName = dockerfile.getOriginalFilename();
        System.out.println(dockerfileName);
        String buildfileName = buildFile.getOriginalFilename();
        System.out.println(buildfileName);
                
        projectService.updateProject(projectID, userId, projectName, projectDescription, projectTag, projectVersion, dockerfile, buildFile, dockerfileName, buildfileName);
        
        /* // JSON 형태로 리다이렉트 정보를 반환
        Map<String, String> response = new HashMap<>();
        response.put("redirectUrl", "/afterLog");  // 리다이렉트 URL
        model.addAttribute("oneProject", projectService.getProject(projectID));
         */
        //ResponseEntity.ok(response);

        return "redirect:/afterLog";
    }
    
    @GetMapping("/getProjectDetails")
    public ResponseEntity<projectDTO> getProjectDetails(@RequestParam int projectId) {
        projectDTO project = projectService.getProject(projectId);

        System.out.println(projectId);
        System.out.println("[getProjectDetails GetMapping]");
        System.out.println("project ID : " + project.getProjectId());
        System.out.println("user ID : " + project.getUserId());
        return ResponseEntity.ok(project);
    }


}

