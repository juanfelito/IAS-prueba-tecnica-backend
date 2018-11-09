package com.juanfelipebalcero.backend.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tont_aves")
public class Ave {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdave;

    private String dsnombre_comun;

    private String dsnombre_cientifico;
    
    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "tont_aves_pais",
    		joinColumns = @JoinColumn(name = "aves_cdave"),
    	    inverseJoinColumns = @JoinColumn(name = "pais_cdpais"))
    private List<Pais> pais = new ArrayList<>();
    
    public Ave() {
    	super();
    }
    
    public Ave(Integer cdave, String dsnombre_comun, String dsnombre_cientifico) {
		super();
		this.cdave = cdave;
		this.dsnombre_comun = dsnombre_comun;
		this.dsnombre_cientifico = dsnombre_cientifico;
	}

	public Integer getCdave() {
		return cdave;
	}

	public void setCdave(Integer cdave) {
		this.cdave = cdave;
	}

	public String getDsnombre_comun() {
		return dsnombre_comun;
	}

	public void setDsnombre_comun(String dsnombre_comun) {
		this.dsnombre_comun = dsnombre_comun;
	}

	public String getDsnombre_cientifico() {
		return dsnombre_cientifico;
	}

	public void setDsnombre_cientifico(String dsnombre_cientifico) {
		this.dsnombre_cientifico = dsnombre_cientifico;
	}
	
	public List<Pais> getPais() {
		return pais;
	}

	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}
}