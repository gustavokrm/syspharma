package com.camaratapira.syspharma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.camaratapira.syspharma.entity.Dependentes;
import com.camaratapira.syspharma.repositories.DependenteRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;

@RestController
@RequestMapping("/api")
public class DependenteController {
	
	@Autowired
	DependenteRepository dependenteRepository;
	@Autowired
	ServidorRepository servidorRepository;
	
	@GetMapping("/dependente/listartodos")
	public ResponseEntity<List<Dependentes>> getAllDependentes(@RequestParam(required=false) String nomedependente){
		
		List<Dependentes> dependente = new ArrayList<Dependentes>();
		try {
			dependenteRepository.findAll().forEach(dependente::add);
			if(dependente.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} 
			return new ResponseEntity<>(dependente, HttpStatus.OK);
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/dependente/listardependente/{iddependente}")
	public ResponseEntity<Dependentes> getdependenteById(@PathVariable("iddependente") int iddependente){
		Optional<Dependentes> dependenteData = dependenteRepository.findById(iddependente);
		
		if(dependenteData.isPresent())
			return new ResponseEntity<Dependentes>(dependenteData.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/dependente/criardependente")
	public ResponseEntity<Dependentes> createDependente(@RequestBody Dependentes dependente){
		try {
			Dependentes _dependente = dependenteRepository.save(dependente);
			return new ResponseEntity<>(_dependente, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Dependentes>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/dependente/atualizar/{iddependente}")
	public ResponseEntity<Dependentes> updateDependente(@PathVariable("iddependente") int iddependente, @RequestBody Dependentes dependente){
		Optional<Dependentes> dependenteData = dependenteRepository.findById(iddependente);
		
		if(dependenteData.isPresent()){
			Dependentes _dependente = dependenteData.get();
			_dependente.setNomedependente(dependente.getNomedependente());
			_dependente.setCpfdependente(dependente.getCpfdependente());
			_dependente.setRgdependente(dependente.getRgdependente());
			_dependente.setServidor(dependente.getServidor());
			return new ResponseEntity<>(dependenteRepository.save(_dependente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/dependente/deletar/{iddependente}")
	public ResponseEntity<HttpStatus> deleteDependente(@PathVariable("iddependente") int iddependente, @RequestBody Dependentes dependente){
		try {
			dependenteRepository.deleteById(iddependente);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
