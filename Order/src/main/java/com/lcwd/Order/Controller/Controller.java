package com.lcwd.Order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.Order.OrderService;
import com.lcwd.Order.Model.OrderDetail;

@RestController
@RequestMapping("/api/v1/orders")
public class Controller {
	
    private OrderService orderService;
    
	public Controller(OrderService orderService) {
		super();
		this.orderService = orderService;
	}


	@Autowired
	StreamBridge streamBridge;

	@PostMapping
	public ResponseEntity<?> createOrder(){
		OrderDetail order=this.orderService.createOrder();
		OrderCreatedNotification(order);
		return ResponseEntity.ok("Order Created");
	}
	
	
	private void OrderCreatedNotification(OrderDetail order) {
		boolean send = streamBridge.send("orderCreatedEvent-out-0", order);
		if(send) {
			System.out.println("order successfully sent");
		}
		else {
			System.out.println("Not successfully sent");
		}
		
	}
	
}
