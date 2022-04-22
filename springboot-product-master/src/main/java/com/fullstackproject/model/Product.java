package com.fullstackproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(length = 45, nullable = false)
	@Size(max = 45, message = "Name must be maximum of 45 characters.")
	@NotBlank(message = "Name cannot be blank.")
	String name;

	@NotNull
	@ColumnDefault("0")
	@Max(value = 999999999, message= "Invalid quantity.")
	@Min(value = 0, message= "Quantity should be 0 or higher.")
	int quantity;
	
	@Column(length = 45, nullable = false)
	@Size(max = 45, message = "Category must be maximum of 45 characters.")
	@NotBlank(message = "Category cannot be blank.")
	String category;
	
	@NotNull
	@ColumnDefault("0")
	@Max(value = 999999999, message= "Invalid price.")
	@Min(value = 0, message= "price should be 0 or higher.")
	int price;
	
	@Column(length = 45, nullable = false)
	@Size(max = 45, message = "Inventory must be maximum of 45 characters.")
	@NotBlank(message = "Inventory cannot be blank.")
	String inventory;

	public Product() {
		super();
	}

	public Product(String name, String category, int price, int quantity, String inventory) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.inventory = inventory;
		
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the inventory
	 */
	public String getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
