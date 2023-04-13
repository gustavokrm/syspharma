package com.camaratapira.syspharma.entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompras")
    private int idcompras;
    @Column(name = "valorcompra")
    private double valorcompra;
    @Column(name = "datacompra")
    private Timestamp datacompra;

    public Compras(){}

    @ManyToOne
    @JoinColumn(name = "servidor_idservidor")
    private Servidor servidor_idservidor;

    public Servidor getServidor_idservidor() {
        return servidor_idservidor;
    }

    public void setServidor_idservidor(Servidor servidor_idservidor) {
        this.servidor_idservidor = servidor_idservidor;
    }
    @ManyToOne
    @JoinColumn(name = "dependentes_iddependente")
    private Dependentes dependentes_iddependentes;

    public Dependentes getDependentes_iddependentes() {
        return dependentes_iddependentes;
    }

    public void setDependentes_iddependentes(Dependentes dependentes_iddependentes) {
        this.dependentes_iddependentes = dependentes_iddependentes;
    }
    
    @ManyToOne
    @JoinColumn(name = "farmacia_idfarmacia")
    private Farmacia farmacia_idfarmacia;

    public Farmacia getFarmacia_idfarmacia() {
        return farmacia_idfarmacia;
    }

    public void setFarmacia_idfarmacia(Farmacia farmacia_idfarmacia) {
        this.farmacia_idfarmacia = farmacia_idfarmacia;
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
