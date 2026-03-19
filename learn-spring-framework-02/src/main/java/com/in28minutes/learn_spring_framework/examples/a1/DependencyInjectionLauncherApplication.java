package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// {}



@Component
class YourBuisnessClass{
	
	
	
	//Example 1
	//@Autowired //If this is not added, it will not auto wire it -> spring automatically does field injection when @Autowired is added
	Dependency1 dependency1;
	
	//@Autowired 
	Dependency2 dependency2;
	
	
	//Example 3
	//@Autowired //is not needed for constructor injection
	//Most recommended by Spring team - because all the dependencies are set when the object is created.
	public YourBuisnessClass(Dependency1 dependency1, Dependency2 dependency2) {
		
		super();
		System.out.println("Constructor Injection - YourBuisnessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

//	//Example 2
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		
//		//System.out.println("Setter Injection - setDependecy1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		
//		//System.out.println("Setter Injection - setDependecy2");
//		this.dependency2 = dependency2;
//	}

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
