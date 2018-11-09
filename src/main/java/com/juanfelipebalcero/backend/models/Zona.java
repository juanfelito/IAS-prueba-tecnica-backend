package com.juanfelipebalcero.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tont_zonas")
public class Zona {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdzona;

    private String dsnombre;
    
    public Zona() {
    	super();
    }
    
    public Zona(Integer cdzona, String dsnombre) {
		super();
		this.cdzona = cdzona;
		this.dsnombre = dsnombre;
	}

	public Integer getCdzona() {
		return cdzona;
	}

	public void setCdzona(Integer cdzona) {
		this.cdzona = cdzona;
	}

	public String getDsnombre() {
		return dsnombre;
	}

	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}
}