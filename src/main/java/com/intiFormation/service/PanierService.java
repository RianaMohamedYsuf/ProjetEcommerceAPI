package com.intiFormation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IPanierDao;
import com.intiFormation.entity.Panier;

@Service
public class PanierService  implements IPanierService{

	
	@Autowired
	IPanierDao ipdao;
	
	
	public Optional<Panier> getById(int id) {
		
		return ipdao.findById(id);
	}
	
}


