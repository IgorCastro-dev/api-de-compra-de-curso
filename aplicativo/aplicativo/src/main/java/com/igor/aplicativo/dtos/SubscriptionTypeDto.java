package com.igor.aplicativo.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTypeDto {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@Min(value = 1)
	@Max(value = 12)
	private Long accessMonths;
	
	@NotNull
	@Min(value = 0)
	private BigDecimal price;
	
	@NotBlank
	@Size(min = 5,max = 15)
	private String productKey;
}
