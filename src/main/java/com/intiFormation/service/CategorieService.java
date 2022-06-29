package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.entity.Categorie;

@Service
public class CategorieService implements ICategorieService{

	@Autowired
	ICategorieDao icdao;
	
	public void ajouter(Categorie c) {
		
		icdao.save(c);
		
	}
	
	public void supprimer(int idCat) {
		
		icdao.deleteById(idCat);
	}
	
	
	public void modifier(Categorie c) {
		
		icdao.save(c);
	}
	
	
	public List<Categorie> getAll(){
		
		return icdao.findAll();
		
	}
	
	public Optional<Categorie> getById(int idCat){
		
		return icdao.findById(idCat);
	}
	
	
	public String getNomCat(int idCat) {
		
		return getById(idCat).get().getNomCategorie();
		
	}
	
	
}
