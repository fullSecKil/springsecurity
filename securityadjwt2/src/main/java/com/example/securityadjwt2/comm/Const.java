package com.example.securityadjwt2.comm;

/**
 * @author dusk
 * @since 2020/6/14 10:04
 */
public class Const {
    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "CodeSheepSecretkkkkkkkkkkkkkkkkkkkkkkkknfcQSESNNLLSIOSMmmWSDADWDAIDJ";      // JWT密码
    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key
}
