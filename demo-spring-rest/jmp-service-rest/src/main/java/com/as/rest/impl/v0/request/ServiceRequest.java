package com.as.rest.impl.v0.request;

import lombok.Data;


@Data
public class ServiceRequest {

	private GetAllUsers getAllUsers;
	private GetUserById getUserById;
	private SaveUser saveUser;
	private GetAllSubscriptions getAllSubscriptions;
	private GetSubscriptionById getSubscriptionById;
	private SaveSubscription saveSubscription;
}
