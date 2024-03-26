package com.as.rest.impl.v1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.rest.api.SubscriptionService;
import com.as.rest.impl.v1.dto.SubscriptionControllerRequestDto;
import com.as.rest.impl.v1.dto.SubscriptionControllerResponseDto;

@RestController
public class SubscriptionController {

	final SubscriptionService service;

	public SubscriptionController(SubscriptionService service) {
		this.service = service;
	}

	@PostMapping("/v1/subscriptions")
	public SubscriptionControllerResponseDto execute(@RequestBody SubscriptionControllerRequestDto request) {
		if (request.getMethod() == null)
			throw new IllegalArgumentException("Request method is null");

		switch (request.getMethod()) {
			case "getById":
				return SubscriptionControllerResponseDto.of(service.getById(request.getId()));
			case "save":
				return SubscriptionControllerResponseDto.of(service.save(request.toSubscriptionRequest()));
			case "getAll":
				return SubscriptionControllerResponseDto.ofAll(service.getAll());
			// and so on...
			default:
				throw new RuntimeException("Unknown method: " + request.getMethod());
		}
	}
}
