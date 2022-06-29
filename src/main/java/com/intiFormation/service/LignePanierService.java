package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ILignePanierDao;
import com.intiFormation.entity.LignePanier;

@Service
public class LignePanierService implements ILignePanierService{

	@Autowired
	ILignePanierDao ilpdao;
	
	public void ajouter(LignePanier lp) {
		
		ilpdao.save(lp);
		
	}
	
	public List<LignePanier> getAll(){
		
		return ilpdao.findAll();
	}
	
	public LignePanier getLignePanierByIdProd(int id) {
		
		return ilpdao.findByProduit_IdProduit(id);
	}
	
	public void supprimer(int id) {
		
		ilpdao.deleteById(id);
	}
	
	public Optional<LignePanier> getById(int id){
		return ilpdao.findById(id);
	}
	
	public void suppimerTT() {
		
		ilpdao.deleteAll();
	}
}
