package com.example.securityadjwt2.controller;

import com.example.securityadjwt2.pojo.User;
import com.example.securityadjwt2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

/**
 * @author dusk
 * @since 2020/6/14 14:36
 */
@RestController
public class JwtAuthController {

    @Autowired
    private AuthService authService;

    // 登录
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public String createToken(String username, String password) throws AuthenticationException {
        return authService.login(username, password);
    }

    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public User register(@RequestBody User addUser) {
        return authService.register(addUser);
    }

    @PostMapping(value = "/authentication/message")
    public String test() {
        return "测试中";
    }
}
