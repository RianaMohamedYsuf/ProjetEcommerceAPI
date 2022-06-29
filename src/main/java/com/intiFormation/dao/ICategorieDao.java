package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Categorie;


public interface ICategorieDao extends JpaRepository<Categorie, Integer> {

}
