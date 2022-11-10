package com.example.demoshowtestexception.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * @className: TestConfiguration
 * @description: 测试配置类
 * @author: meteor
 * @date: 2022/11/10
 **/
@Configuration
public class TestConfiguration {
    public TestConfiguration() {
        System.out.println("加载成功");
    }
}
