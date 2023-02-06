package com.camaratapira.syspharma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcao")
public class Funcao {
	
	public Funcao() {}
	
	public Funcao(int idfuncao, String nomefuncao, int nivelvencimento) {
		this.idfuncao = idfuncao;
		this.nomefuncao = nomefuncao;
		this.nivelvencimento = nivelvencimento;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfuncao;
	
	@Column(name = "nomefuncao")
	private String nomefuncao;
	@Column(name = "nivelvencimento")
	private int nivelvencimento;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcargo")
	private Cargo idcargo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idservidor")
	private Servidor idservidor;
	
	public int getIdfuncao() {
		return idfuncao;
	}
	public void setIdfuncao(int idfuncao) {
		this.idfuncao = idfuncao;
	}
	public String getNomefuncao() {
		return nomefuncao;
	}
	public void setNomefuncao(String nomefuncao) {
		this.nomefuncao = nomefuncao;
	}
	public int getNivelvencimento() {
		return nivelvencimento;
	}
	public void setNivelvencimento(int nivelvencimento) {
		this.nivelvencimento = nivelvencimento;
	}

	
}
