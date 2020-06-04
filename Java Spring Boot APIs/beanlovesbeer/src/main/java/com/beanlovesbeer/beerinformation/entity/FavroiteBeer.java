package com.beanlovesbeer.beerinformation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavroiteBeer {

	@Id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FavroiteBeer(int id) {
		super();
		this.id = id;
	}

	public FavroiteBeer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
