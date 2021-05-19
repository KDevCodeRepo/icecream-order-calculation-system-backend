package com.icecool.ordercalculation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Entity class to represent the IceCool Containers. 
 * 
 * 		- Wafer cone - LKR 20
 * 		- Waffle cone - LKR 40
 * 		- Waffle bowl - LKR 50
 * 		- Ice cream sandwich wafers - Price not given, hence it's assumed that this Container is worth a price of LKR 80 
*/

@Entity
@Table(name = "containers")
public class Container {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private String price;
	
	public Container() {
		
	}
	
	public Container(String name, String description, String price) {
		this.name = name;
		this.description = description;
		this.price = price;
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
}
