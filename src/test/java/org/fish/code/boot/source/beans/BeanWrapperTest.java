package org.fish.code.boot.source.beans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

/**
 * 
 * @author chenjunfeng1
 *
 */
public class BeanWrapperTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBeanWrapper() {
		CustomBean customBean = new CustomBean();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(customBean);

		bw.setPropertyValue("name", "Jackie Chen");

		System.out.println("User Name:" + customBean.getName());

		bw.setPropertyValue("name", "Thomas Zhou");

		System.out.println("User Name:" + customBean.getName());
	}

}
