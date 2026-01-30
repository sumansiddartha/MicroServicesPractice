package com.lcwd.Order;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.lcwd.Order.Model.OrderDetail;

@Service
public class OrderService {
	
	public OrderDetail createOrder() {
		OrderDetail od=new OrderDetail();
		od.setOrderId(UUID.randomUUID().toString());
		od.setEmail("suman@gmail.com");
		od.setUserPhone("89999888888");
		od.setUserId("12546");
		od.setCourseId(UUID.randomUUID().toString());
		return od;
	}
	

}
