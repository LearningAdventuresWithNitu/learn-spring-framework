package com.learningadventures.learnspringframework;

import com.learningadventures.learnspringframework.game.GameRunner;
import com.learningadventures.learnspringframework.game.GamingConsole;
import com.learningadventures.learnspringframework.game.MarioGame;
import com.learningadventures.learnspringframework.game.PacmanGame;
import com.learningadventures.learnspringframework.game.SuperContraGame;

public class App01GamingBasic {
    public static void main(String[] args) {
        // GamingConsole game = new PacmanGame();
        // GamingConsole game = new SuperContraGame();
        GamingConsole game = new MarioGame(); // Here, we are creating the object but now we want the Spring Framework to do that for us and wire them together.
        
        GameRunner gameRunner = new GameRunner(game); // Object Creation + Wiring of Dependencies
        // Since GameRunner class needs a game object to run so we can say that game is a dependency of the GameRunner class.
        // We see that we are injecting the dependency game in the GameRunner class when passing it to the constructor in line 15.
                                                    
        gameRunner.run();        
    }
    
}