package com.example.smscodesecurity.validate.code.sms;

import javax.naming.AuthenticationException;

public class SmsCodeException extends AuthenticationException {
    public SmsCodeException(String msg){
        super(msg);
    }
}
