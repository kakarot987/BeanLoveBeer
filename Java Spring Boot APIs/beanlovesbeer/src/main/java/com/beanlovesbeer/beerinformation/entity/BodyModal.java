package com.beanlovesbeer.beerinformation.entity;

public class BodyModal {

	public int id;
    public String name;
    public String manufacturer;
	public String alcohol;
	public int invented;
	public String description;
	public BodyModal(int id, String name, String manufacturer, String alcohol, int invented,String description) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.alcohol = alcohol;
		this.invented = invented;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
