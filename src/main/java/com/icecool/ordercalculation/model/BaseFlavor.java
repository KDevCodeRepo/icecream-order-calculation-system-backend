package com.icecool.ordercalculation.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Entity class to represent the IceCool Base flavors. 
 * 
 * 		- Raspberry Slushy - LKR 200 per scoop
 * 		- Coco Coffee - LKR 350 per scoop
 * 		- Nutty Fruit - LKR 150 per scoop
 * 		- Pistachio Delight - LKR 350 per scoop 
 *
*/

@Entity
@Table(name = "baseflavors")
public class BaseFlavor {

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

	public BaseFlavor() {
		
	}

	public BaseFlavor(String name, String description, String price, String servingSize) {
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
