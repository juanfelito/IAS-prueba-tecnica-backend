package com.juanfelipebalcero.backend.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tont_paises")
public class Pais {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdpais;

    private String dsnombre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "cdzona")
    private Zona cdzona;
    
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
	
	public Zona getCdzona() {
		return cdzona;
	}

	public void setCdzona(Zona cdzona) {
		this.cdzona = cdzona;
	}
}