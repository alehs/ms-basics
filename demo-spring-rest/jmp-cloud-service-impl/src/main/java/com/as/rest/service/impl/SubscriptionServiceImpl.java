package com.as.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.as.rest.api.SubscriptionService;
import com.as.rest.api.UserService;
import com.as.rest.domain.Subscription;
import com.as.rest.dto.SubscriptionRequestDto;
import com.as.rest.dto.SubscriptionResponseDto;
import com.as.rest.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	private final SubscriptionRepository repo;
	private final ConversionService conversionService;

	public SubscriptionServiceImpl(SubscriptionRepository repo, ConversionService conversionService) {
		this.repo = repo;
		this.conversionService = conversionService;
	}

	@Override
	public SubscriptionResponseDto getById(Long id) {
		return repo.findById(id).map(s -> conversionService.convert(s, SubscriptionResponseDto.class)).orElse(null);
	}

	@Override
	public SubscriptionResponseDto save(SubscriptionRequestDto subscription) {
		Subscription saved = repo.save(conversionService.convert(subscription, Subscription.class));
		return conversionService.convert(saved, SubscriptionResponseDto.class);
	}

	@Override
	public List<SubscriptionResponseDto> getAll() {
		return (List<SubscriptionResponseDto>) conversionService.convert(repo.findAll(), List.class);
	}

	@Override
	public List<SubscriptionResponseDto> getByUserId(Long userId) {
		return (List<SubscriptionResponseDto>) conversionService.convert(repo.findAllByUserId(userId), List.class);
	}
}
