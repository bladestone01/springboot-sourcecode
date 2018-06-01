package org.fish.code.boot.source.factory;

import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;

/**
 * Restraint on the accesiable Parent ApplicationContext.
 * 
 * @author chenjunfeng1
 *
 */
public class LimitedClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
	private List<ConfigurableApplicationContext> accessiableFactories;
	
	public LimitedClassPathXmlApplicationContext(String... configLocations) {
		super(configLocations, true, null);
	}

	public LimitedClassPathXmlApplicationContext(List<ConfigurableApplicationContext> accessiableFactories,
			String... configLocations) {
        super((ApplicationContext)null);
        
        this.accessiableFactories = accessiableFactories;
        this.setConfigLocations(configLocations);
        this.refresh();
	}
	
	public LimitedClassPathXmlApplicationContext(String[] configLocations, @Nullable ApplicationContext parent) {
		super(configLocations,true, parent);
	}
	
	@Override
	protected DefaultListableBeanFactory createBeanFactory() {
		ExtListableBeanFactory beanFactory = new ExtListableBeanFactory(this.getInternalParentBeanFactory());
		beanFactory.setAccessiableFactories(this.accessiableFactories);
		return beanFactory;
	}
}
