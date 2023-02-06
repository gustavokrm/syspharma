package com.camaratapira.syspharma.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.camaratapira.syspharma.entity.Cargo;
import com.camaratapira.syspharma.repositories.CargoRepository;

@RestController
@RequestMapping("/api")
public class CargoController {
	
	@Autowired
	CargoRepository cargoRepository;
	
	@GetMapping("/listacargos/{idcargo}")
	public ResponseEntity<Cargo> getcargoById(@PathVariable("idcargo") int idcargo){
		Optional<Cargo> cargoData = cargoRepository.findById(idcargo);
		
		if(cargoData.isPresent())
			return new ResponseEntity<>(cargoData.get(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
