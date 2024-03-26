package com.as.rest.converter;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.as.rest.domain.Subscription;
import com.as.rest.domain.User;
import com.as.rest.dto.SubscriptionRequestDto;
import com.as.rest.repository.UserRepository;

@Component
public class SubscriptionRequestConverter implements Converter<SubscriptionRequestDto, Subscription> {
	private final UserRepository userRepo;

	public SubscriptionRequestConverter(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public Subscription convert(SubscriptionRequestDto source) {
		User user = userRepo.findById(source.getUserId()).orElse(null);
		return new Subscription(source.getId(), user, LocalDate.now());
	}
}
