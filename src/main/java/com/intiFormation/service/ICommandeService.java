package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Commande;

public interface ICommandeService {

	public void ajouter(Commande c);
	
	public Optional<Commande> getById (int id);
	
	public void supprimer(int id);
	
	public void modifier(Commande c);
	
	public List<Commande> getAll();
	
	public List<Commande> getAllByUserId(int id);
	
}
