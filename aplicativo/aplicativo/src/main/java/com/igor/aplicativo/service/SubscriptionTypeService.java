package com.igor.aplicativo.service;

import java.util.List;

import com.igor.aplicativo.dtos.SubscriptionTypeDto;

public interface SubscriptionTypeService {
	List<SubscriptionTypeDto> findAll();
	
	SubscriptionTypeDto findById(Long id);
	
	SubscriptionTypeDto save(SubscriptionTypeDto subscriptionTypeDto);
	
	SubscriptionTypeDto update(Long id,SubscriptionTypeDto subscriptionTypeDto);
	
	Void delete(Long id);
}
