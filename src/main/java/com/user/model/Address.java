package com.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
@Builder
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "address_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;

	@Column(name = "street")
	private String streetName;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "postcode")
	private Long postcode;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")	
	private User user;	
}
