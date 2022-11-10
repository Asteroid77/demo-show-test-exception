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

## 抛出该异常的原因
`@ConditionalOnWebApplication`这个注解指的是是"当前项目是Web项目时才会生效"。
但如果这个注解是在A注解的内部，而这个A注解又作用于Application启动类的时候，那么此时Application类会在注释作用下成为当前项目是Web项目时才会生效。
而Spring Boot Test运行的单测文件并非都有Web环境，这就会导致其默认状态下找不到Application类，需要手动指定classes。
往Application类添加注解时需谨慎。
