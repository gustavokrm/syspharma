package com.camaratapira.syspharma.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.camaratapira.syspharma.entity.SaldoServidor;
import com.camaratapira.syspharma.entity.Servidor;

public interface SaldoServidorRepository extends JpaRepository<SaldoServidor, Integer>{
	Optional<SaldoServidor> findAllByMatricula(final Servidor servidor);
	
}
