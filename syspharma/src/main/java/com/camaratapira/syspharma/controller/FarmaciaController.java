package com.camaratapira.syspharma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camaratapira.syspharma.entity.Farmacia;
import com.camaratapira.syspharma.repositories.FarmaciaRepository;

@RestController
@RequestMapping("/api")
public class FarmaciaController {
	
	@Autowired
	FarmaciaRepository farmaciaRepository;
	
	@GetMapping("/farmacia")
	public ResponseEntity<List<Farmacia>> getAllFarmacias(@RequestParam(required=false)String nomefarmacia){
		List<Farmacia> farmacia = new ArrayList<Farmacia>();
		
		try {
			if(nomefarmacia == null)
				farmaciaRepository.findAll().forEach(farmacia::add);
			else
				farmaciaRepository.findBynomefarmacia(nomefarmacia).forEach(farmacia::add);
			if(farmacia.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(farmacia, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@GetMapping("/farmacia/{idfarmacia}")
	public ResponseEntity<Farmacia> getFarmaciaById(@PathVariable("idfarmacia") int idfarmacia){
		Optional<Farmacia> farmaciaData = farmaciaRepository.findById(idfarmacia);
		
		if(farmaciaData.isPresent())
			return new ResponseEntity<>(farmaciaData.get(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/criarfarmacia")
	public ResponseEntity<Farmacia> createFarmacia(@RequestBody Farmacia farmacia){
		try {
			Farmacia _farmacia = farmaciaRepository.save(new Farmacia(farmacia.getNomefarmacia(), farmacia.getCnpjfarmacia(), farmacia.getNomeresponsavel(), farmacia.getTelefonefarmacia()));
			return new ResponseEntity<>(_farmacia, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@PutMapping("/atualizar/{idfarmacia}")
	public ResponseEntity<Farmacia> updateFarmacia(@PathVariable("idfarmacia") int idfarmacia, @RequestBody Farmacia farmacia){
		Optional<Farmacia> farmaciaData = farmaciaRepository.findById(idfarmacia);
		
		if(farmaciaData.isPresent()){
			Farmacia _farmacia = farmaciaData.get();
			_farmacia.setNomefarmacia(farmacia.getNomefarmacia());
			_farmacia.setCnpjfarmacia(farmacia.getCnpjfarmacia());
			_farmacia.setNomeresponsavel(farmacia.getNomeresponsavel());
			_farmacia.setTelefonefarmacia(farmacia.getTelefonefarmacia());
			return new ResponseEntity<>(farmaciaRepository.save(_farmacia), HttpStatus.OK);			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
				
	}
	
	
	
}
