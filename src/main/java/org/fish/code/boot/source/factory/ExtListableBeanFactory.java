package org.fish.code.boot.source.factory;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Extension of the Bean Factory in Customization.
 * 
 * @author chenjunfeng1
 *
 */
public class ExtListableBeanFactory extends DefaultListableBeanFactory {
    private List<ConfigurableApplicationContext> accessiableFactories;
    
    public ExtListableBeanFactory(BeanFactory parentBeanFactory) {
    	super(parentBeanFactory);
    }
    
    public void setAccessiableFactories(List<ConfigurableApplicationContext> accessiableFactories) {
    	this.accessiableFactories = accessiableFactories;
    }
    
    public <T> T getBeanExt(String name, Class<T> requiredType, Object... args) {
    	if (accessiableFactories == null ||  accessiableFactories.size() == 0) {
    		return null;
    	}
    	
    	for (ConfigurableApplicationContext ac : accessiableFactories) {
    		try {
    			T bean = ((ExtListableBeanFactory) ac.getBeanFactory()).getBeanSuper(name, requiredType, args);
    			if (bean != null) return bean;
    		} catch (BeansException e) {
    			 e.printStackTrace();
    		}
    	}
    	
    	return null;
    }
    
    public <T> T getBeanExt(String name, Class<T> requiredType) {
    	if (accessiableFactories == null ||  accessiableFactories.size() == 0) {
    		return null;
    	}
    	
    	for (ConfigurableApplicationContext ac : accessiableFactories) {
    		try {
    			T bean = ((ExtListableBeanFactory) ac.getBeanFactory()).getBeanSuper(requiredType);
    			if (bean != null) return bean;
    		} catch (BeansException e) {
    			 e.printStackTrace();
    		}
    	}
    	
    	return null;
    }
    
    
    public <T> T getBeanSuper(String name, Class<T> requiredType, Object... args) {
    	return super.getBean(name, requiredType, args);	
    }
    
    public <T> T getBeanSuper(String name, Class<T> requiredType) {
    	return super.getBean(name, requiredType);	
    }
    
    public Object getBeanSuper(String name, Object... args) {
    	return super.getBean(name, args);	
    }
    
    public <T> T getBeanSuper(Class<T> requiredType) {
    	return super.getBean(requiredType);	
    }
    
    @Override
    public <T> T getBean(String name, Class<T> requiredType, Object... args) {
    	T re = this.getBeanExt(name, requiredType, args);
    	
    	if (re != null) return re;
    	
    	return doGetBean(name, requiredType, args ,false);
    }
    
    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
    	T re = this.getBeanExt(name, requiredType );
    	
    	if (re != null) return re;
    	
    	return doGetBean(name, requiredType, null ,false);
    }
    
    @Override
    public Object getBean(String name, Object... args) {
    	Object re = this.getBeanExt(name, null, args );
    	
    	if (re != null)  return re;
    	
    	return doGetBean(name, null, null ,false);
    } 
}
