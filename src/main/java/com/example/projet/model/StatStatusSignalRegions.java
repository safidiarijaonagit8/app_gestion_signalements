package com.example.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "v_statGlobalStatut")
@Subselect("select * from v_statGlobalStatut")
public class StatStatusSignalRegions {
	@Id
	
	
	@Column(name = "nbr")
	private int nbr;
	
	@Column(name = "status_signalement")
	private String statussignal;

	public StatStatusSignalRegions()
	{
		
	}
	public StatStatusSignalRegions(int nbr, String statussignal) {
		super();
		this.nbr = nbr;
		this.statussignal = statussignal;
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	public String getStatussignal() {
		return statussignal;
	}
	public void setStatussignal(String statussignal) {
		this.statussignal = statussignal;
	}
}

