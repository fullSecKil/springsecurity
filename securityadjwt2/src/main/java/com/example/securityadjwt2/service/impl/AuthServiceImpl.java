package com.example.securityadjwt2.service.impl;

import com.example.securityadjwt2.component.JwtTokenUtil;
import com.example.securityadjwt2.dao.UserRepository;
import com.example.securityadjwt2.pojo.User;
import com.example.securityadjwt2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author dusk
 * @since 2020/6/14 11:26
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public String login(String username, String password) {
        final UsernamePasswordAuthenticationToken upToke = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToke);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public User register(User userToAdd) {

        final String username = userToAdd.getUsername();
        if (Objects.nonNull(userRepository.findByUsername(username))) {
            return null;
        }
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(bCryptPasswordEncoder.encode(rawPassword));
        return userRepository.save(userToAdd);
    }

}
