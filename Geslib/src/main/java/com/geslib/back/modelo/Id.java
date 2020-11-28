package com.geslib.back.modelo;

import java.io.Serializable;

public class Id implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Id() {
	
}
public Id(int id) {
	this.id = id;
}

}
