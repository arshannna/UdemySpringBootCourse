package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		// my attempt
		/*
		try(var context =
				new AnnotationConfigApplicationContext(
						GamingConfiguration.class)){
			
			var game = context.getBean("pacmanGame");
			
			var gameRunner = new GameRunner(game);
			
			gameRunner.run();
			
			
		}
		*/
		
		// ANSWER KEY
		
		try(var context = 
				new AnnotationConfigApplicationContext(
						GamingConfiguration.class);){
		
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		
		}
		
		
		
		// Recreating this using spring
		
		/*
		//var allows the compiler to infer the variable based on the value assigned.
		
		//var game = new MarioGame(); 
		//var game = new SuperContraGame();
		
		//1: Object Creating
		var game = new PacmanGame(); 
		
		//2: Object Creation + Wiring of Dependencies
		//Game is a Dependency of GameRunner
		var gameRunner = new GameRunner(game);
		
		gameRunner.run();
		
		*/

	}

}
