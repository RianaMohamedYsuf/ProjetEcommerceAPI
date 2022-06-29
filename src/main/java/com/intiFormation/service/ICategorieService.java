package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Categorie;

public interface ICategorieService {

	public void ajouter(Categorie c);
	public void supprimer(int idCat);
	public void modifier(Categorie c);
	public List<Categorie> getAll();
	public String getNomCat(int idCat);
	public Optional<Categorie> getById(int idCat);
	
}
