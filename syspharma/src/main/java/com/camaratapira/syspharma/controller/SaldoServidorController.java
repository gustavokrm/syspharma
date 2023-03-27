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
import com.camaratapira.syspharma.entity.SaldoServidor;
import com.camaratapira.syspharma.entity.Servidor;
import com.camaratapira.syspharma.repositories.SaldoServidorRepository;


@RestController
@RequestMapping("/api")
public class SaldoServidorController {
	
	@Autowired
	SaldoServidorRepository saldoServidorRepository;

	
	@GetMapping("/servidor/listarsaldo")
	public ResponseEntity<List<SaldoServidor>> getAllSaldo(@RequestParam(required = false) Integer matricula){
		List<SaldoServidor> saldo = new ArrayList<SaldoServidor>();
		
		try {
				saldoServidorRepository.findAll().forEach(saldo::add);
				if(saldo.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(saldo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@GetMapping("/servidor/listarsaldo/{matricula}")
	public ResponseEntity<SaldoServidor> getsaldoById(@PathVariable("matricula") Servidor servidor){
		Optional<SaldoServidor> saldoData = saldoServidorRepository.findAllByMatricula(servidor);
		if(saldoData.isPresent()) {
			return new ResponseEntity<>(saldoData.get(), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
