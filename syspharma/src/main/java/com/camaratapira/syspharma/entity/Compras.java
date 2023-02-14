package com.camaratapira.syspharma.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompras")
    private int idcompras;
    
    @Column(name = "valorcompra")
    private double valorcompra;
    
    @Column(name = "datacompra")
    private Timestamp datacompra;
    
    @Column(name = "descricaoCompra")
    private String descricaoCompra;
   
    public String getDescricaoCompra() {
		return descricaoCompra;
	}

	public void setDescricaoCompra(String descricaoCompra) {
		this.descricaoCompra = descricaoCompra;
	}
	
	@ManyToOne
    @JoinColumn(name = "idservidor")
    private Servidor servidor;

    @ManyToOne
    @JoinColumn(name = "iddependente")
    private Dependentes dependentes;

    @ManyToOne
    @JoinColumn(name = "idfarmacia")
    private Farmacia farmacia;
    
    public Compras(){}

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
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
    public Compras(double valorcompra, Timestamp datacompra, String descricaoCompra) {
        this.valorcompra = valorcompra;
        this.datacompra = datacompra;
        this.descricaoCompra = descricaoCompra;
    }
}
