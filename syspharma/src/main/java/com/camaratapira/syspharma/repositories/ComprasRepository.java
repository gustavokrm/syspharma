package com.camaratapira.syspharma.repositories;


import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.camaratapira.syspharma.entity.Compras;
import com.camaratapira.syspharma.entity.Servidor;

import jakarta.transaction.Transactional;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{
	List<Compras> findByIdcompras(int idcompras);
	List<Compras> findAllByIdservidor(final Servidor servidor);
	
	@Transactional
	@Modifying
	@Query(value = "{call realiza_compra(:sp_idcompra, :sp_idfarmacia, :sp_idservidor, :sp_iddependente, "
			+ ":sp_valorcompra, :sp_datacompra)}", nativeQuery = true)
	void fazerCompras(@Param("sp_idcompra") Integer idcompras, @Param("sp_idfarmacia") Integer idfarmacia, 
			@Param("sp_idservidor") Integer idservidor, @Param("sp_iddependente") Integer iddependentes,
			@Param("sp_valorcompra") double valorcompra, @Param("sp_datacompra") Timestamp datacompra);
}
