package com.security.testlogin.validate.code.impl;

import org.springframework.web.context.request.ServletWebRequest;

@FunctionalInterface
public interface ValidateCodeProcessor {
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
    String CODE_PROCESSOR = "CodeProcessor";
    void create(ServletWebRequest request) throws Exception;
}
