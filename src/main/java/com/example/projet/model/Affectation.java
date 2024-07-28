package com.example.projet.model;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

public class Affectation {
	@Id
	private long idAffectation;
	
	private int idSignalement;
	private int idStatusSignalement;
	//private int idRegion;
	private Date dateAffectation;
	private Time heureAffectation;
	
	public Affectation()
	{
		
	}
	
	public Affectation(int idSignalement, int idStatusSignalement,Date dateAffectation, Time heureAffectation) {
		super();
		//this.idAffectation = idAffectation;
		this.idSignalement = idSignalement;
		this.idStatusSignalement = idStatusSignalement;
		//this.idRegion = idRegion;
		this.dateAffectation = dateAffectation;
		this.heureAffectation = heureAffectation;
	}

	public long getIdAffectation() {
		return idAffectation;
	}

	public void setIdAffectation(long idAffectation) {
		this.idAffectation = idAffectation;
	}

	public int getIdSignalement() {
		return idSignalement;
	}

	public void setIdSignalement(int idSignalement) {
		this.idSignalement = idSignalement;
	}

	public int getIdStatusSignalement() {
		return idStatusSignalement;
	}

	public void setIdStatusSignalement(int idStatusSignalement) {
		this.idStatusSignalement = idStatusSignalement;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public Time getHeureAffectation() {
		return heureAffectation;
	}

	public void setHeureAffectation(Time heureAffectation) {
		this.heureAffectation = heureAffectation;
	}
}
