package com.camaratapira.syspharma.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.camaratapira.syspharma.entity.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Integer>, PagingAndSortingRepository<Servidor, Integer>{
	List<Servidor> findByidservidor(int idservidor);
	List<Servidor> findBynomeservidorContaining(String nomeservidor);
	
}