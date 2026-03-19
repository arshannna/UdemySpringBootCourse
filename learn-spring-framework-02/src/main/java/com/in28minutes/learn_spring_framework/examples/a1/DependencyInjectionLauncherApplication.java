package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// {}



@Component
class YourBuisnessClass{
	
	@Autowired //If this is not added, it will not auto wire it -> spring automatically does field injection when @Autowired is added
	Dependency1 dependency1;
	
	@Autowired 
	Dependency2 dependency2;
	
	public String toString(){
		
		return "Using " + dependency1 + " and " + dependency2;
	}
	
}
@Component
class Dependency1{
	
	
}
@Component
class Dependency2{
	
	
	
}

@Configuration
@ComponentScan //Automatically does component scan on the current package, you can add ("package name") to specify which package to scan
public class DependencyInjectionLauncherApplication {


	public static void main(String[] args) {
		
		
		try(var context = 
				new AnnotationConfigApplicationContext(
						DependencyInjectionLauncherApplication.class);){
	
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);;
			
			System.out.println(context.getBean(YourBuisnessClass.class)); //Better practice to use class/type of bean rather than the actual name of bean
		}
		
	}
	
	
}
