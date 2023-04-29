package com.igor.aplicativo.service;

import com.igor.aplicativo.dtos.UserDto;
import com.igor.aplicativo.model.User;

public interface UserService {
	User save(UserDto userDto);
}
