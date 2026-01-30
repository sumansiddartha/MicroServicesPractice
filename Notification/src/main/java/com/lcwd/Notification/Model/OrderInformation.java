package com.lcwd.Notification.Model;

import java.util.Date;

public class OrderInformation {
private String orderId;
private String userId;
private String price;
private String emailId;
private String userPhone;
private Date createdDate;
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public OrderInformation(String orderId, String userId, String price, String emailId, String userPhone,
		Date createdDate) {
	super();
	this.orderId = orderId;
	this.userId = userId;
	this.price = price;
	this.emailId = emailId;
	this.userPhone = userPhone;
	this.createdDate = createdDate;
}
public OrderInformation() {
	super();
		
}




}
