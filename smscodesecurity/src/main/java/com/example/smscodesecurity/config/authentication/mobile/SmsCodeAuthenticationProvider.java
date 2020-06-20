package com.example.smscodesecurity.config.authentication.mobile;

import com.example.smscodesecurity.details.CustomUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private CustomUserService customUserService;

    public void setCustomUserService(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken smsCodeAuthenticationToken = (SmsCodeAuthenticationToken) authentication;
        UserDetails userDetails = this.customUserService.loadUserByMobils((String)smsCodeAuthenticationToken.getPrincipal());

        SmsCodeAuthenticationToken result = Optional.ofNullable(userDetails).map(user-> new SmsCodeAuthenticationToken(user, user.getAuthorities())).orElseThrow(()-> new InternalAuthenticationServiceException("无法获取用户信息"));
        result.setDetails(smsCodeAuthenticationToken.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
