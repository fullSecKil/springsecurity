package com.security.testlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private RedirectStrategy redirectStrategy;

    public static final String RETURN_TYPE = "html";


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/authentication/login")
    @ResponseBody
    public Map<String, Object> authenticationLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if("html".equals(RETURN_TYPE)){
            System.out.println("1111");
            redirectStrategy.sendRedirect(request, response, "/login/index");
            // restTemplate.getForObject("http://localhost:8080/login/index", String.class);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code",1001);
        map.put("msg","需要登录");
        return map;
    }

    // 登录页面
    @GetMapping("/login/index")
    public String loginIndex(){
        return "login";
    }

    @GetMapping("/user/index")
    @ResponseBody
    public String index(){
        return "index user";
    }

    @GetMapping("/admin/index")
    @ResponseBody
    public String indexAdmin(){
        return "index admin";
    }
}
