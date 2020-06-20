package com.example.smscodesecurity.validate.code.sms;

import com.example.smscodesecurity.validate.code.ValidateCode;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SmsCode extends ValidateCode {
    private String mobile;

    public SmsCode(String mobile, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.mobile = mobile;
    }

    public SmsCode(String mobile, String code, int expireTime) {
        super(code, expireTime);
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
