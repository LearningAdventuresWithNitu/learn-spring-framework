package com.learningadventures.learnspringframework.examples.a2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

/* Default intialization for Spring Beans is Eager, beans are intialized at start up, unless we explicitly add the @Lazy annotation.
Using @Lazy annotation we configure the beans to be lazily initialized. Lazy-resolution proxy will be injected instead of the actual dependency.
The bean is initialized when it is first made use of in the application. 
However, eager initialization is recommended as we come across errors at startup instead of Run-time.  */
@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some intialization logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do something here!!");
    }
}

@Configuration
@ComponentScan
public class LazyIntializationLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyIntializationLauncherApplication.class)) {

            System.out.println("Context Initialization is completed");
            
            // You can see in the output that using @Lazy annotation
            // initialization of the bean is done only after we add the next line to call the doSomething method.
            // Bean intialization after the context initializagtion is completed and  not at the start up due to use of @Lazy annotation.
            // In case of Eager initialization, any intialization errors wil prevent application from starting up.
            // Whereas, in case of Lazy initialization errors will result in runtime exceptions.
            context.getBean(ClassB.class).doSomething();
        }
    }
}
