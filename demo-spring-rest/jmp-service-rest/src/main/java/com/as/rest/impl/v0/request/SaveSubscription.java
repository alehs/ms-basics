package com.as.rest.impl.v0.request;

import lombok.Data;

import com.as.rest.dto.SubscriptionRequestDto;
import com.as.rest.dto.SubscriptionResponseDto;

@Data
public class SaveSubscription {
	private Long id;
	private Long userId;

	public SubscriptionRequestDto toSubscriptionRequest() {
		return new SubscriptionRequestDto().id(id).userId(userId);
	}
}
