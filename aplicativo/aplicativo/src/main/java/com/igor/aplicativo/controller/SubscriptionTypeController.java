package com.igor.aplicativo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.igor.aplicativo.dtos.SubscriptionTypeDto;
import com.igor.aplicativo.service.SubscriptionTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subscription-type")
@AllArgsConstructor
public class SubscriptionTypeController {
	
	private SubscriptionTypeService subscriptionTypeService;
	
	@GetMapping
	public ResponseEntity<List<SubscriptionTypeDto>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findAll());		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubscriptionTypeDto> findById(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findById(id));		
	}
	
	@PostMapping
	public ResponseEntity<SubscriptionTypeDto> save(@Valid @RequestBody SubscriptionTypeDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.save(dto));		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SubscriptionTypeDto> update(@PathVariable("id") Long id,@RequestBody SubscriptionTypeDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.update(id,dto));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		subscriptionTypeService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");		
	}
}
