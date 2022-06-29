package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	public Utilisateur findByLogin(String login);
}
