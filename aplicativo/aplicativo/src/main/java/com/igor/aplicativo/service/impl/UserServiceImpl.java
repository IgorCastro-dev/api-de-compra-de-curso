package com.igor.aplicativo.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.igor.aplicativo.dtos.UserDto;
import com.igor.aplicativo.exception.BadRequestException;
import com.igor.aplicativo.exception.ResourceNotFoundException;
import com.igor.aplicativo.mapper.UserMapper;
import com.igor.aplicativo.model.User;
import com.igor.aplicativo.model.UserType;
import com.igor.aplicativo.repository.UserRepository;
import com.igor.aplicativo.repository.UserTypeRepository;
import com.igor.aplicativo.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	private UserTypeRepository userTypeRepository;
	

	@Override
	public User save(UserDto userDto) {
		if(Objects.nonNull(userDto.getId())) {
			throw new BadRequestException("Id tem que ser nulo");
		}		
		UserType userType = userTypeRepository.findById(userDto.getUserTypeId()).orElseThrow(() -> new ResourceNotFoundException("UserType com id errado"));
		
		return userRepository.save(UserMapper.userDtoToEntity(userDto, userType));
	}

}
