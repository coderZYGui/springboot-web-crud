package com.gzy.exception;

/**
 * Description: 用户不存在的异常
 *
 * @author zygui
 * @date 2020/4/16 14:23
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户名不存在");
    }
}
