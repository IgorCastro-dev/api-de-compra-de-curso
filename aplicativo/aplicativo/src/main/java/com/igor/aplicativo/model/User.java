package com.igor.aplicativo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "users_id")
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String cpf;
	@Column(name = "dt_subscription")
	private LocalDate dtSubscription = LocalDate.now();
	@Column(name = "dt_expiration")
	private LocalDate dtExpiration;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type_id")
	private UserType userType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscriptions_type_id")
	private SubscriptionsType subscriptionsType;
}
