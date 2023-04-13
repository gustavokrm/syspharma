package com.camaratapira.syspharma.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.camaratapira.syspharma.entity.Compras;
import com.camaratapira.syspharma.entity.Servidor;

public interface ComprasRepository extends JpaRepository<Compras, Integer>, PagingAndSortingRepository<Compras, Integer>{
	List<Compras> findByIdcompras(int idcompras);
	List<Compras> findAllByIdservidor(final Servidor servidor);
	
}
