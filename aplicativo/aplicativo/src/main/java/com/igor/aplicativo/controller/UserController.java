package com.igor.aplicativo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.aplicativo.dtos.UserDto;
import com.igor.aplicativo.model.User;
import com.igor.aplicativo.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> save(@Valid @RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
	}
}
