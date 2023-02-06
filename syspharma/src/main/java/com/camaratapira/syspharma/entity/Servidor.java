package com.camaratapira.syspharma.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servidor")/*
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "insere_servidor", procedureName = "insere_servidor"),
	@NamedStoredProcedureQuery(name = "desativa_servidor", procedureName = "desativa_servidor")
})*/
public class Servidor {
	
	public Servidor(){}
	
	public Servidor(String nomeservidor, String cpf, String rg, double salario, boolean ativo) {
		
		this.nomeservidor = nomeservidor;
		this.rg = rg;
		this.cpf = cpf;
		this.salario = salario;
		this.ativo = ativo;
	}
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "idfuncao")
	private List<Funcao> nomeFuncao;
	
	public int getIdservidor() {
		return idservidor;
	}
	public void setIdservidor(int idservidor) {
		this.idservidor = idservidor;
	}
	public String getNomeservidor() {
		return nomeservidor;
	}
	public void setNomeservidor(String nomeservidor) {
		this.nomeservidor = nomeservidor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idservidor;
	
	@Column(name = "nomeservidor")
	private String nomeservidor;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "salario")
	private double salario;
	
	@Column(name = "ativo")
	private boolean ativo;
	
}
