package org.fish.code.boot.source.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
public class AOPCase {
    
	@Pointcut("execution(* *.voice(..))")
	public void voice() {
		log.debug("AOP Voice Point Cut....");
	}
	
	@Before("voice()") 
	public void beforeVoice() {
		log.debug("Before the voice method invocation....");
	}
	
	@After("voice()")
	public void afterVoice() {
		log.debug("After the voice method invocation.....");
	}
	
	@Around("voice()")
	public Object aroundVoice(ProceedingJoinPoint p) throws Throwable {
		log.debug("Around Voice Before Message.....");
		
		Object result = null;
		try {
			result = p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.debug("Around Voice After real invocation....");
		return result;
	}
}
