package com.camaratapira.syspharma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.camaratapira.syspharma.entity.Funcao;
import com.camaratapira.syspharma.entity.Servidor;

import jakarta.transaction.Transactional;

public interface ServidorRepository extends JpaRepository<Servidor, Integer>{
	List<Servidor> findByidservidor(int idservidor);
	List<Servidor> findBynomeservidor(String nomeservidor);
}