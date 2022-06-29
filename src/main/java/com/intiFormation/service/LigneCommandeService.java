package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ILigneCommandeDao;
import com.intiFormation.entity.LigneCommande;

@Service
public class LigneCommandeService implements ILigneCommandeService{

	@Autowired
	ILigneCommandeDao ilcdao;
	
	public void ajouter(LigneCommande lc) {
		
		ilcdao.save(lc);
	}
	
	public Optional<LigneCommande> getById (int id){
		
		return ilcdao.findById(id);
	}
	
	public void supprimer(int id) {
		
		ilcdao.deleteById(id);
	}
	
	public void modifier(LigneCommande lc) {
		
		ajouter(lc);
	}
	
	public List<LigneCommande> getAll(){
		
		return ilcdao.findAll();
	}
	
	
	public List<LigneCommande> getByIdCommande (int id){
		
		return ilcdao.findByCommande_IdCommande(id);
	}
	
	
}
