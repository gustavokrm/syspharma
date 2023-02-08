package com.camaratapira.syspharma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.camaratapira.syspharma.entity.Cargo;
import com.camaratapira.syspharma.entity.Funcao;
import com.camaratapira.syspharma.repositories.CargoRepository;

@RestController
@RequestMapping("/api")
public class CargoController {
	
	@Autowired
	CargoRepository cargoRepository;
	
	@GetMapping("/cargo")
	public ResponseEntity<List<Cargo>> getAllCargos(@RequestParam(required=false)String descricaocargo){
		List<Cargo> cargo = new ArrayList<Cargo>();
		
		try {
				cargoRepository.findAll().forEach(cargo::add);
				if(cargo.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(cargo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@GetMapping("/listacargos/{idcargo}")
	public ResponseEntity<Cargo> getcargoById(@PathVariable("idcargo") int idcargo){
		Optional<Cargo> cargoData = cargoRepository.findById(idcargo);
		
		if(cargoData.isPresent())
			return new ResponseEntity<>(cargoData.get(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
