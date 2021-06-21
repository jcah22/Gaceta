package com.jcah.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	private long id_area;
	
	private String nombre_area;
	
	
	
	public long getId_area() {
		return id_area;
	}
	public void setId_area(long id_area) {
		this.id_area = id_area;
	}
	public String getNombre_area() {
		return nombre_area;
	}
	public void setNombre_area(String nombre_area) {
		this.nombre_area = nombre_area;
	}
	@Override
	public String toString() {
		return "Area [id_area=" + id_area + ", nombre_area=" + nombre_area + "]";
	}
	
	
	

}
