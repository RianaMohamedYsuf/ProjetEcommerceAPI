package com.intiFormation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class ProjetEcommerceAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetEcommerceAPIApplication.class, args);
	}
	
	/*@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    
	    return multipartResolver;
	}*/

}
