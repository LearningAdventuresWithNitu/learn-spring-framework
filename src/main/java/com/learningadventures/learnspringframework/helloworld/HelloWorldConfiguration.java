package com.learningadventures.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
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
    @Primary
    public Person person() {
        return new Person("Andy", 30, new Address("Vincent Street", "Vienna"));
    }

    // Creating a bean using exisiting beans
    // We call the exisiting name and age methods
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // Another way to use exisiting beans to create a new bean
    @Bean
    public Person person3Parameters(String name, int age, Address newAddress) {
        // We use names of existing beans as parameters
        return new Person(name, age, newAddress);
    }

    @Bean
    public Person person4Qualifier(String name, int age,  @Qualifier("address2qualifier") Address newAddress) {
        // We use names of existing beans as parameters
        return new Person(name, age, newAddress);
    }

    @Bean(name = "address1")
    @Primary
    public Address address() {
        return new Address("Roehampton Avenue", "Toronto");
    }

    @Bean
    @Qualifier("address2qualifier")
    public Address address2() {
        return new Address("First Avenue", "Toronto");
    }
    
}