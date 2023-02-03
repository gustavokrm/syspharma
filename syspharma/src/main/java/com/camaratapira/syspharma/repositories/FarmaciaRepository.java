package com.camaratapira.syspharma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.camaratapira.syspharma.entity.Farmacia;

public interface FarmaciaRepository extends CrudRepository<Farmacia, Integer> {
	
	//o nome das interfaces deve ser igual ao das variaveis
	List<Farmacia> findByidfarmacia(int idfarmacia);
	List<Farmacia> findBynomefarmacia(String nomefarmacia);

}
