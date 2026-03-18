package com.in28minutes.learn_spring_framework.game;

import org.springframework.stereotype.Component;

//@Component //gives an error because two matching beans in main due to pacman and mariogame
public class MarioGame implements GamingConsole{
	
	public void up(){
		
		System.out.println("Jump");
	}
	
	public void down(){
		
		System.out.println("Go");
	}
	
	public void left(){
		
		System.out.println("Go back");
	}
	
	public void right(){
		
		System.out.println("Accelerate");
	}
	
	
}
