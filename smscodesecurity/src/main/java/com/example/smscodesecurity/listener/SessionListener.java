package com.example.smscodesecurity.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
@Component
@Slf4j
public class SessionListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        log.info("--attributeAdded--");
        HttpSession session=event.getSession();
        log.info("key----:"+event.getName());
        log.info("value---:"+event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        log.info("--attributeRemoved--");
        HttpSession session = event.getSession();
        log.info("key----:"+event.getName());
        log.info("value---:"+event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        log.info("--attributeReplaced--");
        String oldName = event.getName();
        log.info("--old key--"+oldName);
        log.info("--old value--"+event.getValue());
        HttpSession session = event.getSession();
        log.info("new value---:"+session.getAttribute(oldName));
    }
}
