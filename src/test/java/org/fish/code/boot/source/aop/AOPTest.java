package org.fish.code.boot.source.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AOPTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAOP() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:source/learn/aop/aop-case1.xml");
		
		Cat cat = (Cat)context.getBean("cat");
		log.debug("Cat is voicing:{}", cat.voice());
		
		context.close();
	}

}
