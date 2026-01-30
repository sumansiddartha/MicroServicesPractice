package com.lcwd.Order.Configuration;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationServiceConsuming {
	
	@Bean
	public Consumer<String> consumeAck(){
		return consumeack->System.out.println(consumeack);
	}

}
