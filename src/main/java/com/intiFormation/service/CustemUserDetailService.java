package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;

@Service
public class CustemUserDetailService implements UserDetailsService{

	@Autowired
	IUtilisateurService ius;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
	
		Utilisateur utilisateur = ius.chercherParLogin(login);
		
		if(utilisateur==null) {
			
			throw new UsernameNotFoundException(login);
		}
		
		List<GrantedAuthority> listeRole= getGrantedAuthority(utilisateur);
		
		return new User(utilisateur.getLogin(), utilisateur.getPassword(), listeRole);
		
		
	}
	
	//Equivalent de Role dans Spring Security
	private List<GrantedAuthority> getGrantedAuthority(Utilisateur u){
		
		List<GrantedAuthority> liste = new ArrayList<>();
		Role role = u.getRole();
		liste.add(new SimpleGrantedAuthority(role.getLibrole()));
		return liste;
	}

	
}
