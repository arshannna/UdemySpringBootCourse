package com.in28minutes.learn_spring_framework.examples.a0;

import org.springframework.stereotype.Component;

//MY ATTEMPT

@Component
public class MongoDbDataService implements DataService {
	
	public int[] retrieveData(){ 
		
		return new int[] {11, 22, 33, 44, 55};
	}

}
