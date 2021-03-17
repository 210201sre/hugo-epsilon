package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", schema = "merch_app")
@Data @NoArgsConstructor @AllArgsConstructor	// Check if needed
public class User {

	@Id
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "merch_name")
	private String merchName;
	
	@Length(min = 5)
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-A0-9]*")
	private String username;
	
	@Length(min = 5)
	@NotBlank
	private String password;
	
	@NotBlank
	@Enumerated (EnumType.STRING)
	private Role role;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<Inventory> inventories;
}
