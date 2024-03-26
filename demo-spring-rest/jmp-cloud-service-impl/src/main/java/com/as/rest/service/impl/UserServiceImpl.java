package com.as.rest.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.as.rest.api.UserService;
import com.as.rest.domain.User;
import com.as.rest.dto.UserRequestDto;
import com.as.rest.dto.UserResponseDto;
import com.as.rest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private ConversionService conversionService;

	@Override
	public UserResponseDto getById(Long id) {
		return repo.findById(id).map(u -> conversionService.convert(u, UserResponseDto.class)).orElse(null);
	}

	@Override
	public UserResponseDto save(UserRequestDto userDto) {
		User saved = repo.save(conversionService.convert(userDto, User.class));
		return conversionService.convert(saved, UserResponseDto.class);
	}

	@Override
	public List<UserResponseDto> getAll() {
		TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
		TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserResponseDto.class));
		return (List<UserResponseDto>) conversionService.convert(repo.findAll(), sourceType, targetType);

//		return StreamSupport.stream(repo.findAll().spliterator(), false)
//				.map(u -> conversionService.convert(u, UserResponseDto.class))
//				.collect(Collectors.toList());
	}
}
