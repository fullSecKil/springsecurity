package com.example.securityadjwt2.service;

import com.example.securityadjwt2.dao.UserRepository;
import com.example.securityadjwt2.pojo.LoginUser;
import com.example.securityadjwt2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        List<GrantedAuthority> authoritieList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER");
//        LoginUser loginUser = new LoginUser(username, passwordEncoder.encode("2"), authoritieList);
//        loginUser.setNickName("zui i");
//        return loginUser;

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
