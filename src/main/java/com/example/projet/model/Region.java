package com.example.projet.model;
import javax.persistence.*;

@Entity
@Table(name = "region")
public class Region {
	
	@Id
	@Column(name = "id_region")
	private long idRegion;
	
	@Column(name = "id_chef_de_region")
	private int idChefDeRegion;
	
	@Column(name = "nom_region")
	private String nomRegion;

	
	
	
	public Region() {
		
	}

	public Region(long idRegion, int idChefDeRegion, String nomRegion) {
		super();
		this.idRegion = idRegion;
		this.idChefDeRegion = idChefDeRegion;
		this.nomRegion = nomRegion;
	}

	public int getIdChefDeRegion() {
		return idChefDeRegion;
	}

	public long getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(long idRegion) {
		this.idRegion = idRegion;
	}

	public void setIdChefDeRegion(int idChefDeRegion) {
		this.idChefDeRegion = idChefDeRegion;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
}
