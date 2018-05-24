package org.fish.code.boot.source.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomBeanTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("source/learn/config/factorybean-config.xml");
        CustomBean customObj = (CustomBean)applicationContext.getBean("customBean");
        
        System.out.println("Name in CustomBean:" + customObj.getName());
        
        System.out.println(applicationContext.getBean("customBean") == applicationContext.getBean("customBean"));
        System.out.println(applicationContext.getBean("customBean") == applicationContext.getBean("customBean"));
        
        applicationContext.close();
	}

}
