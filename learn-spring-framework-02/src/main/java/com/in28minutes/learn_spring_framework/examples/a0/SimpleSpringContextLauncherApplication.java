package com.in28minutes.learn_spring_framework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//EXERCISE

@Configuration
@ComponentScan //Automatically does component scan on the current package 
public class SimpleSpringContextLauncherApplication {


	public static void main(String[] args) {
		
		//MY ATTEMPT
		
		try(var context = 
				new AnnotationConfigApplicationContext(
						SimpleSpringContextLauncherApplication.class);){
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
	
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);;
		}
		
	}
	
	

}
