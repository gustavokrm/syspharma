package com.camaratapira.syspharma.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camaratapira.syspharma.repositories.ComprasRepository;
import com.camaratapira.syspharma.repositories.SaldoServidorRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;
import com.camaratapira.syspharma.entity.Compras;
import com.camaratapira.syspharma.entity.SaldoServidor;
import com.camaratapira.syspharma.entity.Servidor;

@Service
public class ComprasService {
	
	@Autowired
	ComprasRepository comprasRepository;
	@Autowired
	ServidorRepository servidorRepository;
	@Autowired
	SaldoServidorRepository saldoServidorRepository;
	
	public void addCompras(Compras compras) {
		
		Servidor id = compras.getServidor();
		double val = compras.getValorcompra();	
				
		Optional<SaldoServidor> saldo = saldoServidorRepository.findAllByMatricula(id);

		try {
			
			if(saldo.isPresent()) {
				SaldoServidor _saldo = saldo.get();
				double sld =_saldo.getSaldo();
				if(sld < val) {
						System.out.println("Não foi possível realizar a compra, pois o saldo"
								+ "é insuficiente. Realize a compra fora do convênio.");
					} else {
						double total = sld - val;
						_saldo.setIdsaldo(_saldo.getIdsaldo());
						_saldo.setMatricula(id);
						_saldo.setSaldo(total);
						comprasRepository.save(compras);
						saldoServidorRepository.save(_saldo);
					}
			} else {
				System.out.println("Servidor não encontrado");
			}
		
		} catch (Exception e) {
			
			System.out.println("Não foi possível realizar a compra."
					+ "Ou o sistema não encontrou saldo associado a esse servidor ou"
					+ "o saldo do servidor é insuficiente. Verifique o saldo do servidor"
					+ "e tente novamente.");
			e.printStackTrace();
		}
	}  
}
