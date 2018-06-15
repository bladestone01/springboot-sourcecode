package org.fish.code.boot.source.web;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class Case1Controller implements EnvironmentAware {
	private Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
    
	
	@RequestMapping(value= {"/index", "/"}, method= {RequestMethod.GET}) 
	public String index(Model model) {
		log.info("=========== processed by index ==========");
		
		model.addAttribute("msg", "Good News for you.....");
		
		return "main";
	}
}
