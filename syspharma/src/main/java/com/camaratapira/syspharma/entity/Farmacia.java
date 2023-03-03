package com.camaratapira.syspharma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmacia")
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // identidade, pois o modo de geração auto requer classes adicionais
	@Column(name="idfarmacia")
	private int idfarmacia;
	@Column(name="nomefarmacia")
	private String nomefarmacia;
	@Column(name="cnpjfarmacia")
	private String cnpjfarmacia;
	@Column(name="nomeresponsavel")
	private String nomeresponsavel;
	@Column(name="telefonefarmacia")
	private String telefonefarmacia;
	
	// método construtor necessário para que o Hibernate funcione
	public Farmacia() {}
	
	public int getIdfarmacia() {
		return idfarmacia;
	}

	public void setIdfarmacia(int idfarmacia) {
		this.idfarmacia = idfarmacia;
	}

	public String getNomefarmacia() {
		return nomefarmacia;
	}

	public void setNomefarmacia(String nomefarmacia) {
		this.nomefarmacia = nomefarmacia;
	}

	public String getCnpjfarmacia() {
		return cnpjfarmacia;
	}

	public void setCnpjfarmacia(String cnpjfarmacia) {
		this.cnpjfarmacia = cnpjfarmacia;
	}

	public String getNomeresponsavel() {
		return nomeresponsavel;
	}

	public void setNomeresponsavel(String nomeresponsavel) {
		this.nomeresponsavel = nomeresponsavel;
	}

	public String getTelefonefarmacia() {
		return telefonefarmacia;
	}

	public void setTelefonefarmacia(String telefonefarmacia) {
		this.telefonefarmacia = telefonefarmacia;
	}
	
	// para poder ficar bonitinho na hora de ler os resultados
	public Farmacia(String nomefarmacia, String cnpjfarmacia, String nomeresponsavel, String telefonefarmacia) {
		this.nomefarmacia = nomefarmacia;
		this.cnpjfarmacia = cnpjfarmacia;
		this.nomeresponsavel = nomeresponsavel;
		this.telefonefarmacia = telefonefarmacia;
	}
	
	
}
