package com.in28minutes.learn_spring_framework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
		
		//name, age, address2
		return new Person(name, age, address2);
	}
	
	@Bean
	@Primary
	//No qualifying bean of type 'com.in28minutes.learn_spring_framework.Address' 
	//available: expected single matching bean but found 2: address2,address3
	//-> when trying to pass through parameters or trying to fetch from a Spring context, if you have multiple matching
	//beans (candidates) you get this exception
	//FIX: making a bean a primary or qualifier
	public Person person4Parameters(String name, int age, Address address){
		
		return new Person(name, age, address);
		
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address){
		
		return new Person(name, age, address);
		
	}
	
	@Bean(name = "address2") //customize the bean name to be called something other than the method name
	@Primary //makes it so that this is the "default" bean to choose
	public Address address(){
		
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3Qualifier") //used to specify which bean to chose if you don't want the default
	public Address address3(){
		
		return new Address("Motinagar", "Hyderabad");
	}

	
}
