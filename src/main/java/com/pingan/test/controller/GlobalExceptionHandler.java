package com.pingan.test.controller;

import com.pingan.test.entity.ResponseData;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(HttpServletRequest req, Exception e)
        throws Exception {
        logger.error("",e);
        ResponseData response = new ResponseData();
        response.setMessage(e.getMessage());
        if (e instanceof NoHandlerFoundException) {
            response.setCode("404");
        } else {
            response.setCode("500");
        }
        response.setData(null);
        response.setStatus(false);
        return response;
    }
}
