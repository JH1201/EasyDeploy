package com.jioon.deploy_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "regis";
    }

    @GetMapping("/forgot-password")
    public String forgetPWPage() {
        return "forgetPW";
    }

    @GetMapping("/afterLog")
    public String afterLogPage() {
        return "afterLog";
    }
}
