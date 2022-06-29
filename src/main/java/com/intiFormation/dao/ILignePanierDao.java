package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.LignePanier;

public interface ILignePanierDao extends JpaRepository<LignePanier, Integer> {

	public LignePanier findByProduit_IdProduit(int id);
}
