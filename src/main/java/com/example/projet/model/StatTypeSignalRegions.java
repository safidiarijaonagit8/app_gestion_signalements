package com.example.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "v_stattyperegion")
@Subselect("select * from v_stattyperegion")
public class StatTypeSignalRegions {
	@Id
	
	
	@Column(name = "nbr")
	private int nbr;
	
	@Column(name = "type_signalement")
	private String nomTypeSignalement;

	public StatTypeSignalRegions()
	{
		
	}
	
	public StatTypeSignalRegions(int nbr, String nomTypeSignalement) {
		super();
		this.nbr = nbr;
		this.nomTypeSignalement = nomTypeSignalement;
	}


	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public String getNomTypeSignalement() {
		return nomTypeSignalement;
	}

	public void setNomTypeSignalement(String nomTypeSignalement) {
		this.nomTypeSignalement = nomTypeSignalement;
	}
	
	

}
