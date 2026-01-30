package com.lcwd.Order.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderDetail {
	@Id
	private String orderId;
	private String email;
	private String userId;
	private String userPhone;
	private String courseId;
	private boolean orderPaymentStatus=false;
	private boolean orderStatus=false;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public boolean isOrderPaymentStatus() {
		return orderPaymentStatus;
	}
	public void setOrderPaymentStatus(boolean orderPaymentStatus) {
		this.orderPaymentStatus = orderPaymentStatus;
	}
	public boolean isOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	public OrderDetail(String orderId, String email, String userId, String userPhone, String courseId,
			boolean orderPaymentStatus, boolean orderStatus) {
		super();
		this.orderId = orderId;
		this.email = email;
		this.userId = userId;
		this.userPhone = userPhone;
		this.courseId = courseId;
		this.orderPaymentStatus = orderPaymentStatus;
		this.orderStatus = orderStatus;
	}
	public OrderDetail() {
		super();
		
	}
	
}
