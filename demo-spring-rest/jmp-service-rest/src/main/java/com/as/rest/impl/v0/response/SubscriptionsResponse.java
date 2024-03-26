package com.as.rest.impl.v0.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.as.rest.dto.SubscriptionResponseDto;

@Data
@Builder
public class SubscriptionsResponse extends ServiceResponse {
	private List<SubscriptionResponseDto> data;
}
