package com.camaratapira.syspharma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.camaratapira.syspharma.entity.Farmacia;
import com.camaratapira.syspharma.entity.Funcao;
import com.camaratapira.syspharma.entity.Servidor;
import com.camaratapira.syspharma.repositories.ServidorRepository;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/api")
public class ServidorController {
	
	@Autowired
	ServidorRepository servidorRepository;
	EntityManager em;
	
	// lista todos os servidores
	@GetMapping("/servidor")
	public ResponseEntity<List<Servidor>> getAllServidors(@RequestParam(required=false)String nomeservidor){
		List<Servidor> servidor = new ArrayList<Servidor>();
		
		try {
			if(nomeservidor == null)
				servidorRepository.findAll().forEach(servidor::add);
			else
				servidorRepository.findBynomeservidor(nomeservidor).forEach(servidor::add);
			if(servidor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(servidor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	/*
	@PostMapping("/inserirservidor")
	public ResponseEntity<Servidor> createServidor(@RequestBody Servidor servidor){
		try {
			Servidor _servidor = servidorRepository.save(new Servidor(servidor.getNomeservidor(), servidor.getCpf(), servidor.getRg(), servidor.getSalario(), servidor.isAtivo()));
			return new ResponseEntity<>(_servidor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/atualizarservidor/{idservidor}")
	public ResponseEntity<Servidor> updateServidor(@PathVariable("idservidor") int idservidor, @RequestBody Servidor servidor){
		Optional<Servidor> servidorData = servidorRepository.findById(idservidor);
		
		if(servidorData.isPresent()){
			Servidor _servidor = servidorData.get();
			_servidor.setNomeservidor(servidor.getNomeservidor());
			_servidor.setCpf(servidor.getCpf());
			_servidor.setRg(servidor.getRg());
			_servidor.setSalario(servidor.getSalario());
			_servidor.setAtivo(servidor.isAtivo());
			return new ResponseEntity<>(servidorRepository.save(_servidor), HttpStatus.OK);			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
				
	} */
	
	@DeleteMapping("/deletarservidor/{idservidor}") /* é preciso adicionar a anotação @RequestBody para que ele possa achar o idservidor */
	public ResponseEntity<HttpStatus> deleteservidor(@PathVariable("idservidor") int idservidor, @RequestBody Servidor servidor){
		try {
			servidorRepository.deleteById(idservidor);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
