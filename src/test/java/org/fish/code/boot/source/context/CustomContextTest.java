package org.fish.code.boot.source.context;

import org.fish.code.boot.source.context.validateparam.CustomClassPathXmlApplicationContext;
import org.fish.code.boot.source.context.validateparam.HelloBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;

public class CustomContextTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidProperty() {
		//ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		ConfigurableApplicationContext context = new CustomClassPathXmlApplicationContext(
				"classpath:source/learn/context/custom/context-custom-property.xml");
		HelloBean hello = (HelloBean)context.getBean("hello");
		
		System.out.println("msg:" + hello.getMesg());
		context.close();
	}

}
