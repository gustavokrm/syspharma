package com.camaratapira.syspharma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servidor")
public class Servidor {
	
	@Id
	@Column(name = "idservidor")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // outras estratégias precisam de tabelas específicas no Banco de dados
	private Integer idservidor;
	
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
		
	@ManyToOne()
	@JoinColumn(name = "idfuncao")
	private Funcao funcao; // necessário fazer os métodos getters e setters dessas funções para poderem retornar as 
	// chaves estrangeiras quando você fizer uma requisição GET, caso contrário, o sistema não vai saber onde procurar.
	

	public Integer getIdservidor() {
		return idservidor;
	}
	
	public Servidor() {}
	
	public Servidor(Integer idservidor, String nomeservidor, String cpf, String rg, double salario, boolean ativo,
			Funcao funcao) {
		super();
		this.idservidor = idservidor;
		this.nomeservidor = nomeservidor;
		this.cpf = cpf;
		this.rg = rg;
		this.salario = salario;
		this.ativo = ativo;
		this.funcao = funcao;
	}

	public void setIdservidor(Integer idservidor) {
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


	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
}
