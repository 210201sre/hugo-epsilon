package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventories", schema = "merch_app")
@Data @NoArgsConstructor @AllArgsConstructor
public class Inventory {

	@Id
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name_of_goods")
	@Length(min = 1)
	@NotBlank
	private String nameOfGoods;
	
	@NotBlank
	private int quantity;
}
