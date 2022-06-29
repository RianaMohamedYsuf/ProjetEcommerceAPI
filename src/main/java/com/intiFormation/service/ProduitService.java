package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.dao.IProduitDao;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

@Service
public class ProduitService implements IProduitService{

	@Autowired
	IProduitDao ipdao;
	
	@Autowired
	ICategorieDao icdao;
	
	
	public void ajouter(Produit p) {
		
		ipdao.save(p);
	}
	
	public void supprimer(int idProduit) {
		
		ipdao.deleteById(idProduit);
	}
	
	
	public void modifier(Produit p) {
		
		ajouter(p);
		
	}
	
	
	public List<Produit> getByCat(int idcat){
		
		return icdao.findById(idcat).get().getProduits();
		
	}
	
	
	public Optional<Produit> getById(int idProduit){
		
		return ipdao.findById(idProduit);
	}
	
	
	public List<Produit> getAll(){
		
		return ipdao.findAll();
		
	}
	
	public List<Produit> getByName(String libProduit){
		
		return ipdao.findByLibProduit(libProduit);
	}

	                                          
	
	
}
