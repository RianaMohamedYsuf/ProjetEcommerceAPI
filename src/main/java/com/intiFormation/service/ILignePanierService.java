package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.LignePanier;

public interface ILignePanierService {

	public void ajouter(LignePanier lp);
	
	public List<LignePanier> getAll();
	
	public LignePanier getLignePanierByIdProd(int id);
	
	public void supprimer(int id);
	
	public Optional<LignePanier> getById(int id);
	
	public void suppimerTT();
}
