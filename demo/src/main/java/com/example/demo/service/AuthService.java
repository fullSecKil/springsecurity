package com.example.demo.service;

import com.example.demo.model.entity.User;

/**
 * @www.codesheep.cn 20190312
 */
public interface AuthService {

    User register(User userToAdd);

    String login(String username, String password);
}
