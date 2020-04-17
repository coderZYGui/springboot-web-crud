package com.gzy.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * Description: 给容器加入自己定义的错误属性
 *
 * @author zygui
 * @date 2020/4/16 15:40
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        Throwable error = getError(webRequest);
        if (error != null) {
            map.put("exception", error.getClass().getName());
        }
        map.put("company", "zygui");
        // 我们的异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", webRequest.SCOPE_REQUEST);
        map.put("ext", ext);
        return map;
    }
}
