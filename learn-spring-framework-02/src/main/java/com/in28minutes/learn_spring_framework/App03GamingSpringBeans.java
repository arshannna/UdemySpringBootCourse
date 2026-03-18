package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
	
//How can have we have Spring automatically create the beans for us?
@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework") //Package to scan for spring components
public class App03GamingSpringBeans {
	
//	@Bean //testing out @Component to auto create this bean
//	public GamingConsole game(){
//		
//		var game = new PacmanGame();
//		return game;
//	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game){
		
		//System.out.println("Parameter: " + game);
		
		var gameRunner = new GameRunner(game); //or can call the the method directly, game -> game()
		return gameRunner;
	}

	public static void main(String[] args) {
		
		
		try(var context = 
				new AnnotationConfigApplicationContext(
						App03GamingSpringBeans.class);){
		
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		
		}
		
	}

}
