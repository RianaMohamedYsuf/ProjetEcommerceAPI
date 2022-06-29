package com.intiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.ICategorieService;
import com.intiFormation.service.IProduitService;


@RestController  //@Controller @responseBody
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class ProduitController {

	
	@Autowired
	IProduitService ips;
	
	@Autowired
	ICategorieService ics;
	
	
	
	@GetMapping("/produits")
	public List<Produit> AfficherProduit() {
		
		List<Produit> liste = ips.getAll();
		return liste;
	}
	
	
	@GetMapping("/produits/{idProduit}")
	public Produit chercherUn(@PathVariable("idProduit") int id)
	{
		Produit p = ips.getById(id).get();
		return p;
	}
	
	@GetMapping("/produitsCat/{idCat}")
	public List<Produit> chercherByCat(@PathVariable("idCat") int id)
	{
		List<Produit> liste = ips.getByCat(id);
		return liste;
	}
	
	
	@DeleteMapping("/produits/{idProduit}")
	public void supprimer(@PathVariable("idProduit") int id)
	{
		ips.supprimer(id);

	}
	
	
	@PutMapping("/produits")
	public void modifier(@RequestParam("file") MultipartFile file, 
		@RequestParam("idProduit") int idProduit,
		@RequestParam("quantite") int qte,
		@RequestParam("libProduit") String nom,
		@RequestParam("idCate") int idCate,
		HttpSession session) throws IOException{
	
	String filename= file.getOriginalFilename();
	
	String path=session.getServletContext().getRealPath("/")+"imageproduit\\"+filename;
	
	Produit p = ips.getById(idProduit).get();
	
	p.setImg("\\imageproduit\\"+filename);
	p.setLibProduit(nom);
	p.setQuantite(qte);
	
	Optional<Categorie> op = ics.getById(idCate);
	if(op.isPresent()) {
		p.setCategorie(op.get());
	}
	else {
		System.out.println("Pas de Categorie");
	}
	
	ips.ajouter(p);
	
	
	try{  
        byte barr[]=file.getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(path));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
          
        }catch(Exception e)
		{
        	System.out.println(e);
        	}
	
	
	return;
		
	}
	
	
	
	
	@PostMapping("/produits/upload")
	public void fileUpload(@RequestParam("f") MultipartFile file, 
			@RequestParam("quantite") int qte,
			@RequestParam("libProduit") String nom,
			@RequestParam("idCate") int idCate,
			HttpSession session) throws IOException{
		
		String filename= file.getOriginalFilename();
	
		
		String path=session.getServletContext().getRealPath("/")+"imageproduit\\"+filename;
		
		
		//Categorie c=ics.getById(idCate).get();
		//p.setCategorie(c);
		
		Produit p = new Produit ();
		
		p.setImg("\\imageproduit\\"+filename);
		p.setLibProduit(nom);
		p.setQuantite(qte);
		
		Optional<Categorie> op = ics.getById(idCate);
		if(op.isPresent()) {
			p.setCategorie(op.get());
		}
		else {
			System.out.println("Pas de Categorie");
		}
		
		
		ips.ajouter(p);
		
		
		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	System.out.println(e);
	        	}
		
		
		return;
	}
	
	
}
