package org.fish.code.boot.source.beans.hello;

import org.fish.code.boot.source.beans.CustomBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SimpleFactoryTest {

	public static void main(String[] args) {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("source/learn/config/factorybean-config.xml"));
		
		CustomBean bean = (CustomBean)bf.getBean("mybean");
		
		System.out.println("bean.name:" + bean.getName());
	}

}
