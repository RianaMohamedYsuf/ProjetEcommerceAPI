package com.intiFormation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiFormation.entity.Commande;
import com.intiFormation.entity.LigneCommande;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.ICommandeService;
import com.intiFormation.service.ILigneCommandeService;
import com.intiFormation.service.ILignePanierService;
import com.intiFormation.service.IPanierService;
import com.intiFormation.service.IUtilisateurService;

@Controller
@RequestMapping("api")
@CrossOrigin(origins="http://localhost:4200")
public class CommandeController {


	@Autowired
	ILigneCommandeService ilcs;
	
	@Autowired
	IUtilisateurService ius;
	
	@Autowired
	ICommandeService ics;
	
	@Autowired
	IPanierService ips;
	
	@Autowired
	ILignePanierService ilps;
	
	
	
	
	@RequestMapping("afficherCommande")
	public String afficherCommandeUser (Model model, Authentication auth) {
		
		//By User Id
		String username= ((User)auth.getPrincipal()).getUsername();
		Utilisateur u = ius.chercherParLogin(username);
		
		List<Commande> listeById  = ics.getAllByUserId(u.getId());
		model.addAttribute("listeById", listeById);
		
		//All
		List<Commande> listeAll = ics.getAll();
		model.addAttribute("listeAll", listeAll);
		
		return "AfficherCommande";
	}
	
	
	
	@RequestMapping("creerCommande")
	public String creerCommande(Authentication auth, Model model) {
		
		//Get Panier
		Panier p = ips.getById(1).get();
		
		//Create Commande
		Commande c = new Commande ();
		List<LigneCommande> lc_liste = new ArrayList<LigneCommande>();
		c.setLigneCommandes(lc_liste);
		
		//Set Ligne de Commande
		for (int i=0; i < p.getLignePaniers().size(); i++) {
			
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p.getLignePaniers().get(i).getProduit());
			lc.setQuantite(p.getLignePaniers().get(i).getQuantite());
			lc.setCommande(c);
			c.getLigneCommandes().add(lc);
			
			ilcs.ajouter(lc);
		}
		
		//Set utilisateur
		String username= ((User)auth.getPrincipal()).getUsername();
		Utilisateur u = ius.chercherParLogin(username);
		c.setUser(u);
		
		//Set Date
		LocalDate today = LocalDate.now();
		c.setDateCommande(today.toString());
		
		//Initializate Panier
		ilps.suppimerTT();
		p.setLignePaniers(ilps.getAll());
		
		//Save Commande
		ics.ajouter(c);
		
		return "redirect:/GestionCommande/afficherCommande";
		
	}
		
		
	
	
	@RequestMapping("/afficherDetailsCommande")
	public String AfficherDetailsCommande(@RequestParam("idCommande") int id, Model model) {
			
			List<LigneCommande> liste = ilcs.getByIdCommande(id);
			model.addAttribute("liste", liste);
			
			String date = ics.getById(id).get().getDateCommande();
			model.addAttribute("date", date);
			
			String nom = ics.getById(id).get().getUser().getNom();
			model.addAttribute("nom", nom); 
			
			String prenom = ics.getById(id).get().getUser().getPrenom();
			model.addAttribute("prenom", prenom);
			
			return "AfficherDetailsCommande";
		}
	
	
	@RequestMapping("/SupprimerCommande")
	public String supprimer(@RequestParam("idCommande") int id)
	{
		ics.supprimer(id);
		
		return "redirect:/GestionCommande/afficherCommande" ;
	}
	
}
	
	
	

