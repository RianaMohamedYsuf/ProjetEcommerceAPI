package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiFormation.entity.Produit;
import com.intiFormation.service.IProduitService;

@Controller
@RequestMapping("/gestionAdmin")
public class AdminController {
	
	
	@Autowired
	IProduitService ips;
	
	@RequestMapping("/accueil")
	public String accueil() {
		
		return  "accueil";
	}
	
	
	
	@RequestMapping("Rechercher")
	public String Chercher(@RequestParam("nomProduit") String libProduit, Model model) {
		
		List<Produit> liste = ips.getByName(libProduit);
		
		model.addAttribute("liste", liste);
		
		return "AfficherRecherche";
	}
}
