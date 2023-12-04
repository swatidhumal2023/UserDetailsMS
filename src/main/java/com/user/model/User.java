package com.user.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
@Builder
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public User(Long id, String title, String firstName, String lastName, String gender, String employeeId) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.employeeId = employeeId;
	}

	@Column(name = "title")
	private String title;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;	
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "emp_id")
	private String employeeId;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Address> customerAddresses;	
}
