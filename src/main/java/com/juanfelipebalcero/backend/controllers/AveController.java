package com.juanfelipebalcero.backend.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.juanfelipebalcero.backend.models.Ave;
import com.juanfelipebalcero.backend.models.Pais;
import com.juanfelipebalcero.backend.repositories.AveRepository;
import com.juanfelipebalcero.backend.repositories.PaisRepository;

@Controller
@RequestMapping(path="/ave")
public class AveController {
	@Autowired
	private AveRepository aveRepository;
	@Autowired
	private PaisRepository paisRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/add/{cdpais}")
	public @ResponseBody Ave addNewAve (@RequestBody Ave ave, @PathVariable Integer cdpais) {
		Optional<Pais> pais = paisRepository.findById(cdpais);
		pais.ifPresent(e -> ave.getPais().add(e));		
		
		Ave guardada = aveRepository.save(ave);
		return guardada;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Ave> getAllAves() {
		return aveRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Ave> getAve(@PathVariable Integer id) {
		return aveRepository.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="/{id}")
	public @ResponseBody Map<String, String> deleteAve (@PathVariable Integer id) {
		aveRepository.deleteById(id);
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("respuesta", "borrado");
		return map;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path="/{cdpais}")
	public @ResponseBody Ave updateAve (@RequestBody Ave aveActualizada, @PathVariable Integer cdpais) {
		
		Optional<Pais> pais = paisRepository.findById(cdpais);
		pais.ifPresent(e -> aveActualizada.getPais().clear());	
		pais.ifPresent(e -> aveActualizada.getPais().add(e));		
		
		Ave updatedAve = aveRepository.save(aveActualizada);
		return updatedAve;
	}
}