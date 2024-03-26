package com.as.rest.converter;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.as.rest.domain.User;
import com.as.rest.dto.UserRequestDto;

@Component
public class UserRequestConverter implements Converter<UserRequestDto, User> {
	@Override
	public User convert(UserRequestDto source) {
		return new User(source.getId(), source.getName(), source.getSurname(),
				Optional.ofNullable(source.getBirthday()).map(d -> LocalDate.parse(d)).orElse(null));
	}
}
