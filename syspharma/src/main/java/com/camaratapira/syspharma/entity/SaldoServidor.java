package com.camaratapira.syspharma.entity;

import jakarta.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsaldo")
	private int idsaldo;
	@Column(name = "saldo")
	private double saldo;
	
	@OneToOne(targetEntity = Servidor.class)
	@JoinColumn(name = "matricula", referencedColumnName = "idservidor")
	private Servidor matricula;

	public int getIdsaldo() {
		return idsaldo;
	}
	
	public SaldoServidor() {}

	public SaldoServidor(int idsaldo, double saldo, Servidor matricula) {
		super();
		this.idsaldo = idsaldo;
		this.saldo = saldo;
		this.matricula = matricula;
	}

	public void setIdsaldo(int idsaldo) {
		this.idsaldo = idsaldo;
	}

	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Servidor getMatricula() {
		return matricula;
	}

	public void setMatricula(Servidor matricula) {
		this.matricula = matricula;
	}
	
}
