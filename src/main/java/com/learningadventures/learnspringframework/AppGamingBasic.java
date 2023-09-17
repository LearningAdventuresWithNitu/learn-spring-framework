package com.learningadventures.learnspringframework;

import com.learningadventures.learnspringframework.game.GameRunner;
import com.learningadventures.learnspringframework.game.GamingConsole;
import com.learningadventures.learnspringframework.game.MarioGame;
import com.learningadventures.learnspringframework.game.PacmanGame;
import com.learningadventures.learnspringframework.game.SuperContraGame;

public class AppGamingBasic {
    public static void main(String[] args) {
        // GamingConsole game = new PacmanGame();
        // GamingConsole game = new SuperContraGame();
        GamingConsole game = new MarioGame();
        
        GameRunner gameRunner = new GameRunner(game);
        gameRunner.run();        
    }
    
}
