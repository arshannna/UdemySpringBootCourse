package com.in28minutes.learn_spring_framework; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	
	// my attempt
	/*
	@Bean
	public PacmanGame pacmanGame(){
		
		return new PacmanGame();
	}
	
	@Bean
	public SuperContraGame supercontraGame(){
		
		return new SuperContraGame();
	}
	
	@Bean
	public MarioGame marioGame(){
		
		return new MarioGame();
	}
	*/
	
	// ANSWER KEY
	
	@Bean
	public GamingConsole game(){
		
		var game = new PacmanGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game){
		
		var gameRunner = new GameRunner(game); //or can call the the method directly, game -> game()
		return gameRunner;
	}
	
	
	
	

}
