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
import com.camaratapira.syspharma.entity.Funcao;
import com.camaratapira.syspharma.repositories.FuncaoRepository;
import com.camaratapira.syspharma.repositories.CargoRepository;

@RestController
@RequestMapping("/api")
public class FuncaoController {
	
	@Autowired
	FuncaoRepository funcaoRepository;
	
	@Autowired
	CargoRepository cargoRepository;
	
	@GetMapping("/funcao/listartodos")
	public ResponseEntity<List<Funcao>> getAllFuncaos(@RequestParam(required=false)String nomefuncao){
		List<Funcao> funcao = new ArrayList<Funcao>();
		
		try {
				funcaoRepository.findAll().forEach(funcao::add);
				if(funcao.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(funcao, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@GetMapping("/funcao/listarfuncao/{idfuncao}")
	public ResponseEntity<Funcao> getfuncaoById(@PathVariable("idfuncao") int idfuncao){
		Optional<Funcao> funcaoData = funcaoRepository.findById(idfuncao);
		
		if(funcaoData.isPresent())
			return new ResponseEntity<>(funcaoData.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(funcaoData.get(), HttpStatus.OK);
	}
	
	@PostMapping("/funcao/criarfuncao")
	public ResponseEntity<Funcao> createFuncao(@RequestBody Funcao funcao){
		try {
			Funcao _funcao = funcaoRepository.save(funcao);
			return new ResponseEntity<>(_funcao, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Funcao>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/funcao/atualizarfuncao")
	public ResponseEntity<Funcao> updateFuncao(@PathVariable("idfuncao") int idfuncao, @RequestBody Funcao funcao){
		Optional<Funcao> funcaoData = funcaoRepository.findById(idfuncao);
		if(funcaoData.isPresent()){
			Funcao _funcao = funcaoData.get();
			_funcao.setNomefuncao(funcao.getNomefuncao());
			_funcao.setNivelvencimento(funcao.getNivelvencimento());
			return new ResponseEntity<>(funcaoRepository.save(_funcao), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/funcao/deletarfuncao/{idfuncao}")
	public ResponseEntity<HttpStatus> deleteFuncao(@PathVariable("idfuncao") int idfuncao, @RequestBody Funcao funcao){
		try {
			funcaoRepository.deleteById(idfuncao);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
}
