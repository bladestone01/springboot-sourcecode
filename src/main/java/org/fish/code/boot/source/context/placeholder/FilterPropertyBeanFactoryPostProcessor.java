package org.fish.code.boot.source.context.placeholder;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

/**
 * Remove the specific property setting based on the pattern.
 * 
 * @author chenjunfeng1
 *
 */
public class FilterPropertyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private Set<String> filteredProperties;
    
    public FilterPropertyBeanFactoryPostProcessor() {
        this.filteredProperties = new HashSet<String>();	
    }
    
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		StringValueResolver valueResolver = new StringValueResolver() {
			@Override
			public String resolveStringValue(String strVal) {
				if (isFiltered(strVal)) return "******";
				
				return strVal;
			}
	    };
	    
		for (String beanName : beanNames) {
		    BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
		    
		    BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
		    visitor.visitBeanDefinition(beanDefinition);
		}
	}

	public boolean isFiltered(Object value) {
		String potentialValue = value.toString();
		
		return this.filteredProperties.contains(potentialValue);
	}
	
	public void setFilteredProperties(Set<String> filteredProperties) {
		this.filteredProperties.clear();
		this.filteredProperties.addAll(filteredProperties);
	}
}
