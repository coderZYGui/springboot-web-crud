package com.gzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Description: 登录控制器
 *
 * @author zygui
 * @date 2020/4/14 17:31
 */
@Controller
public class LoginController {

    // @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login") // 等同上面
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "1".equals(password)) {
            // 保存用户的session信息
            session.setAttribute("loginUser", username);
            // 登录成功,防止表单重复提交,可以重定向到主页
            // 会通过模板引擎解析
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "index"; // 返回首页
        }
    }
}
