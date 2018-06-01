package org.fish.code.boot.source.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Product Schema xml definition Parser.
 * 
 * @author chenjunfeng1
 * 
 */
public class ProductBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	private static final String NAME_ATTR = "pname";
	private static final String PRICE_ATTR = "price";
	private static final String COUNT_ATTR = "count";

	private static final String FLOAT_PATTERN = "-?\\\\d+(\\\\.\\\\d+)";
	private static final String INT_PATTERN = "\\\\d+";

	@Override
	protected Class<?> getBeanClass(Element element) {
		return Product.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute(NAME_ATTR);
		String priceStr = element.getAttribute(PRICE_ATTR);
		String countStr = element.getAttribute(COUNT_ATTR);

		if (StringUtils.hasText(name)) {
			builder.addPropertyValue(NAME_ATTR, name);
		}

		if (StringUtils.hasText(priceStr) && priceStr.matches(FLOAT_PATTERN)) {
            builder.addPropertyValue(PRICE_ATTR, Float.parseFloat(priceStr));
		}
		 
		if (StringUtils.hasText(priceStr) && priceStr.matches(INT_PATTERN)) {
			builder.addPropertyValue(COUNT_ATTR, Float.parseFloat(countStr));
		}
	}
}
