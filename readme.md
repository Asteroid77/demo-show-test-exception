# Spring Boot Test无法自动正确寻找启动类的问题

## 问题简述
创建一个Spring Boot工程，在启动类中使用Annotation。
这个Annotation中含有`Retention(RetentionPolicy.RUNTIME)` 以及 
`@ConditionalOnWebApplication`这两个注解，那么在使用功能Spring Boot Test时，将会出现无法自动正确寻找启动类的问题，抛出`Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test`异常
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
