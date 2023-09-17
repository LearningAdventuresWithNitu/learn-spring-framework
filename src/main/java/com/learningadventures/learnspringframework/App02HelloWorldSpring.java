package com.learningadventures.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // 1. Launch a Spring Context - we use the configuration file we create to launch a spring context.
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2. Configure the things that we want the Spring Framework to manage and we use the configuration class to do so - @Configuration
        // We created the name method in the conifguration class with @Bean annotation

        // 3. Retrieving Beans managed by Spring Context/ Spring Container
        // Notice that these beans used below are all unrelated
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean(Address.class));
    }
    
}
