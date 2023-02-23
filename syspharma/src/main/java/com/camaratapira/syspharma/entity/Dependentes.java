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
@Table(name = "dependentes")

public class Dependentes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddependente")
	private int iddependente;
	@Column(name = "nomedependente")
	private String nomedependente;
	@Column(name="cpfdependente")
	private String cpfdependente;
	@Column(name="rgdependente")
	private String rgdependente;
	
	@ManyToOne()
	@JoinColumn(name = "idservidor")
	private Servidor servidor;
	
	public Dependentes() {}
	
	public Dependentes(String nomeDependente, String cpfdependente, String rgdependente) {
		super();
		this.nomedependente = nomeDependente;
		this.cpfdependente = cpfdependente;
		this.rgdependente = rgdependente;
	}
	public int getIddependente() {
		return iddependente;
	}
	public void setIddependente(int iddependente) {
		this.iddependente = iddependente;
	}
	public String getNomedependente() {
		return nomedependente;
	}
	public void setNomedependente(String nomedependente) {
		this.nomedependente = nomedependente;
	}
	public String getCpfdependente() {
		return cpfdependente;
	}
	public void setCpfdependente(String cpfdependente) {
		this.cpfdependente = cpfdependente;
	}
	public String getRgdependente() {
		return rgdependente;
	}
	public void setRgdependente(String rgdependente) {
		this.rgdependente = rgdependente;
	}
	
	public Servidor getServidor() {
		return servidor;
	}
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
}
