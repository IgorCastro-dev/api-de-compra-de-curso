package com.igor.aplicativo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.igor.aplicativo.dtos.SubscriptionTypeDto;
import com.igor.aplicativo.exception.BadRequestException;
import com.igor.aplicativo.exception.ResourceNotFoundException;
import com.igor.aplicativo.mapper.SubscriptionTypeMapper;
import com.igor.aplicativo.model.SubscriptionsType;
import com.igor.aplicativo.repository.SubscriptionsTypeRepository;
import com.igor.aplicativo.service.SubscriptionTypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService{
	
	private SubscriptionsTypeRepository subscriptionsTypeRepository;

	@Override
	public List<SubscriptionTypeDto> findAll() {
		List<SubscriptionTypeDto> subscriptionTypes;
		subscriptionTypes = subscriptionsTypeRepository.findAll()
														.stream()
														.map((subscriptionType) -> SubscriptionTypeMapper.SubscriptionTypeToDto(subscriptionType))
														.collect(Collectors.toList());
		return subscriptionTypes;
	}

	@Override
	public SubscriptionTypeDto findById(Long id) {
		SubscriptionsType subscriptionType = getSubscriptionType(id);
		return SubscriptionTypeMapper.SubscriptionTypeToDto(subscriptionType);
	}

	@Override
	public SubscriptionTypeDto save(SubscriptionTypeDto subscriptionTypeDto) {
		if(Objects.nonNull(subscriptionTypeDto.getId())) {
			throw new BadRequestException("Id deve ser nulo");
		}
		SubscriptionsType subscriptionsType = saveSubscriptionTypeDto(subscriptionTypeDto);
		return SubscriptionTypeMapper.SubscriptionTypeToDto(subscriptionsType);
	}

	@Override
	public SubscriptionTypeDto update(Long id, SubscriptionTypeDto subscriptionTypeDto) {
		getSubscriptionType(id);
		subscriptionTypeDto.setId(id);
		SubscriptionsType subscriptionsType = saveSubscriptionTypeDto(subscriptionTypeDto);
		return SubscriptionTypeMapper.SubscriptionTypeToDto(subscriptionsType);
	}
	
	@Override
	public Void delete(Long id) {
		getSubscriptionType(id);
		subscriptionsTypeRepository.deleteById(id);
		return null;
	}
	
	private SubscriptionsType getSubscriptionType(Long id) {
		return subscriptionsTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id errado"));
	}
	
	private SubscriptionsType saveSubscriptionTypeDto(SubscriptionTypeDto subscriptionTypeDto) {
		return subscriptionsTypeRepository.save(SubscriptionTypeMapper.SubscriptionTypeToEntity(subscriptionTypeDto));
	}



}
