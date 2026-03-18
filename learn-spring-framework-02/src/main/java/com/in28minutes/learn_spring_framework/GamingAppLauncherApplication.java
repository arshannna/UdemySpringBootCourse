package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
	
//How can have we have Spring automatically create the beans for us?
@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework") //Package to scan for spring components
public class GamingAppLauncherApplication {
	
//	@Bean //testing out @Component to auto create this bean
//	public GamingConsole game(){
//		
//		var game = new PacmanGame();
//		return game;
//	}
	
//	public GameRunner gameRunner(GamingConsole game){ //Exercise make @Compoenet to auto create bean
//		
//		//System.out.println("Parameter: " + game);
//		
//		var gameRunner = new GameRunner(game); //or can call the the method directly, game -> game()
//		return gameRunner;
//	}
	
	/*
	 * When to use @Qualifier vs @Primary?
	 * 
	 * @Primary: A bean should be given pregerance when mulitple canidates are qualified
	 * @Qualifier: A specific bean should be auto-wired (name of the bean can be used as qualifier) - lowercase first letter?
	 * 
	 *		Just @Autowired: Give me (preferred/primary) bean
	 *		@Autowired + @Qualifier: Use a specific bean based on the qualifier given
	 *
	 * @Qualifier has HIGHER priority than @Primary
	 * Can use the name of the bean as a qualifier (i.e. @Qualifier("<Bean name>"))
	 */

	public static void main(String[] args) {
		
		
		try(var context = 
				new AnnotationConfigApplicationContext(
						GamingAppLauncherApplication.class);){
		
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		
		}
		
	}
	
	

}
