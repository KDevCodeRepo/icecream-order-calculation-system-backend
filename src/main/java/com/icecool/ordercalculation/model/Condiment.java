package com.icecool.ordercalculation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Entity class to represent the IceCool Condiments.
 * 
 * 		- Sprinkles - LKR 50 (Available for Raspberry Slushy and Nutty Fruit only)
 * 		- Toasted Marshmallow - LKR 100 (Available for Raspberry Slushy, Nutty Fruit and Pistachio Delight only)
 * 		- Toasted Almond Flakes - LKR 150 (Available for Nutty Fruit, Coco Coffee and Pistachio Delight only)
 *		- Dash of Peanut butter - LKR 50 per tablespoon of peanut butter (Available for any base flavor)
 *		- Oreo Crumbles - LKR 60 per Oreo cookie (Available for any base flavor)
 * 		- Dried Fruit - Dried Apples - LKR 25, Dried Mango - LKR 30, Dried Apricot - LKR 40, Dried Blueberry - LKR 45
 * 		  (Available for Raspberry Slushy and Nutty Fruit only
*/

@Entity
@Table(name = "condiments")
public class Condiment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "serving_size")
	private String servingSize;
	
	public Condiment() {
		
	}

	public Condiment(String name, String description, String price, String servingSize) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.servingSize = servingSize;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return String.format("LKR %s", price);
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}	
}
