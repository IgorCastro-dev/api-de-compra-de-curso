package com.igor.aplicativo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErroDetails {
	private String message;
	private LocalDateTime timesTamp;
	private String path;
	private HttpStatus erroCode;
}
