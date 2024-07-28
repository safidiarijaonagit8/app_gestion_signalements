package com.example.projet.model;
import java.util.Date;

import javax.persistence.*;

public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id_utilisateur;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "naissance")
	private Date naissance;
	
	@Column(name = "genre")
	private String genre;
	
	
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "mot_de_passe")
	private String motdepasse;

	
	public long getIdUtilisateur() {
		return id_utilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.id_utilisateur = idUtilisateur;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	
	
	

}
