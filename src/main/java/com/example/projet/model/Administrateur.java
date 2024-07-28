package com.example.projet.model;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "administrateur")
public class Administrateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id_adiminstrateur;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "mot_de_passe")
	private String motdepasse;
	
	public Administrateur()
	{
		 
	}

	public Administrateur(long idadministrateur, String username, String motdepasse) {
		super();
		this.username = username;
		this.motdepasse = motdepasse;
	}
		
	public long getIdadministrateur() {
		return id_adiminstrateur;
	}
		
	public void setIdadministrateur(long idadministrateur) {
		this.id_adiminstrateur = idadministrateur;
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
	 
	
	
}
