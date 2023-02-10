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

    private String nomecompra;

    public String getNomecompra() {
        return nomecompra;
    }

    public void setNomecompra(String nomecompra) {
        this.nomecompra = nomecompra;
    }
    @ManyToOne
    @JoinColumn(name = "servidor_idservidor")
    private Servidor servidor;

    @ManyToOne
    @JoinColumn(name = "dependentes_iddependente")
    private Dependentes dependentes;

    @ManyToOne
    @JoinColumn(name = "farmacia_idfarmacia")
    private Farmacia farmacia;

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

    public Compras(){}

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
