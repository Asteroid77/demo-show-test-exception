package com.example.demoshowtestexception;

import com.example.demoshowtestexception.annotation.TestAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@TestAnnotation
@SpringBootApplication
public class DemoShowTestExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShowTestExceptionApplication.class, args);
    }

}
