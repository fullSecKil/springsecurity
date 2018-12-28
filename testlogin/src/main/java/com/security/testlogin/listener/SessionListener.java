package com.security.testlogin.listener;

import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
@Component
/**
 * 将生成的imageCode 存入Session中
 */
public class SessionListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String oldName = event.getName();
        HttpSession session = event.getSession();
        session.getAttribute(oldName);
    }
}
