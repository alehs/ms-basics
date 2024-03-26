package com.as.rest.impl.v1.dto;

import lombok.Data;

import java.util.List;

import com.as.rest.dto.UserRequestDto;

@Data
public class UserControllerRequestDto {
	private String method;
	private List<Param> params;
	public UserRequestDto toUserRequest() {
		return new UserRequestDto()
				.id(getId())
				.name(findByName("name", params))
				.birthday(findByName("birthday", params));
	}

	public Long getId() {
		String val = findByName("id", params);
		if (val == null) {
			return null;
		}
		return Long.parseLong(val);
	}

	private String findByName(String name, List<Param> params) {
		return params.stream().filter(p -> p.getName().equals(name)).findFirst().map(p -> p.getValue()).orElse(null);
	}
}
