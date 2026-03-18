package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// {}

@Component
class YourBuisnessClass{
	
	
	
}
@Component
class Dependency1{
	
	
}
@Component
class Dependency2{
	
	
	
}

@Configuration
@ComponentScan //Automatically does component scan on the current package 
public class DependencyInjectionLauncherApplication {


	public static void main(String[] args) {
		
		
		try(var context = 
				new AnnotationConfigApplicationContext(
						DependencyInjectionLauncherApplication.class);){
	
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);;
		}
		
	}
	
	
}
