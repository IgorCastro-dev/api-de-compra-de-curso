package com.igor.aplicativo.mapper;

import com.igor.aplicativo.dtos.UserDto;
import com.igor.aplicativo.model.User;
import com.igor.aplicativo.model.UserType;

public class UserMapper {
	
	public static User userDtoToEntity(UserDto userDto,UserType userType) {
		User user = User.builder()
						.id(userDto.getId())
						.name(userDto.getName())
						.email(userDto.getEmail())
						.phone(userDto.getPhone())
						.cpf(userDto.getCpf())
						.dtSubscription(userDto.getDtSubscription())
						.dtExpiration(userDto.getDtExpiration())
						.userType(userType)
						.subscriptionsType(null)
						.build();
		return user;
	}
	
	public static UserDto userToDto(User user,UserType userType) {
		UserDto userDto = UserDto.builder()
						.id(user.getId())
						.name(user.getName())
						.email(user.getEmail())
						.phone(user.getPhone())
						.cpf(user.getCpf())
						.dtSubscription(user.getDtSubscription())
						.dtExpiration(user.getDtExpiration())
						.userTypeId(userType.getId())
						.subscriptionsTypeId(userType.getId())
						.build();
		return userDto;
	}

}
