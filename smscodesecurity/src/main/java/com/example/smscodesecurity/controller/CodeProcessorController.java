package com.example.smscodesecurity.controller;

import com.example.smscodesecurity.validate.code.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class CodeProcessorController {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessorMap;

    public void getCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        validateCodeProcessorMap.get(type + ValidateCodeProcessor.CODE_PROCESSOR).create(new ServletWebRequest(request, response));
    }
}
