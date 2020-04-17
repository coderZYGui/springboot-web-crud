package com.gzy;

import com.gzy.config.MyMvcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class Springboot04WebApplicationTests {

    ApplicationContext ctx = new AnnotationConfigApplicationContext(MyMvcConfig.class);

    @Test
    void contextLoads() {
        // 看看容器中有哪些bean
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
