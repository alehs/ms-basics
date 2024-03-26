package com.as.rest.api;


import java.util.List;

import com.as.rest.dto.UserRequestDto;
import com.as.rest.dto.UserResponseDto;

public interface UserService {
	UserResponseDto getById(Long id);
	UserResponseDto save(UserRequestDto user);
	List<UserResponseDto> getAll();
}
