package com.camaratapira.syspharma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	
	public Cargo() {}
	
	public Cargo(int idcargo, String descricaocargo){
		this.idcargo = idcargo;
		this.descricaocargo = descricaocargo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcargo")
	@JsonIgnore
	private int idcargo;
	
	@Column(name = "descricaocargo")
	private String descricaocargo;
	
	public int getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}
	public String getDescricaocargo() {
		return descricaocargo;
	}
	public void setDescricaocargo(String descricaocargo) {
		this.descricaocargo = descricaocargo;
	}
	
	
}
