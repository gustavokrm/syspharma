package com.camaratapira.syspharma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.camaratapira.syspharma.entity.Funcao;

public interface FuncaoRepository extends CrudRepository<Funcao, Integer> {
	List<Funcao> findByidfuncao(int idfuncao);
	List<Funcao> findByidcargo(int idcargo);
}
