package org.fish.code.boot.source.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class ProductNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		this.registerBeanDefinitionParser("product", new ProductBeanDefinitionParser());
	}

}
