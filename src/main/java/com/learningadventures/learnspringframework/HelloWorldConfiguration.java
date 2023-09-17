package com.learningadventures.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age) {};
record Address (String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {

    // We can define Spring beans here; Spring beans are the things managed by Spring
    // We can define the methods to create these Spring beans in this configuration class
    @Bean
    public String name() {
        return "Learning Adventures with Nitu";
    }

    @Bean
    public int age() {
        return 80;
    }

    @Bean
    public Person person() {
        return new Person("Andy", 30);
    }

    @Bean(name = "newAddress")
    public Address address() {
        return new Address("Roehampton Avenue", "Toronto");
    }
    
}
