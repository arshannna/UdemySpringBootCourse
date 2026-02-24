package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Getters and Setters, constructor, equals, hash code, and toString are auto created.
record Person(String name, int age, Address address) {};

record Address(String firstLine, String city) {};

@Configuration //indicates there are @Bean methods 
public class HelloWorldConfiguration {
	
	
	@Bean  //indicates method creates a bean for the spring container
	public String name(){
		
		return "Ranga";
	}
	
	@Bean
	public int age(){
		
		return 15;
	}
	
	@Bean
	public Person person(){
		
		return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
	}
	
	@Bean //creating a bean with relationship to other beans 
	public Person person2MethodCall(){
		
		return new Person(name(), age(), address()); //(name, age)
	}
	
	@Bean //passing beans through parameters, autowire them in
	public Person person3Parameters(String name, int age, Address address2){ //name,age
		
		return new Person(name, age, address2);
	}
	
	@Bean(name = "address2") //customize the bean name to be called something other than the method name
	public Address address(){
		
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address3")
	public Address address3(){
		
		return new Address("Motinagar", "Hyderabad");
	}

	
}
