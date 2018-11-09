package com.juanfelipebalcero.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.juanfelipebalcero.backend.models.Zona;
import com.juanfelipebalcero.backend.repositories.ZonaRepository;

@Controller
@RequestMapping(path="/zona")
public class ZonaController {
	@Autowired
	private ZonaRepository zonaRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Zona> getAllAves() {
		return zonaRepository.findAll();
	}
}