package com.igor.aplicativo.dtos;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private Long id;
	
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@Size(min = 11)
	private String phone;
	
	@CPF
	private String cpf;
	
	private LocalDate dtSubscription = LocalDate.now();
	
	private LocalDate dtExpiration = LocalDate.now();
	
	@NotNull
	private Long userTypeId;
	
	private Long subscriptionsTypeId;
}
