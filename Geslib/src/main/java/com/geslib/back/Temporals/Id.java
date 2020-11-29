package com.geslib.back.Temporals;

import java.io.Serializable;

public class Id implements Serializable{
	private int id;
	public Id() {
		
	}
	public Id(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
