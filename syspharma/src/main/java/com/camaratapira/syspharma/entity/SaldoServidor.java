package com.camaratapira.syspharma.entity;

import org.hibernate.annotations.Formula;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "saldoservidor")
public class SaldoServidor {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idsaldo;
	private String nomeservidor;
	@Formula("(select (s.salario * 30 / 100) from Servidor s)")
	private double saldo;
			
	public SaldoServidor(){}
		
	public Integer getIdsaldo() {
		return idsaldo;
	}
	public void setIdsaldo(Integer idsaldo) {
		this.idsaldo = idsaldo; 
	}
	public String getNomeservidor() {
		return nomeservidor;
	}
	public void setNomeservidor(String nomeservidor) {
		this.nomeservidor = nomeservidor;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public SaldoServidor(Integer idsaldo, String nomeservidor, double saldo) {
		super();
		this.idsaldo = idsaldo;
		this.nomeservidor = nomeservidor;
		this.saldo = saldo;
	}
		
	@OneToOne
	@JoinColumn(name = "idservidor")
	private Servidor servidor;
	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
}
