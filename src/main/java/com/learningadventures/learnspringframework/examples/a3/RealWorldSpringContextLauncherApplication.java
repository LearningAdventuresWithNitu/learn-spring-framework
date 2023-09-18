package com.learningadventures.learnspringframework.examples.a3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)) {
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
