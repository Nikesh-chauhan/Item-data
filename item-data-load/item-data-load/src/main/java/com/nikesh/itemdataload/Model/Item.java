package com.nikesh.itemdataload.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
//	@NotNull
//	@NotBlank
	private String name;
	
//	@NotNull
	private String cost;
	
//	@NotNull
//	@NotBlank
	//@NotEmpty
	private Number quantity;
	
//	@NotNull
//	@NotBlank
	//@NotEmpty
	private String pack;
	
	//@Column(columnDefinition="BIGINT")
	private Number contents;
	
//	@NotNull
//	@NotBlank
	//@NotEmpty
	private Number dimensions;
	
//	@NotNull
//	@NotBlank
	private String originLocation;
	
//	@NotNull
//	@NotBlank
	private Boolean ship;
	
	
//	@NotNull
//	@NotBlank
	private String company;
	
	
	
	public Item() {
	super();
}


	public Item(Long id, String name, String cost, Number quantity, String pack, Number contents, Number dimensions,
			String originLocation, Boolean ship, String company) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.pack = pack;
		this.contents = contents;
		this.dimensions = dimensions;
		this.originLocation = originLocation;
		this.ship = ship;
		this.company = company;
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


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public Number getQuantity() {
		return quantity;
	}


	public void setQuantity(Number quantity) {
		this.quantity = quantity;
	}


	public String getPack() {
		return pack;
	}


	public void setPack(String pack) {
		this.pack = pack;
	}


	public Number getContents() {
		return contents;
	}


	public void setContents(Number contents) {
		this.contents = contents.longValue();
	}


	public Number getDimensions() {
		return dimensions;
	}


	public void setDimensions(Number dimensions) {
		this.dimensions = dimensions;
	}


	public String getOriginLocation() {
		return originLocation;
	}


	public void setOriginLocation(String originLocation) {
		this.originLocation = originLocation;
	}


	public Boolean getShip() {
		return ship;
	}


	public void setShip(Boolean ship) {
		this.ship = ship;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}



	

}
