package com.camaratapira.syspharma.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompras")
    private int idcompras;
    
    @Column(name = "valorcompra")
    private double valorcompra;
    
    @Column(name = "datacompra")
    private Timestamp datacompra;
        	
	@ManyToOne
    @JoinColumn(name = "idservidor")
    private Servidor idservidor;

    @ManyToOne
    @JoinColumn(name = "iddependente")
    private Dependentes dependentes;

    @ManyToOne
    @JoinColumn(name = "idfarmacia")
    private Farmacia farmacia;
    
    public Compras(){}
       
	public Servidor getServidor() {
        return idservidor;
    }

    public void setServidor(Servidor idservidor) {
        this.idservidor = idservidor;
    }

    public Dependentes getDependentes() {
        return dependentes;
    }

    public void setDependentes(Dependentes dependentes) {
        this.dependentes = dependentes;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public int getIdcompras() {
        return idcompras;
    }
    public void setIdcompras(int idcompras) {
        this.idcompras = idcompras;
    }
    public double getValorcompra() {
        return valorcompra;
    }
    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
        
    }
    public Timestamp getDatacompra() {
        return datacompra;
    }
    public void setDatacompra(Timestamp datacompra) {
        this.datacompra = datacompra;
    }
    public Compras(double valorcompra, Timestamp datacompra) {
        this.valorcompra = valorcompra;
        this.datacompra = datacompra;
    } 
       
}
