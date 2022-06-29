package com.intiFormation.controller;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.MessageVerif;


@RestController  //@Controller @responseBody
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
	
	@GetMapping("/msgVerif")
	public MessageVerif afficher()
	{
		return new MessageVerif("Ca marche");
	}

}
