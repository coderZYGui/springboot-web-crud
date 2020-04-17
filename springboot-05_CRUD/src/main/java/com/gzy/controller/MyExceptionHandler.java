package com.gzy.controller;

import com.gzy.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 定义一个全局异常处理器
 *
 * @author zygui
 * @date 2020/4/16 14:55
 */
@ControllerAdvice
public class MyExceptionHandler {

    //1. 这样的操作, 在浏览器还是客户端访问返回的都是JSON数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class) // 来处理我们定义的异常类
//    public Map<String, Object> handlerException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistException.class) // 来处理我们定义的异常类
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 系统获取状态码的方法
        // Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        // 传入我们自己的状态码
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", "用户出错啦");
        request.setAttribute("ext", map);
        // 转发到/error(使用SpringBoot默认的error视图)
        return "forward:/error";
    }
}
