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
import com.camaratapira.syspharma.repositories.SaldoServidorRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;
import com.camaratapira.syspharma.service.ServidorService;

@RestController
@RequestMapping("/api")
public class ServidorController {
	
	@Autowired
	ServidorRepository servidorRepository;
	@Autowired
	FuncaoRepository funcaoRepository;
	@Autowired
	ServidorService servidorService;
	@Autowired
	SaldoServidorRepository saldoServidorRepository;
	
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
	
	// lista informações sobre servidor específico através do número de matrícula
	@GetMapping("/servidor/{idservidor}")
	public ResponseEntity<Servidor> getservidorById(@PathVariable("idservidor") int idservidor){
		Optional<Servidor> servidorData = servidorRepository.findById(idservidor);
		
		if(servidorData.isPresent())
			return new ResponseEntity<>(servidorData.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// lista informações sobre servidor através do nome
	// não é necessário digitar o nome inteiro, apenas parte dele
	// é necessário colocar os nomes numa array, adicionar cada um, e depois devolver essa array
	// esse método faz referência a um método do repositório findBynomeservidorContaining
	// o Containing é uma palavra-chave do spring data jpa que permite buscar por strings contendo determinada palavra
	@GetMapping("/servidor/nome/{nomeservidor}")
	public ResponseEntity<List<Servidor>> getservidorByNome(@PathVariable("nomeservidor") String nomeservidor){
		List<Servidor> servidor = new ArrayList<Servidor>();
		try {
			servidorRepository.findBynomeservidorContaining(nomeservidor).forEach(servidor::add);
			if(servidor.isEmpty())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(servidor, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// adiciona um novo servidor e também adiciona seu saldo: 30% do valor do salário, na tabela saldoservidor
	@PostMapping("/servidor/criarservidor")
	public ResponseEntity<Servidor> createServidor(@RequestBody Servidor servidor){
		try {
			servidorService.addServidor(servidor);
			return new ResponseEntity<>(servidor, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Servidor>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// atualiza dados do servidor
	// TODO melhorar esse método no futuro
	// TODO atualizar de forma que não duplique os registros na tabela saldoservidor
	
	@PutMapping("/servidor/atualizar/{idservidor}")
	public ResponseEntity<Servidor> updateServidor(@PathVariable("idservidor") int idservidor, @RequestBody Servidor servidor){
			
				Optional<Servidor> servidorData = servidorRepository.findById(idservidor);
				if(servidorData.isPresent()){
						servidorService.addServidor(servidor);
																								
						return new ResponseEntity<>(HttpStatus.OK);
					}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
		}				
	
	// apaga os registros sobre um servidor específico
	@DeleteMapping("/servidor/deletar/{idservidor}") 
	public ResponseEntity<HttpStatus> deleteServidor(@PathVariable("idservidor") int idservidor){
		try {
			servidorRepository.deleteById(idservidor);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
