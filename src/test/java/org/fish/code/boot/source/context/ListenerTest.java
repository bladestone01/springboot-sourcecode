package org.fish.code.boot.source.context;

import org.fish.code.boot.source.context.event.GreetingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ListenerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListener() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:source/learn/context/event/spring-event-listener.xml");
		
		log.debug("Listener Test Case.....");
		GreetingEvent event = new GreetingEvent("sourceObject", "fabulous....");
		context.publishEvent(event);
		
		context.close();	
	}
}
