package com.example.smscodesecurity.validate.code.sms;

import com.example.smscodesecurity.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 */

@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<SmsCode> {

    private static final String SMS_CODE_PARAM_NAME = "mobile";

    @Autowired
    private SmsCodeSender smsCodeSender;

    /**
     *  发送
     * @param request
     * @param validateCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, SmsCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), SMS_CODE_PARAM_NAME);
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
