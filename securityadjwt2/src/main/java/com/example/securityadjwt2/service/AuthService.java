package com.example.securityadjwt2.service;


import com.example.securityadjwt2.pojo.User;

public interface AuthService {
    User register(User userToAdd);

    String login(String username, String password);
}
