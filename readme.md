# Spring Boot Test无法自动正确寻找启动类的问题

## 问题简述
当一个Annotation类中含有以下注解并在启动类使用该Annotation类时，会出现Spring Boot Test无法自动正确寻找启动类的问题.
抛出`Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test`异常
## Annotation类
```
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnWebApplication
public @interface TestAnnotation {}
```
## 启动类
```
@TestAnnotation
@SpringBootApplication
public class DemoShowTestExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoShowTestExceptionApplication.class, args);
    }
}
```
