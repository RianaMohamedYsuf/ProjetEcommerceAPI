package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Produit;

public interface IProduitService {

	public void ajouter(Produit p);
	public void supprimer(int idProduit);
	public void modifier(Produit p);
	public List<Produit> getByCat(int idcat);
	public Optional<Produit> getById(int idProduit);
	public List<Produit> getAll();
	public List<Produit> getByName(String libProduit);

	
}
