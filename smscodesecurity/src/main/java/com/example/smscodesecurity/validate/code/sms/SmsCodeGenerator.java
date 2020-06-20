package com.example.smscodesecurity.validate.code.sms;

import com.example.smscodesecurity.validate.code.ValidateCode;
import com.example.smscodesecurity.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ValidateCode generator(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(6);
        return new SmsCode(request.getRequest().getParameter("mobile"), code, 60*5);
    }
}
