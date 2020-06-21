package com.security.testlogin.validate.code.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.security.testlogin.validate.code.image.ImageCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @file: ValidateCodeBeanConfig.class
 * @author: Dusk
 * @since: 2018/12/28 22:06
 * @desc:
 */

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /***
     *  如果容器中已经存在名字为imageCodeGenerator的Bean,则不需要实例化Bean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setDefaultKaptcha(defaultKaptcha);
        return imageCodeGenerator;
    }
}
