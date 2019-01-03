package com.example.smscodesecurity.details;

import com.example.smscodesecurity.pojo.LoginUser;
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
public class CustomUserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //  通过用户名s去数据库里查找用户以及用户权限
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER");
        LoginUser loginUser = new LoginUser(username, passwordEncoder.encode("123456"), authorityList);
        loginUser.setNickName("Dusk");
        return loginUser;
    }

    public UserDetails loadUserByMobils(String mobile) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER");
        LoginUser loginUser = new LoginUser(mobile, passwordEncoder.encode("123456"), authorityList);
        loginUser.setNickName("Dusk");
        return loginUser;
    }
}
