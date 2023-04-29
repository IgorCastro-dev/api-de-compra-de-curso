package com.igor.aplicativo.mapper;

import com.igor.aplicativo.dtos.SubscriptionTypeDto;
import com.igor.aplicativo.model.SubscriptionsType;

public class SubscriptionTypeMapper {
	public static SubscriptionTypeDto SubscriptionTypeToDto(SubscriptionsType subscriptionsType) {
		SubscriptionTypeDto subscriptionTypeDto = SubscriptionTypeDto.builder()
																	.id(subscriptionsType.getId())
																	.name(subscriptionsType.getName())
																	.accessMonths(subscriptionsType.getAccessMonths())
																	.price(subscriptionsType.getPrice())
																	.productKey(subscriptionsType.getProductKey())
																	.build();
		return subscriptionTypeDto;
	}
	
	public static SubscriptionsType SubscriptionTypeToEntity(SubscriptionTypeDto subscriptionTypeDto) {
		SubscriptionsType subscriptionsType = SubscriptionsType.builder()
																	.id(subscriptionTypeDto.getId())
																	.name(subscriptionTypeDto.getName())
																	.accessMonths(subscriptionTypeDto.getAccessMonths())
																	.price(subscriptionTypeDto.getPrice())
																	.productKey(subscriptionTypeDto.getProductKey())
																	.build();
		return subscriptionsType;
	}
}
