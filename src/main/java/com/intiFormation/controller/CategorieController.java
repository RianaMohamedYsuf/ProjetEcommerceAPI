package com.intiFormation.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.ICategorieService;
import com.intiFormation.service.IProduitService;


@RestController  //@Controller @responseBody
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class CategorieController {

	@Autowired
	ICategorieService ics;
	
	@Autowired
	IProduitService ips;
	
	
	@GetMapping("/categories")
	public List<Categorie> AfficherCategorie() {
		
		List<Categorie> liste = ics.getAll();
		return liste;
	}
	
	
	@GetMapping("/categories/{idCategorie}")
	public Categorie chercherUn(@PathVariable("idCategorie") int id)
	{
		Categorie c = ics.getById(id).get();
		return c;
	}
	
	
	
	@PostMapping("/categories")
	public void ajouterCategorie(@RequestBody Categorie c) {
		
		ics.ajouter(c);
	}
	
	
	@DeleteMapping("/categories/{idCategorie}")
	public void supprimer(@PathVariable("idCategorie") int id)
	{
		ics.supprimer(id);

	}
	
	
	@PutMapping("/categories")
	public void modifier(@RequestBody Categorie c) {
		
		ics.modifier(c);
		
	}
	
	
}
