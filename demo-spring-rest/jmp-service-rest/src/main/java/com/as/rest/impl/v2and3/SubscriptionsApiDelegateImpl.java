package com.as.rest.impl.v2and3;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.as.rest.api.SubscriptionService;
import com.as.rest.api.SubscriptionsApiDelegate;
import com.as.rest.dto.SubscriptionRequestDto;
import com.as.rest.dto.SubscriptionResponseDto;

@Component
public class SubscriptionsApiDelegateImpl implements SubscriptionsApiDelegate {

	private final SubscriptionService service;

	public SubscriptionsApiDelegateImpl(SubscriptionService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<SubscriptionResponseDto> getSubscription(Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@Override
	public ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions() {
		return ResponseEntity.ok(service.getAll());
	}

	@Override
	public ResponseEntity<SubscriptionResponseDto> createSubscription(SubscriptionRequestDto body) {
		SubscriptionResponseDto saved = service.save(body);
		return ResponseEntity.created(URI.create("/subscriptions/" + saved.getId())).body(saved);
	}

	@Override
	public ResponseEntity<SubscriptionResponseDto> updateSubscription(Long id, SubscriptionRequestDto body) {
		return ResponseEntity.ok(service.save(body));
	}
}
