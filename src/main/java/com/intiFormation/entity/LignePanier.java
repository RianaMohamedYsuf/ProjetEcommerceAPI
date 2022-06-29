package com.intiFormation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LignePanier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int idLignePanier;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idPanier")
	private Panier panier;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idProduit")
	private Produit produit;
	
	private int  quantite;
	
	
	
	
	
	public LignePanier() {
		super();
	}
	public int getIdLignePanier() {
		return idLignePanier;
	}
	public void setIdLignePanier(int idLignePanier) {
		this.idLignePanier = idLignePanier;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "LignePanier [idLignePanier=" + idLignePanier + ", panier=" + panier.getIdPanier() + ", produit=" + produit.getLibProduit()
				+ ", quantite=" + quantite + "]";
	}
	
	
	
	
}
