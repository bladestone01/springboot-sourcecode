package org.fish.code.boot.source.context;

import org.fish.code.boot.source.context.editor.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Reference: https://www.logicbig.com/tutorials/spring-framework/spring-core/property-editors.html
 * @author chenjunfeng1
 *
 */
public class CustomEditorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void testEditorCustom() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:source/learn/context/editor/context-date-editor-custom.xml");
		Person person = (Person)context.getBean("person");
		System.out.println("Person Data:" + person);
        context.close();
	}
	
	@Test
	public void testEditorEmbedded() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:source/learn/context/editor/context-date-editor-embedded.xml");
		Person person = (Person)context.getBean("person");
		System.out.println("Person Data:" + person);
        context.close();
	}

}
