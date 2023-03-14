package com.camaratapira.syspharma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import jakarta.persistence.EntityManager;

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
    EntityManager em;
    
      
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
    
    @GetMapping("/compras/listarservidor/{idservidor}")    
    public ResponseEntity<List<Compras>> getcomprasByIdServidor(@PathVariable("idservidor") Servidor idservidor){
    	List<Compras> comprasData = comprasRepository.findAllByIdservidor(idservidor);
    	if(comprasData.isEmpty())
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	else
    		return new ResponseEntity<List<Compras>>(comprasData, HttpStatus.OK);
    }
   
    // TODO deduce from saldoservidor every time a sale is made
    // TODO if saldoservidor == 0 or less than valorcompra then throw exception
    // When using @JsonIgnore annotation, spring boot gets confused and can't find anything, and it throws an error
    
    @PostMapping("/compras/realizarcompra")
    public ResponseEntity<Compras> createCompras(@RequestBody Compras compras){
		try {
			SaldoServidor saldo = new SaldoServidor();
			double valorcompra = compras.getValorcompra();
			System.out.println(valorcompra);
			double sal = saldo.getSaldo(); // saldo vem nulo
			System.out.println(sal);
			double total = sal - valorcompra;
			if(sal < valorcompra) {
				System.out.println("Saldo insuficiente");
			} else {
				saldo.setSaldo(total);
				comprasRepository.save(compras);
			}
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Compras>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
    
}
