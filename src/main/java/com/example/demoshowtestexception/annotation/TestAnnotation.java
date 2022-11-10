package com.example.demoshowtestexception.annotation;

import com.example.demoshowtestexception.configuration.TestConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @className: TestAnnotation
 * @description: 注解类测试，Retention与ConditionalOnWebApplication同用时会阻止Spring Boot Test正确自动寻找启动类位置
 * @author: meteor
 * @date: 2022/11/10
 **/
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnWebApplication
@Import(TestConfiguration.class)
public @interface TestAnnotation {

}
