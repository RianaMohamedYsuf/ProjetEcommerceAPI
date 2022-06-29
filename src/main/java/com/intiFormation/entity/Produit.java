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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduit;
	
	@Column(name="NomProduit")
	private String libProduit;
	
	@Column(name="imageProduit")
	private String img;
	
	@Column(name="quantiteDispo")
	private int quantite;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCate")
	private Categorie categorie;
	
	@OneToMany(mappedBy = "produit", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<LigneCommande> lignecommande;
	
	
	
	public Produit() {
		super();
	}




	public Produit(int idProduit, String libProduit, String img, int quantite, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.libProduit = libProduit;
		this.img = img;
		this.quantite = quantite;
		this.categorie = categorie;
	}


	
	
	public Produit(String libProduit, String img, int quantite) {
		super();
		this.libProduit = libProduit;
		this.img = img;
		this.quantite = quantite;
	}




	public Produit(int idProduit, String libProduit, String img, int quantite) {
		super();
		this.idProduit = idProduit;
		this.libProduit = libProduit;
		this.img = img;
		this.quantite = quantite;
	}
	
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getLibProduit() {
		return libProduit;
	}
	public void setLibProduit(String libProduit) {
		this.libProduit = libProduit;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}




	public List<LigneCommande> getLignecommande() {
		return lignecommande;
	}




	public void setLignecommande(List<LigneCommande> lignecommande) {
		this.lignecommande = lignecommande;
	}
	
	

}
