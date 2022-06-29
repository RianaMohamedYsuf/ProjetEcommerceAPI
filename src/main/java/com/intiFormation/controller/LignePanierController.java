package com.intiFormation.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.LignePanier;
import com.intiFormation.entity.MessageVerif;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.ILignePanierService;
import com.intiFormation.service.IPanierService;
import com.intiFormation.service.IProduitService;

@RestController  //@Controller @responseBody
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class LignePanierController {

	@Autowired
	ILignePanierService ilps;
	
	@Autowired
	IProduitService ips;
	
	@Autowired
	IPanierService ipanierS;
	
	

	
	@GetMapping("/paniers")
	public List<LignePanier> AfficherPanier() {
		
		List<LignePanier> liste = ilps.getAll();
		return liste;
	}
	
	@GetMapping("/paniers/{id}")
	public LignePanier ChercherUn(@PathVariable("id") int id ) {
		
		LignePanier lp = ilps.getById(id).get();
		return lp;
	}
	
	
	@PostMapping("/paniers/{idProduit}")
	public void addlignePanier(@RequestBody LignePanier lp, @PathVariable("idProduit") int idProduit) {
		
		Produit p = ips.getById(idProduit).get();
		lp.setProduit(p);
		
		//Qté 1 par défaut dans le panier
		lp.setQuantite(1);
		
		//Maj de la quantité dispo du produit
		p.setQuantite(p.getQuantite()-1);
		
		Panier panier = ipanierS.getById(1).get();
		lp.setPanier(panier);
		panier.getLignePaniers().add(lp);
		
		ilps.ajouter(lp);
		
	}
	
	
	@GetMapping("/paniers/ajoutVerif/{idProduit}")
	public MessageVerif verifAjout(@PathVariable("idProduit") int id)
	{
		if (ilps.getLignePanierByIdProd(id)!=null) {
			
			return new MessageVerif("Ce produit a déjà été ajouté. Veuillez modifier la quantité dans le panier");
		
		}
		else {
			
		Produit p = ips.getById(id).get();
		if(p.getQuantite()==0) {
			
			return new MessageVerif("Ce produit n'est plus disponible !");
			
		}
		return new MessageVerif("AjoutOk");
		}
			
	}
	
	
	
	@DeleteMapping("/paniers/{idLignePanier}")
	public void supprimer(@PathVariable("idLignePanier") int id)
	{
		LignePanier lp= ilps.getById(id).get();
		lp.getProduit().setQuantite(lp.getProduit().getQuantite() + lp.getQuantite());
		
		ilps.supprimer(id);
	}
	
	
	
	
	@PutMapping("/paniers/{idLignePanier}")
	public void ModifPanier(@PathVariable("idLignePanier") int idLignePanier, 
			@RequestParam("quantiteApres") int quantiteApres){
		
		LignePanier lp2=ilps.getById(idLignePanier).get();
		int quantiteAvant = lp2.getQuantite();
		
		lp2.setQuantite(quantiteApres);
		
		lp2.getProduit().setQuantite(lp2.getProduit().getQuantite() + quantiteAvant - quantiteApres);

		ilps.ajouter(lp2);
		
	}
}

