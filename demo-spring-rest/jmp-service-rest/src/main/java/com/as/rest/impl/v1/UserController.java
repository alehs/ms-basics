package com.as.rest.impl.v1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.rest.api.UserService;
import com.as.rest.impl.v1.dto.UserControllerRequestDto;
import com.as.rest.impl.v1.dto.UserControllerResponseDto;


@RestController
public class UserController {

	final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/v1/users")
	public UserControllerResponseDto execute(@RequestBody UserControllerRequestDto request) {
		if (request.getMethod() == null)
			throw new IllegalArgumentException("Request method is null");

		switch (request.getMethod()) {
			case "getById":
				return UserControllerResponseDto.of(userService.getById(request.getId()));
			case "save":
				return UserControllerResponseDto.of(userService.save(request.toUserRequest()));
			case "getAll":
				return UserControllerResponseDto.ofAll(userService.getAll());
			// and so on...
			default:
				throw new RuntimeException("Unknown method: " + request.getMethod());
		}
	}

}
