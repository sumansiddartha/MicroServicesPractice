package com.lcwd.Notification.Configuration;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationServiceConfiguration {
	
	@Bean
	public Supplier<String> testing(){
		return ()->"This is for testing";
	}
	
	@Bean
	public Function<String,String> helloTesting(){
		return (message)->"Is this the right time to talk to you ??"+message;
	}
	

}
