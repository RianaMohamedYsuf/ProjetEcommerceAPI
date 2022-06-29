package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUtilisateur")
	private int id;
	
	@Column(name="nomUtilisateur")
	private String nom;
	
	@Column(name="prenomUtilisateur")
	private String prenom;
	
	private String dateNaissance;
	private String login;
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idRole")
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
			mappedBy = "user")
	private List<Commande> commandes;
	
	
	


	public Utilisateur(int id, String nom, String prenom, String dateNaissance, String login, String password,
			Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.login = login;
		this.password = password;
		this.role = role;
	}



	public Utilisateur() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	public String getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	
	



	public List<Commande> getCommandes() {
		return commandes;
	}



	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}



	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", login=" + login + ", password=" + password + ", role=" + role.getLibrole() + "]";
	}
	
	
	
	
	
	
	
	
	

}
