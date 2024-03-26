package com.as.rest.impl.v0.request;

import lombok.Data;

import com.as.rest.dto.UserRequestDto;

@Data
public class SaveUser {
	private Long id;
	private String name;
	private String surname;
	private String birthday;

	public UserRequestDto toUserRequest() {
		return new UserRequestDto()
				.id(id)
				.name(name)
				.surname(surname)
				.birthday(birthday);
	}
}
