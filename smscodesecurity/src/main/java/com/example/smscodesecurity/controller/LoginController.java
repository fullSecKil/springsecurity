package com.example.smscodesecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private RedirectStrategy redirectStrategy;

    public static final String RETURN_TYPE = "html"; // 需要登录时，用来判断是返回json数据还是跳转html页面

    // 如果用户访问的界面需要登录则会跳转到该路径，在这里判断是返回json格式的数据还是返回html页面
    @GetMapping(value = "/authentication/login")
    @ResponseBody
    public Object authenticationLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (RETURN_TYPE.equals("html")) {
            redirectStrategy.sendRedirect(request,response,"/login/index");
        }
        // 如果是需要返回json数据，则返回需要登录的信息提示
        Map<String, Object> map = new HashMap<>();
        map.put("code",1001);
        map.put("msg","需要登录");
        return map;
    }

    // 登录页面
    @GetMapping(value = "/login/index")
    public String loginIndex() throws IOException {
        return "login";
    }

    @GetMapping(value = "/user/index")
    @ResponseBody
    public String index(){
        return "index user";
    }

    @GetMapping(value = "/admin/index")
    @ResponseBody
    public String indexAdmin(){
        return "index admin";
    }

}
