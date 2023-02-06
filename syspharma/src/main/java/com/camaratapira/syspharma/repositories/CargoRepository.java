package com.camaratapira.syspharma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.camaratapira.syspharma.entity.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Integer>{
	List<Cargo> findByidcargo(int idcargo);
	List<Cargo> findBydescricaocargo(String descricaocargo);
}
