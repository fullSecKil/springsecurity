package com.example.demo.comm;

/**
 * @www.codesheep.cn 20190312
 */
public class Const {

    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "CodeSheepSecretkkkkkkkkkkkkkkkkkkkkkkkknfcQSESNNLLSIOSMmmWSDADWDAIDJ";      // JWT密码
//    public static final String SECRET = "C*F-JaNdRgUkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w";
    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key
}
