package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICommandeDao;
import com.intiFormation.entity.Commande;

@Service
public class CommandeService implements ICommandeService {

	@Autowired
	ICommandeDao icdao;
	
	public void ajouter(Commande c) {
		
		icdao.save(c);
	}
	
	public Optional<Commande> getById (int id){
		
		return icdao.findById(id); 
	}
	
	
	public void supprimer(int id) {
		
		icdao.deleteById(id);
	}
	
	public void modifier(Commande c) {
		
		ajouter(c);
	}
	
	public List<Commande> getAll(){
		
		return icdao.findAll();
	}
	
	public List<Commande> getAllByUserId(int id){
		
		return icdao.findByUser_Id(id);
	}
}
