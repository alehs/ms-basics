package com.as.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.as.rest.domain.User;
import com.as.rest.dto.UserResponseDto;

@Component
public class UserResponseConverter implements Converter<User, UserResponseDto> {
	@Override
	public UserResponseDto convert(User source) {
		return new UserResponseDto().id(source.getId()).name(source.getName()).surname(source.getSurname())
				.birthday(source.getBirthDate() == null ? null : source.getBirthDate().toString());
	}
}
