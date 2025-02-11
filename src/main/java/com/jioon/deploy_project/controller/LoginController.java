package com.jioon.deploy_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jioon.deploy_project.DTO.userDTO;
import com.jioon.deploy_project.service.impl.ProjectServiceImpl;
import com.jioon.deploy_project.service.impl.UserLoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserLoginServiceImpl userService;

    @Autowired
    private ProjectServiceImpl projectService;
    

    @GetMapping("/login")
    public String loginPage() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userid, 
                       @RequestParam String password,
                       HttpSession session,
                       Model model) {      
        userDTO user = userService.userLogin(userid, password);
        
        if(user != null) {  
            // 세션에 사용자 정보 저장
            session.setAttribute("user", user);
            session.setAttribute("userid", user.getUserid());
            session.setAttribute("username", user.getUsername());
            
            System.out.println("로그인 성공: " + user.getUsername() + " (세션 ID: " + session.getId() + ")");
            System.out.println("userId : " + session.getAttribute("userid"));

            return "redirect:/afterLog";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "login/login";
        }
    }

    @GetMapping("/forgot-password")
    public String forgetPWPage() {
        return "login/forgetPW";
    }

    @GetMapping("/afterLog")
    public String afterLogPage(Model model, HttpSession session) {
        userDTO user = (userDTO) session.getAttribute("user");
        
        if (user == null) {
            return "redirect:/";  // 세션이 없으면 로그인 페이지로
        }
        
        model.addAttribute("username", user.getUsername());
        model.addAttribute("projects", projectService.getProjectList(user.getUserid()));
        

         
        return "login/afterLog";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "login/regis";
    }

    @PostMapping("/register")
    public String register(@RequestParam String userid, 
                         @RequestParam String password, 
                         @RequestParam String useremail, 
                         @RequestParam String username,
                         Model model) {
        userDTO user = new userDTO();

        // 아이디 중복 체크
        if (userService.isUserIdExists(userid)) {
            model.addAttribute("useridError", "이미 존재하는 아이디입니다.");
            model.addAttribute("userid", userid);
            model.addAttribute("useremail", useremail);
            model.addAttribute("username", username);
            return "login/regis";
        }

        // email 중복 체크
        if (userService.isUserEmailExists(useremail)) {
            model.addAttribute("userid", userid);
            model.addAttribute("useremail", useremail);
            model.addAttribute("useremailError", "이미 존재하는 이메일입니다.");
            model.addAttribute("username", username);
            return "login/regis";
        }

        user.setUserid(userid);
        user.setPassword(password);
        user.setUseremail(useremail);
        user.setUsername(username); 

        userService.userRegister(user);
        
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response, HttpSession session) {
        System.out.println("로그아웃: " + session.getAttribute("username") + " (세션 ID: " + session.getId() + ")");
        
        // 세션 무효화
        session.invalidate();
        
        // 쿠키 삭제
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/";
    }
}
