package com.as.rest.impl.v0;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.rest.api.SubscriptionService;
import com.as.rest.api.UserService;
import com.as.rest.impl.v0.request.ServiceRequest;
import com.as.rest.impl.v0.response.ServiceResponse;
import com.as.rest.impl.v0.response.SubscriptionsResponse;
import com.as.rest.impl.v0.response.UsersResponse;

@RestController()
public class ServiceController {

	@Autowired
	SubscriptionService subscriptionService;

	@Autowired
	UserService userService;

	@PostMapping("/v0/service")
	public ServiceResponse execute(@RequestBody ServiceRequest request) {

		if (request.getGetAllUsers() != null) {
			return UsersResponse.builder().data(userService.getAll()).build();
		} else if (request.getGetUserById() != null) {
			return UsersResponse.builder().data(
					Arrays.asList(userService.getById(request.getGetUserById().getId()))).build();
		} else if (request.getSaveUser() != null) {
			return UsersResponse.builder().data(
					Arrays.asList(userService.save(request.getSaveUser().toUserRequest()))).build();
		} else if (request.getGetAllSubscriptions() != null) {
			return SubscriptionsResponse.builder().data(subscriptionService.getAll()).build();
		} else if (request.getGetSubscriptionById() != null) {
			return SubscriptionsResponse.builder().data(
					Arrays.asList(subscriptionService.getById(request.getGetSubscriptionById().getId()))).build();
		} else if (request.getSaveSubscription() != null) {
			return SubscriptionsResponse.builder().data(
					Arrays.asList(subscriptionService.save(request.getSaveSubscription().toSubscriptionRequest()))).build();
		}
		else {
			throw new IllegalArgumentException("Unknown request: " + request);
		}
	}

}
