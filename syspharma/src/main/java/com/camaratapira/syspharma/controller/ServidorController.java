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
import com.camaratapira.syspharma.entity.Servidor;
import com.camaratapira.syspharma.repositories.FuncaoRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;



@RestController
@RequestMapping("/api")
public class ServidorController {
	
	@Autowired
	ServidorRepository servidorRepository;
	@Autowired
	FuncaoRepository funcaoRepository;
		
	// lista todos os servidores
	@GetMapping("/servidor/listartodos")
	public ResponseEntity<List<Servidor>> getAllServidors(@RequestParam(required=false)String nomeservidor){
		List<Servidor> servidor = new ArrayList<Servidor>();
		
		try {
				servidorRepository.findAll().forEach(servidor::add);
				if(servidor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(servidor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@GetMapping("/servidor/{idservidor}")
	public ResponseEntity<Servidor> getservidorById(@PathVariable("idservidor") int idservidor){
		Optional<Servidor> servidorData = servidorRepository.findById(idservidor);
		
		if(servidorData.isPresent())
			return new ResponseEntity<>(servidorData.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/servidor/criarservidor")
	public ResponseEntity<Servidor> createServidor(@RequestBody Servidor servidor){
		try {
			Servidor _servidor = servidorRepository.save(servidor);
			return new ResponseEntity<>(_servidor, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Servidor>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/servidor/atualizar/{idservidor}")
	public ResponseEntity<Servidor> updateServidor(@PathVariable("idservidor") int idservidor, @RequestBody Servidor servidor){
		Optional<Servidor> servidorData = servidorRepository.findById(idservidor);
		
		if(servidorData.isPresent()){
			Servidor _servidor = servidorData.get();
			_servidor.setNomeservidor(servidor.getNomeservidor());
			_servidor.setCpf(servidor.getCpf());
			_servidor.setRg(servidor.getRg());
			_servidor.setFuncao(servidor.getFuncao());
			_servidor.setSalario(servidor.getSalario());
			_servidor.setAtivo(servidor.isAtivo());
			return new ResponseEntity<>(servidorRepository.save(_servidor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/servidor/deletar/{idservidor}") /* é preciso adicionar a anotação @RequestBody para que ele possa achar o idfarmacia */
	public ResponseEntity<HttpStatus> deleteServidor(@PathVariable("idservidor") int idservidor, @RequestBody Servidor servidor){
		try {
			servidorRepository.deleteById(idservidor);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
