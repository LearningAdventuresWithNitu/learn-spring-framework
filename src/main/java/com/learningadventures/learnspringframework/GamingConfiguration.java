package com.learningadventures.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learningadventures.learnspringframework.game.GameRunner;
import com.learningadventures.learnspringframework.game.GamingConsole;
import com.learningadventures.learnspringframework.game.PacmanGame;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole game() {
        return new PacmanGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }
    
}
