package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// {}

/* NOTES:
 * 
 * @Component(...): An instance of class (a spring bean) will be managed by Spring framework
 * @Dependecy: GameRunner needs GamingConsole implementation
 * @ComponentScan: Specify package names to scan it and it's sub packages for components
 * DependencyInjection: Identify beans, their dependencies, and wire them together (provides IOC - Inversion of Control)
 * 		Spring Beans: An object managed by Spring Framework
 * 		IoC Container: Manages the life cycle of beans and dependencies
 * 			Types: ApplicationContext (complex), BeanFactory (simpler features - rarely used)
 * 		Autowiring: Process of wiring in dependencies for a Spring Bean
 */

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
