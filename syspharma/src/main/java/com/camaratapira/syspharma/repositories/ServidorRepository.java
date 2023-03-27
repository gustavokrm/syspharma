package com.camaratapira.syspharma.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.camaratapira.syspharma.entity.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Integer>{
	List<Servidor> findByidservidor(int idservidor);
	List<Servidor> findBynomeservidorContaining(String nomeservidor);
	
}