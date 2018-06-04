package org.fish.code.boot.source.schema;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCustomSchema() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath*:source/learn/schema/custom-bean.xml");
		Product product = (Product)context.getBean("pproduct");
		
		System.out.println("Object Info:" + ReflectionToStringBuilder.toString(product));
		
		context.close();
	}

	
	@Test
	public void testFloatString() {
		String floatStr = "10.5";
		
		String pattern = "-?\\\\d+(\\\\.\\\\d+)";
		
		if (floatStr.matches(pattern)) {
			System.out.println("Float:" + true);
		}
		else 
			System.out.println("Float:" + false);
	}
	
	
}
