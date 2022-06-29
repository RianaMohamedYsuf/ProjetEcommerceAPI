package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	
	@Column(name = "libRole")
	private String librole;
	
	@Column(name = "Description")
	private String description;
	
	@OneToMany(mappedBy = "role")
	private List<Utilisateur> utilisateur;
	
	
	
	
	
	
	public Role() {
		super();
	}



	public Role(int idRole, String librole, String description) {
		super();
		this.idRole = idRole;
		this.librole = librole;
		this.description = description;
	}
	
	
	
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getLibrole() {
		return librole;
	}
	public void setLibrole(String librole) {
		this.librole = librole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	public List<Utilisateur> getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}



	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", librole=" + librole + ", description=" + description + "]";
	}



	
	

}
