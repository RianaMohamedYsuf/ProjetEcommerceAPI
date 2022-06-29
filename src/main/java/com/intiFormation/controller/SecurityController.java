package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IUtilisateurService;

@Controller
public class SecurityController {

	@Autowired
	IUtilisateurService ius;
	
	
	
	@RequestMapping("afficherlogin")
	public String afficherForm() {
		
		return  "afficherAuth";
	}
	
	@RequestMapping("/refuse")
	public String refuser() {
		
		return  "refuser";
	}

	
	
	
	
	
}
