package com.camaratapira.syspharma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.camaratapira.syspharma.entity.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Integer>{
	List<Servidor> findByidservidor(int idservidor);
	List<Servidor> findBynomeservidor(String nomeservidor);
	
	/*
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "call insere_servidor(:sp_idservidor, :sp_nomeservidor, :sp_cpf, :sp_idfuncao, :sp_salario, sp_ativo)")
	void insertservidorById(@Param("idservidor") int idservidor); */
}
