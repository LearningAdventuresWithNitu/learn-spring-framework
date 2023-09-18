package com.learningadventures.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class MyBusinessClass {
    // To auto wire the dependencies we use the @Autowired annotation
    // Field injection - using @Autowired on a field is a Field injection which is a type of Dependency Injection
    // Setter-based Dependency Injection is when the @Autowired annotation is used for setters
    // Contructor-based Dependency Injection is when we use constructor to inject the dependencies, 
    // here @Autowired annotation is used for constructor
    // Spring recommends use of constructor based DI

    // @Autowired - field injection
    Dependency1 dependency1;

    // @Autowired - field injection
    Dependency2 dependency2;

    // /* Setter Dependency Injection  */
    // @Autowired
    // public void setDependency1(Dependency1 dependency1) {
    //     this.dependency1 = dependency1;
    // }

    // @Autowired
    // public void setDependency2(Dependency2 dependency2) {
    //     this.dependency2 = dependency2;
    // }
    
    /* Constructor Dependency Injection */
    public MyBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Using " + dependency1 + " add " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(MyBusinessClass.class).toString());
        }
    }
}
