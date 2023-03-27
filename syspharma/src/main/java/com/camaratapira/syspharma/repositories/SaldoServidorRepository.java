package com.camaratapira.syspharma.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.camaratapira.syspharma.entity.SaldoServidor;
import com.camaratapira.syspharma.entity.Servidor;

public interface SaldoServidorRepository extends JpaRepository<SaldoServidor, Integer>{
	Optional<SaldoServidor> findAllByMatricula(final Servidor servidor);
	@Modifying
	@Query("update SaldoServidor sd set sd.saldo = :saldo where sd.matricula = :idservidor")
	void updateSaldo(@Param("idservidor") int idservidor, @Param("saldo") double saldo);
}
