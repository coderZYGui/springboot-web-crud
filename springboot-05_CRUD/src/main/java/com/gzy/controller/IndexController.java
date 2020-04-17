package com.gzy.controller;

import com.gzy.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author zygui
 * @date 2020/4/1 17:32
 */
@Controller
public class IndexController {

//    @RequestMapping({"/", "/index.html"})
//    public String index(){
//        return "index";
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("username") String username) {
        if (!username.equals("1111")) {
            throw new UserNotExistException();
        }
        System.out.println("username=:" + username);
        return "Hello World!";
    }
}
