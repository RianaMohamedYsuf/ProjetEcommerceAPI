package com.intiFormation.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthentificationSuccessHandlerImpl implements AuthenticationSuccessHandler{

 

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
    	
    
        String roleUser=""; 
        Collection<? extends GrantedAuthority> roles= authentication.getAuthorities();
        for (GrantedAuthority role : roles) 
        {
        	roleUser=role.getAuthority();
        }
        
       
        if(roleUser.equals("admin"))
        {
        	response.sendRedirect("/gestionAdmin/accueil" );
        }
        else if(roleUser.equals("client"))
        {
        	response.sendRedirect("/gestionClient/PageEntree" );
        }
        

    }
	

}
	
