package com.camaratapira.syspharma.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

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
