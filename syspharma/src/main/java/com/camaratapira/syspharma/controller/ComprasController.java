package com.camaratapira.syspharma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.camaratapira.syspharma.entity.*;
import com.camaratapira.syspharma.repositories.ComprasRepository;
import com.camaratapira.syspharma.repositories.FarmaciaRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;
import com.camaratapira.syspharma.service.ComprasService;


@RestController
@RequestMapping("/api")
public class ComprasController {

    @Autowired
    ComprasRepository comprasRepository;
    @Autowired
    ServidorRepository servidorRepository;
    @Autowired
    FarmaciaRepository farmaciaRepository;
    @Autowired
    ComprasService comprasService;
         
    @GetMapping("/compras/listartodos")
    public ResponseEntity<List<Compras>> getAllCompras(@RequestParam(required=false) Integer idcompras){
		List<Compras> compras = new ArrayList<Compras>();		
		try {
				comprasRepository.findAll().forEach(compras::add);
				return new ResponseEntity<>(compras, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(compras, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
        
    @GetMapping("/compras/listar/{idcompras}")
    public ResponseEntity<List<Compras>> getcomprasById(@PathVariable("idcompras") int idcompras){
		
		List<Compras> comprasData = comprasRepository.findByIdcompras(idcompras);
		
		if(comprasData.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Compras>>(comprasData, HttpStatus.OK);
	}
    
    // It is necessary to pass the entire servidor entity as a parameter so that spring boot finds it
    // or it will return a 404 error
    
    @GetMapping("/compras/listarporservidor/{idservidor}")    
    public ResponseEntity<List<Compras>> getcomprasByIdServidor(@PathVariable("idservidor") Servidor idservidor){
    	List<Compras> comprasData = comprasRepository.findAllByIdservidor(idservidor);
    	if(comprasData.isEmpty())
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	else
    		return new ResponseEntity<List<Compras>>(comprasData, HttpStatus.OK);
    }
   
    // When using @JsonIgnore annotation, spring boot gets confused and can't find anything, and it throws an error
    
   
	// TODO compras não podem ser feitas se o servidor estiver inativo
	
    @PostMapping("/compras/realizarcompra")
    public ResponseEntity<Compras> createCompras(@RequestBody Compras compras){
		try {
			comprasService.addCompras(compras);
			return new ResponseEntity<>(compras, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Compras>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
    
}
