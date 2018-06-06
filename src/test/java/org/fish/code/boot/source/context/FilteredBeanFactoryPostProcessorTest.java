package org.fish.code.boot.source.context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FilteredBeanFactoryPostProcessorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFilteredBean() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:source/learn/context/placeholder/placeholder-filter.xml");
		
		log.debug("UserProfile: {}", context.getBean("userprofile"));
		
		context.close();
	}

}
