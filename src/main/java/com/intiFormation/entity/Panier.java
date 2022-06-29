package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPanier;
	
	@JsonIgnore
	@OneToMany(mappedBy = "panier")
	private List<LignePanier> lignePaniers;
	
	
	
	
	
	public Panier() {
		super();
	}
	public int getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	
	
	public List<LignePanier> getLignePaniers() {
		return lignePaniers;
	}
	public void setLignePaniers(List<LignePanier> lignePaniers) {
		this.lignePaniers = lignePaniers;
	}
	
	
	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", lignePaniers=" + lignePaniers + "]";
	}
	
	
	

}
