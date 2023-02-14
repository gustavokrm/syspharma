package com.camaratapira.syspharma.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.camaratapira.syspharma.entity.Compras;

import com.camaratapira.syspharma.repositories.ComprasRepository;
import com.camaratapira.syspharma.repositories.FarmaciaRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;


@RestController
@RequestMapping("/api")
public class ComprasController {

    @Autowired
    ComprasRepository comprasRepository;
    @Autowired
    ServidorRepository servidorRepository;
    @Autowired
    FarmaciaRepository farmaciaRepository;

    //TODO query para listar as compras e stored procedure para poder inserir uma compra
    @GetMapping("/compras/listarcompras")
    public ResponseEntity<List<Compras>> getAllCompras(@RequestParam(required=false) Integer idcompras){
		List<Compras> compras = new ArrayList<Compras>();		
		try {
				comprasRepository.findAll().forEach(compras::add);
				return new ResponseEntity<>(compras, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(compras, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
    
	@GetMapping("/compras/{idcompras}")
	public ResponseEntity<Compras> getcomprasById(@PathVariable("idcompras") int idcompras){
		Optional<Compras> comprasData = comprasRepository.findById(idcompras);
		
		if(comprasData.isPresent())
			return new ResponseEntity<>(comprasData.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
