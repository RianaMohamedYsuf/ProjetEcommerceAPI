package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.LigneCommande;

public interface ILigneCommandeDao extends JpaRepository<LigneCommande, Integer>{

	public List<LigneCommande> findByCommande_IdCommande(int id);
	
}
