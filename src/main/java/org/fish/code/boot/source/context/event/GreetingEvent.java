package org.fish.code.boot.source.context.event;

import org.springframework.context.ApplicationEvent;

public class GreetingEvent extends ApplicationEvent {
	private static final long serialVersionUID = 5656425214247046658L;

	private String msg;
	
	public GreetingEvent(Object source) {
		super(source);
	}

	public GreetingEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}
	
	public void greet() {
		System.out.println("Greeting Message:" + msg);
	}
}
