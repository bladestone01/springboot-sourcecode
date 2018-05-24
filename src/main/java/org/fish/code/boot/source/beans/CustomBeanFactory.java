package org.fish.code.boot.source.beans;

import org.springframework.beans.factory.FactoryBean;

public class CustomBeanFactory implements FactoryBean<CustomBean> {

	@Override
	public CustomBean getObject() throws Exception {
		CustomBean customBean = new CustomBean();
		customBean.setName("custom name");
		customBean.setAge(100);
		return customBean;
	}

	@Override
	public Class<?> getObjectType() {
		return CustomBean.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
