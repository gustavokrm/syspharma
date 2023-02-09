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
import com.camaratapira.syspharma.entity.Cargo;
import com.camaratapira.syspharma.repositories.CargoRepository;

@RestController
@RequestMapping("/api")
public class CargoController {
	
	@Autowired
	CargoRepository cargoRepository;
	
	@GetMapping("/cargo/listartodos")
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
	
	@GetMapping("/cargo/listacargos/{idcargo}")
	public ResponseEntity<Cargo> getcargoById(@PathVariable("idcargo") int idcargo){
		Optional<Cargo> cargoData = cargoRepository.findById(idcargo);
		
		if(cargoData.isPresent())
			return new ResponseEntity<>(cargoData.get(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/cargo/criarcargos")
	public ResponseEntity<Cargo> createCargo(@RequestBody Cargo cargo){
		try {
			Cargo _cargo = cargoRepository.save(cargo);
			return new ResponseEntity<>(_cargo, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Cargo>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/cargo/atualizarcargos")
	public ResponseEntity<Cargo> updateCargo(@PathVariable("idcargo") int idcargo, @RequestBody Cargo cargo){
		Optional<Cargo> cargoData = cargoRepository.findById(idcargo);
		if(cargoData.isPresent()){
			Cargo _cargo = cargoData.get();
			_cargo.setDescricaocargo(cargo.getDescricaocargo());
			return new ResponseEntity<>(cargoRepository.save(_cargo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/cargo/deletarcargo/{idcargo}")
	public ResponseEntity<HttpStatus> deleteCargo(@PathVariable("idcargo") int idcargo, @RequestBody Cargo cargo){
		try {
			cargoRepository.deleteById(idcargo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
		
}
