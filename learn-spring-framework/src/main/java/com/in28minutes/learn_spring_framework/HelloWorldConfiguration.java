package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //indicates there are @Bean methods 
public class HelloWorldConfiguration {
	
	
	@Bean  //indicates method creates a bean for the spring container
	public String name(){
		
		return "Ranga";
	}
	
}
