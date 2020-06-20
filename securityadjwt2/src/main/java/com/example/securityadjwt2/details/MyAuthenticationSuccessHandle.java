package com.example.securityadjwt2.details;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyAuthenticationSuccessHandle extends SavedRequestAwareAuthenticationSuccessHandler {

    public static final String RETURN_TYPE = "html";

    private static final Logger log = Logger.getLogger(MyAuthenticationSuccessHandle.class);

    @Autowired
    private ObjectMapper objectMapper;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登陆成功");
        log.info("username=>" + request.getParameter("username"));
        if("html".equals(RETURN_TYPE)){
            // redirectStrategy.sendRedirect(request, response,"/admin/index");
            super.setDefaultTargetUrl("/admin/index"); // 设置默认登陆成功的跳转地址
            super.onAuthenticationSuccess(request, response, authentication);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("code", "0");
            map.put("msg","登录成功");
            map.put("data",authentication);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(map));
        }
    }
}
