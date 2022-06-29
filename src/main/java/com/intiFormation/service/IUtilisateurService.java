package com.intiFormation.service;


import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurService {

	public Utilisateur chercherParLogin(String login);
	public void ajout(Utilisateur u);
}
