package com.example.smscodesecurity.validate.code.sms;

public interface SmsCodeSender {
    void send(String mobile, String code);
}
