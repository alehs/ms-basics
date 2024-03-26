package com.as.rest.converter;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.as.rest.dto.SubscriptionResponseDto;
import com.as.rest.domain.Subscription;

@Component
public class SubscriptionResponseConverter implements Converter<Subscription, SubscriptionResponseDto> {
	@Override
	public SubscriptionResponseDto convert(Subscription source) {
		return new SubscriptionResponseDto().id(source.getId())
				.userId(Optional.ofNullable(source.getUser()).map(u -> u.getId()).orElse(null))
				.startDate(Optional.ofNullable(source.getStartDate()).map(d -> d.toString()).orElse(null));
	}
}
