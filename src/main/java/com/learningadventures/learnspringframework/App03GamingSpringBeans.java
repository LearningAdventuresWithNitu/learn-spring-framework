package com.learningadventures.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learningadventures.learnspringframework.game.GameRunner;
import com.learningadventures.learnspringframework.game.GamingConsole;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
