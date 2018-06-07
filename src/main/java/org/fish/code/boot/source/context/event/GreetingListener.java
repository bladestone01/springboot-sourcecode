package org.fish.code.boot.source.context.event;

import org.springframework.context.ApplicationListener;

public class GreetingListener implements ApplicationListener<GreetingEvent> {

	@Override
	public void onApplicationEvent(GreetingEvent event) {
		System.out.println("Receive the Greeting Event.....");
		event.greet();
	}

}
