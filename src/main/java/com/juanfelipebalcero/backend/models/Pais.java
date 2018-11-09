package com.juanfelipebalcero.backend.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tont_paises")
public class Pais {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdpais;

    private String dsnombre;
    
    private Integer cdzona;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "pais")
    private List<Ave> aves = new ArrayList<>();
    
    public Pais() {
    	super();
    }
    
    public Pais(Integer cdave, String dsnombre) {
		super();
		this.cdpais = cdave;
		this.dsnombre = dsnombre;
	}

	public Integer getCdpais() {
		return cdpais;
	}

	public void setCdpais(Integer cdpais) {
		this.cdpais = cdpais;
	}

	public String getDsnombre() {
		return dsnombre;
	}

	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}
	
	public Integer getCdzona() {
		return cdzona;
	}

	public void setCdzona(Integer cdzona) {
		this.cdzona = cdzona;
	}
	
	public List<Ave> getAves() {
		return aves;
	}

	public void setAves(List<Ave> aves) {
		this.aves = aves;
	}
}