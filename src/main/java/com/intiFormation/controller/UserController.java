package com.intiFormation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiFormation.entity.Produit;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IProduitService;
import com.intiFormation.service.IUtilisateurService;


@Controller
@RequestMapping("/gestionClient")
public class UserController {

	@Autowired
	IProduitService ips;
	
	@Autowired
	IUtilisateurService ius;
	
	
	@RequestMapping("Rechercher")
	public String Chercher(@RequestParam("nomProduit") String libProduit, Model model) {
		
		List<Produit> liste = ips.getByName(libProduit);
		
		model.addAttribute("liste", liste);
		
		return "AfficherRecherche";
	}
	
	@RequestMapping("/PageEntree")
	public String pageEntree() {
		
		return  "PageEntree";
	}
	
	
	@RequestMapping ("/chercherUser")
	public String UserDetails(Authentication auth,HttpSession s) {
		
		String username= ((User)auth.getPrincipal()).getUsername();
		
		Utilisateur u = ius.chercherParLogin(username);
		s.setAttribute("u", u);
		
		return "accueil";
	}
	
}
