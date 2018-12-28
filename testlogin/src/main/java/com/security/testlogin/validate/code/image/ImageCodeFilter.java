package com.security.testlogin.validate.code.image;

import com.security.testlogin.validate.code.impl.ValidateCodeProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class ImageCodeFilter extends OncePerRequestFilter implements InitializingBean {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    private Set<String> urls = new HashSet<>();

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        // 这里可以设置，哪些地址是需要图片验证码进行验证的
        urls.add("/authentication/form");   // 登陆
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;

        for (String url: urls){
            if (antPathMatcher.match(url, request.getRequestURI())){
                action = true;
                break;
            }
        }

        if(action) {
            try{
                validate(request);
            } catch (ImageCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validate(HttpServletRequest request){
        ImageCode imageCodeSession = (ImageCode) request.getSession().getAttribute(ValidateCodeProcessor.SESSION_KEY_PREFIX +  "IMAGE");
        String imageCodeRequest = request.getParameter("imageCode");
        if (imageCodeRequest == null || imageCodeRequest.isEmpty()){
            throw new ImageCodeException("图片验证码不能为空");
        }
        if (imageCodeSession == null){
            throw new ImageCodeException("验证码不存在");
        }
        if(imageCodeSession.isExpired()){
            request.getSession().removeAttribute(ValidateCodeProcessor.SESSION_KEY_PREFIX + "IMAGE");
            throw new ImageCodeException("验证码已过期");
        }
        if(!imageCodeRequest.equalsIgnoreCase(imageCodeSession.getCode())) {
            throw new ImageCodeException("验证码错误");
        }
        request.getSession().removeAttribute(ValidateCodeProcessor.SESSION_KEY_PREFIX + "IMAGE");
    }
}
