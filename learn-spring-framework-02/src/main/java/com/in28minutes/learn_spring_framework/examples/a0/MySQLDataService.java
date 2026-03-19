package com.in28minutes.learn_spring_framework.examples.a0;

import org.springframework.stereotype.Component;

//MY ATTEMPT

@Component
public class MySQLDataService implements DataService {
	
	public int[] retrieveData(){ 
		
		return new int[] {1, 2, 3, 4, 5};
	}	

}
