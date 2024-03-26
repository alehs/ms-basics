package com.as.rest.impl.v1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.as.rest.dto.UserResponseDto;

@Data
@Builder
public class UserControllerResponseDto {

	private List<UserResponseDto> data;

	public static UserControllerResponseDto of(UserResponseDto user) {
		var builder = UserControllerResponseDto.builder();
		if (user != null) {
			builder.data(List.of(user));
		}
		return builder.build();
	}

	public static UserControllerResponseDto ofAll(List<UserResponseDto> all) {
		return UserControllerResponseDto.builder()
				.data(all)
				.build();
	}
}
