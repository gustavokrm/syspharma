package com.camaratapira.syspharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camaratapira.syspharma.entity.SaldoServidor;
import com.camaratapira.syspharma.entity.Servidor;
import com.camaratapira.syspharma.repositories.SaldoServidorRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;

@Service
public class ServidorService {
	
	@Autowired
	ServidorRepository servidorRepository;	
	@Autowired
	SaldoServidorRepository saldoServidorRepository;

	public void addServidor(Servidor servidor) {
		
		SaldoServidor sal = new SaldoServidor();
		
		servidorRepository.save(servidor);
		
		double salario = servidor.getSalario();
		double saldo = (salario * 30 / 100);
		
		sal.setIdsaldo(sal.getIdsaldo());
		sal.setMatricula(servidor); 
		sal.setSaldo(saldo);
		saldoServidorRepository.save(sal);
				
	}	
}
