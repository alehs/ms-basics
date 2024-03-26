package com.as.rest.api;

import java.util.List;

import com.as.rest.dto.SubscriptionRequestDto;
import com.as.rest.dto.SubscriptionResponseDto;

public interface SubscriptionService {

	SubscriptionResponseDto getById(Long id);
	SubscriptionResponseDto save(SubscriptionRequestDto subscription);
	List<SubscriptionResponseDto> getAll();

	List<SubscriptionResponseDto> getByUserId(Long userId);
}
