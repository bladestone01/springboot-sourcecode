package org.fish.code.boot.source.beans;

import org.fish.code.boot.source.beans.circledepend.Monk;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Circule Dependency in Creating Bean
 * 
 * @author chenjunfeng1
 *
 */
public class CirculeDependTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test(expected = BeanCreationException.class)
	public void testConstructorMode() {
		ConfigurableApplicationContext context = null;
		
		try {
			context = new ClassPathXmlApplicationContext("classpath*:source/learn/beans/circle-depend-constructor-case.xml");
			Monk monk = (Monk) context.getBean("monkBean");
			
			System.out.println("Monk:" + monk);
		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		} finally {
			if (context != null) context.close();
		}			
	}
	

	//@Ignore
	@Test(expected = StackOverflowError.class)
	public void testPrototypeMode() {
		ConfigurableApplicationContext context = null;
		
		try {
			context = new ClassPathXmlApplicationContext("classpath*:source/learn/beans/circle-depend-setter-prototype-case.xml");
			Monk monk = (Monk) context.getBean("monkBean");
			
			System.out.println("Monk:" + monk);
		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		} finally {
			if (context != null) context.close();
		}
				
	}

	@Ignore
	@Test
	public void testSetterMode() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:source/learn/beans/circle-depend-setter-case.xml");

		Monk monk = (Monk) context.getBean("monkBean");

		context.close();
	}
}
