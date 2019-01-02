package com.security.testlogin.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.security.testlogin.validate.code.image.ImageCodeGenerator;
import com.security.testlogin.validate.code.impl.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setDefaultKaptcha(defaultKaptcha);
        return imageCodeGenerator;
    }
}
