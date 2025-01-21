package com.jioon.deploy_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.jioon.deploy_project.DTO.userDTO;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        // 세션에서 사용자 정보 가져오기
        userDTO user = (userDTO) session.getAttribute("user");
        
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            return "afterLog";
        }

        return "index";
    }

    @GetMapping("/guide")
    public String guidePage() {
        return "guide";
    }

    @GetMapping("/popular")
    public String popularPage() {
        return "popular";
    }
}
