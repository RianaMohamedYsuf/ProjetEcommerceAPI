package com.intiFormation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.entity.Utilisateur;
import com.intiFormation.dao.IUtilisateurDao;

@Service
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	IUtilisateurDao iudao;
	
	public Utilisateur chercherParLogin(String login) {
		
		return iudao.findByLogin(login);
	}
	
	public void ajout(Utilisateur u) {
		
		iudao.save(u);
	}
}
