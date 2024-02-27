package org.lyflexi.debug_springframework.factoryProcessor;


import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCLifeCircleTest {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);


		applicationContext.close();
	}

}
