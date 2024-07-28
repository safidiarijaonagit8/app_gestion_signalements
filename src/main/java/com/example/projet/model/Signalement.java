package com.example.projet.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.projet.repository.SignalementRepository;

@Entity
@Table(name = "signalement")
public class Signalement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id_signalement;
	
	@Column(name = "id_type_signalement")
	private int idtypesignalement;
	
	@Column(name = "id_region")
	private int idregion;
	

	@Column(name = "id_utilisateur")
	private int idutilisateur;
	
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
	
	
	public Signalement()
	{
		
	}

	public Signalement(long idsignalement, int idtypesignalement, int idregion, int idutilisateur, double longitude,
			double latitude, String descriptionsignal, Date datesignalement, Time heuresignalement) {
		super();
		this.id_signalement = idsignalement;
		this.idtypesignalement = idtypesignalement;
		this.idregion = idregion;
		this.idutilisateur = idutilisateur;
		this.longitude = longitude;
		this.latitude = latitude;
		this.descriptionsignal = descriptionsignal;
		this.datesignalement = datesignalement;
		this.heuresignalement = heuresignalement;
	}

	public long getIdsignalement() {
		return id_signalement;
	}

	public void setIdsignalement(long idsignalement) {
		this.id_signalement = idsignalement;
	}

	public int getIdtypesignalement() {
		return idtypesignalement;
	}

	public void setIdtypesignalement(int idtypesignalement) {
		this.idtypesignalement = idtypesignalement;
	}

	public int getIdregion() {
		return idregion;
	}

	public void setIdregion(int idregion) {
		this.idregion = idregion;
	}

	public int getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
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
