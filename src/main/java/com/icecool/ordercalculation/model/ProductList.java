package com.icecool.ordercalculation.model;

import java.util.List;

/* 
 * This class is based on the logic that Base Flavors, Condiments, Containers are considered as individual products. 
 * An item will be made by combining these products. 
 * For an example, once a Base flavor is combined with a container an item is made. Similarly, once a Base flavor, Condiment, and a Container
 * is combined an item is made. 
 */


public class ProductList {
	
	private List<BaseFlavor> baseFlavors;
	private List<Condiment> condiments;
	private List<Container> container;
	
	public ProductList() {
		
	}
	
	public ProductList(List<BaseFlavor> baseFlavors, List<Condiment> condiments, List<Container> container) {
		this.baseFlavors = baseFlavors;
		this.condiments = condiments;
		this.container = container;
	}

	public List<BaseFlavor> getBaseFlavors() {
		return baseFlavors;
	}

	public void setBaseFlavors(List<BaseFlavor> baseFlavors) {
		this.baseFlavors = baseFlavors;
	}

	public List<Condiment> getCondiments() {
		return condiments;
	}

	public void setCondiments(List<Condiment> condiments) {
		this.condiments = condiments;
	}

	public List<Container> getContainer() {
		return container;
	}

	public void setContainer(List<Container> container) {
		this.container = container;
	}
}
