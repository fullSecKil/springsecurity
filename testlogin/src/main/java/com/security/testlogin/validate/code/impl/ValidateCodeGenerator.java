package com.security.testlogin.validate.code.impl;

import com.security.testlogin.config.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    public final String CODE_GENERATOR = "CodeGenerator";
    ValidateCode generator(ServletWebRequest request);
}
