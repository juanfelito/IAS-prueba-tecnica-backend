package com.juanfelipebalcero.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.juanfelipebalcero.backend.models.Pais;
import com.juanfelipebalcero.backend.repositories.PaisRepository;

@Controller
@RequestMapping(path="/pais")
public class PaisController {
	@Autowired
	private PaisRepository paisRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Pais> getAllPaises() {
		return paisRepository.findAll();
	}
}