package com.beanlovesbeer.beerinformation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class BeerInfo {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String manufacturer;
	
	@Column
	private String alcohol;
	
	@Column
	private int invented;

	@Column
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public int getInvented() {
		return invented;
	}

	public void setInvented(int invented) {
		this.invented = invented;
	}

	public BeerInfo(int id, String name, String manufacturer, String alcohol, int invented,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.alcohol = alcohol;
		this.invented = invented;
		this.description = description;
	}

	public BeerInfo() {
	}
	
	
	

}
