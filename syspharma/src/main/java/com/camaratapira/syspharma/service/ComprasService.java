package com.camaratapira.syspharma.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.camaratapira.syspharma.entity.Compras;
import com.camaratapira.syspharma.entity.SaldoServidor;

@Service
public class ComprasService {
	
	public void comprar(@RequestBody Compras compras) {
		
		Compras comp = new Compras();
		SaldoServidor sal = new SaldoServidor();
		
		double valorcompra = comp.getValorcompra();
		double saldo = sal.getSaldo();
		double total = saldo - valorcompra;
		if(saldo < valorcompra) {
			System.out.println("Saldo insuficiente");
		} else {
			sal.setSaldo(total);
		}
	}
	
}
