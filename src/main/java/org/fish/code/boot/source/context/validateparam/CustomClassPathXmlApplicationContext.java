package org.fish.code.boot.source.context.validateparam;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. extend the ClassPathXmlApplicationContext.
 * 2. override the initPropertySource Method
 * 3. 
 * @author tonychen
 *
 */
public class CustomClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public CustomClassPathXmlApplicationContext(String configLocation) throws BeansException {
		super(new String[] {configLocation}, true, null);
	}
	
	@Override
	protected void initPropertySources() {
		this.getEnvironment().setRequiredProperties("test111");
	}
}
