package com.example.projet.model;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
@Entity
@Immutable
@Table(name = "v_detailsignal")
@Subselect("select * from v_detailsignal")
public class SignalementDetail {
	
	@Id
	@Column(name = "id_signalement")
	private int idsignalement;
	
	@Column(name = "type_signalement")
	private String nomTypeSignalement;
	
	@Column(name = "nom_region")
	private String nomRegion;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	

	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "description_signal")
	private String descriptionsignal;
	
	@Column(name = "date_signal")
	private Date datesignalement;
	
	@Column(name = "heure_signal")
	private Time heuresignalement;

	public SignalementDetail()
	{
		
	}
	public SignalementDetail(int idsignalement, String nomTypeSignalement, String nomRegion, String nom, String prenom,
			 double longitude, double latitude, String descriptionsignal, Date datesignalement,
			Time heuresignalement) {
		super();
		this.idsignalement = idsignalement;
		this.nomTypeSignalement = nomTypeSignalement;
		this.nomRegion = nomRegion;
		this.nom = nom;
		this.prenom = prenom;
	
		this.longitude = longitude;
		this.latitude = latitude;
		this.descriptionsignal = descriptionsignal;
		this.datesignalement = datesignalement;
		this.heuresignalement = heuresignalement;
	}

   public int getIdsignalement() {
		return idsignalement;
	}

	public void setIdsignalement(int idSignalement) {
		this.idsignalement = idSignalement;
	}

	public String getNomTypeSignalement() {
		return nomTypeSignalement;
	}

	public void setNomTypeSignalement(String nomTypeSignalement) {
		this.nomTypeSignalement = nomTypeSignalement;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	public String getDescriptionsignal() {
		return descriptionsignal;
	}
	public void setDescriptionsignal(String descriptionsignal) {
		this.descriptionsignal = descriptionsignal;
	}
	public Date getDatesignalement() {
		return datesignalement;
	}
	public void setDatesignalement(Date datesignalement) {
		this.datesignalement = datesignalement;
	}
	public Time getHeuresignalement() {
		return heuresignalement;
	}
	public void setHeuresignalement(Time heuresignalement) {
		this.heuresignalement = heuresignalement;
	}


	

	

	

}
