package com.lcwd.Notification.Configuration;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lcwd.Notification.Model.OrderDetail;

@Configuration
public class OrderNotificationFunctions {
	
	@Bean
	public Function<OrderDetail,String> orderEventReceiver(){
		
		return orderDetail->{
			System.out.println("Sending notification to user");
			logicToSendEmailAndMessageToUser(orderDetail.getEmail(),orderDetail.getUserPhone());
			return "order notification sent to user";
		};
		
	}

	private void logicToSendEmailAndMessageToUser(String email, String userPhone) {
		System.out.println("Sending email to  "+email);
		System.out.println("Sending message to "+userPhone);
		System.out.println("Notification sent to user ");
		System.out.println("---------------------------------------------------");
		
	}
	
	

}
