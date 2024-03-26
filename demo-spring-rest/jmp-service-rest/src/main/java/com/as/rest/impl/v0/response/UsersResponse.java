package com.as.rest.impl.v0.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.as.rest.dto.UserResponseDto;

@Data
@Builder
public class UsersResponse extends ServiceResponse {
	private List<UserResponseDto> data;
}
