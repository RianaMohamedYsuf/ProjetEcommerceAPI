package com.intiFormation.service;

import java.util.Optional;

import com.intiFormation.entity.Panier;

public interface IPanierService {

	public Optional<Panier> getById(int id);
}
