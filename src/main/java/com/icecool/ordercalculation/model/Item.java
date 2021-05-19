package com.icecool.ordercalculation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*  
 * Entity class to represent an item. The following example describes how an Item is made. 
 * For an example, once a Base flavor is combined with a container an item is made. Similarly, once a Base flavor, Condiment, and a Container
 * is combined an item is made. 
 */

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "baseflavor_id", referencedColumnName = "id")
	@JsonIgnoreProperties("hibernateLazyInitializer")
	private BaseFlavor baseFlavor;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "item_condiment",
			joinColumns = @JoinColumn(name = "item_id"),
			inverseJoinColumns = @JoinColumn(name = "condiment_id")
	)
	private List<Condiment> selectedCondiments;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "container_id", referencedColumnName = "id")
	@JsonIgnoreProperties("hibernateLazyInitializer")
	private Container container;

	public Item() {
		
	}
	
	public Item(BaseFlavor baseFlavor, List<Condiment> selectedCondiments, Container container) {
		this.baseFlavor = baseFlavor;
		this.selectedCondiments = selectedCondiments;
		this.container = container;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseFlavor getBaseFlavor() {
		return baseFlavor;
	}

	public void setBaseFlavor(BaseFlavor baseFlavor) {
		this.baseFlavor = baseFlavor;
	}

	public List<Condiment> getSelectedCondiments() {
		return selectedCondiments;
	}

	public void setSelectedCondiments(List<Condiment> selectedCondiments) {
		this.selectedCondiments = selectedCondiments;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}
}
