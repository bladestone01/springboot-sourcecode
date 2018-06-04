package org.fish.code.boot.source.beans.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class DogDelegate implements BeanFactoryAware {
    private BeanFactory beanFactory;
    
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public void testDog() {
		Dog dog = (Dog)this.beanFactory.getBean("dog");
		dog.voice();
	}
}
