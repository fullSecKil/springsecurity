package com.example.smscodesecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.DefaultRedirectStrategy;

@Configuration
public class RootConfig {

    @Bean
    public DefaultRedirectStrategy redirectStrategy(){
        return new DefaultRedirectStrategy();
    }
}
