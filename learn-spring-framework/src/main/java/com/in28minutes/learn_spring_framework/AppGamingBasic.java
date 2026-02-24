package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class AppGamingBasic {

	public static void main(String[] args) {
		
		//var allows the compiler to infer the variable based on the value assigned.
		
		//var game = new MarioGame(); 
		//var game = new SuperContraGame();
		var game = new PacmanGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();

	}

}
