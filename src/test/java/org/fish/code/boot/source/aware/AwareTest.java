package org.fish.code.boot.source.aware;

import org.fish.code.boot.source.beans.aware.DogDelegate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AwareTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAware() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:source/learn/aware/aware-test.xml");
		
		DogDelegate dogDelegate = (DogDelegate)context.getBean("dogwrapper");
		dogDelegate.testDog();
		
		context.close();
	}

}
