package com.camaratapira.syspharma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camaratapira.syspharma.entity.Dependentes;

public interface DependenteRepository extends JpaRepository<Dependentes, Integer>{
	List<Dependentes> findByiddependente(int iddependente);
	List<Dependentes> findBynomedependente(String nomedependente);
}
