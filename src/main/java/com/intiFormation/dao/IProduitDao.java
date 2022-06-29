package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Produit;

public interface IProduitDao extends JpaRepository<Produit, Integer>{
	
	public List<Produit> findByLibProduit(String libProduit);
}
