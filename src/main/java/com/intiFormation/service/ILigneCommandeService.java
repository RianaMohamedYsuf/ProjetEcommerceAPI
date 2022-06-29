package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.LigneCommande;

public interface ILigneCommandeService {

	public void ajouter(LigneCommande lc);
	
	public Optional<LigneCommande> getById (int id);
	
	public void supprimer(int id);
	
	public void modifier(LigneCommande lc);
	
	public List<LigneCommande> getAll();
	
	public List<LigneCommande> getByIdCommande (int id);
	
	
}
