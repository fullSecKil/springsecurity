package com.example.smscodesecurity.validate.code.sms;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {
    /**
     * 具体操作打印---
     * @param mobile
     * @param code
     */
    @Override
    public void send(String mobile, String code) {
        log.info("向手机" + mobile + "发送验证码" + code);
    }
}
