package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commande;

public interface ICommandeDao extends JpaRepository<Commande, Integer>{

	public List<Commande> findByUser_Id(int id);
	
}
