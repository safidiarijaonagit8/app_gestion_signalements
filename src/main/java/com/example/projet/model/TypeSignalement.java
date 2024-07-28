package com.example.projet.model;
import javax.persistence.*;

public class TypeSignalement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id_type_signalement;

	
	public long getIdTypeSignalement() {
		return id_type_signalement;
	}

	public void setIdTypeSignalement(long idTypeSignalement) {
		this.id_type_signalement = idTypeSignalement;
	}
	@Column(name = "type_signalement")
	private String nomTypeSignalement;

	public String getNomTypeSignalement() {
		return nomTypeSignalement;
	}

	public void setNomTypeSignalement(String nomTypeSignalement) {
		this.nomTypeSignalement = nomTypeSignalement;
	}
	
	@Column(name = "couleur_signalement")
	private String couleurSignalement;
	public String getCouleurSignalement() {
		return couleurSignalement;
	}

	public void setCouleurSignalement(String couleurSignalement) {
		this.couleurSignalement = couleurSignalement;
	}
	

	
}
