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
import com.camaratapira.syspharma.entity.Funcao;
import com.camaratapira.syspharma.repositories.FuncaoRepository;

@RestController
@RequestMapping("/api")
public class FuncaoController {
	
	@Autowired
	FuncaoRepository funcaoRepository;
	
	@GetMapping("/funcao")
	public ResponseEntity<List<Funcao>> getAllFuncaos(@RequestParam(required=false)String nomefuncao){
		List<Funcao> funcao = new ArrayList<Funcao>();
		
		try {
			if(nomefuncao == null)
				funcaoRepository.findAll().forEach(funcao::add);
			else
				funcaoRepository.findBynomefuncao(nomefuncao).forEach(funcao::add);
			if(funcao.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(funcao, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@GetMapping("/listarfuncao/{idfuncao}")
	public ResponseEntity<Funcao> getfuncaoById(@PathVariable("idfuncao") int idfuncao){
		Optional<Funcao> funcaoData = funcaoRepository.findById(idfuncao);
		
		if(funcaoData.isPresent())
			return new ResponseEntity<>(funcaoData.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(funcaoData.get(), HttpStatus.OK);
	}
	

	
}
