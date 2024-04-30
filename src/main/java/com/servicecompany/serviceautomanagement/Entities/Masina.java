package com.servicecompany.serviceautomanagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nrInmatriculare;
    private String serieSasiu;
    private String marca;
    private String model;
    private int anFabricatie;
    private String tipMotor;
    private double capacitateMotor;
    private int caiPutere;
    private boolean activ;

    @ManyToOne
    private Client client;

    public Masina(String nrInmatriculare, String serieSasiu, String marca, String model, int anFabricatie, String tipMotor, double capacitateMotor, int caiPutere, Client client) {
        this.nrInmatriculare = nrInmatriculare;
        this.serieSasiu = serieSasiu;
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.tipMotor = tipMotor;
        this.capacitateMotor = capacitateMotor;
        this.caiPutere = caiPutere;
        this.client = client;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getSerieSasiu() {
        return serieSasiu;
    }

    public void setSerieSasiu(String serieSasiu) {
        this.serieSasiu = serieSasiu;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getTipMotorizare() {
        return tipMotor;
    }

    public void setTipMotorizare(String tipMotor) {
        this.tipMotor = tipMotor;
    }

    public double getCapacitateMotor() {
        return capacitateMotor;
    }

    public void setCapacitateMotor(double capacitateMotor) {
        this.capacitateMotor = capacitateMotor;
    }

    public int getCaiPutere() {
        return caiPutere;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCaiPutere(int caiPutere) {
        this.caiPutere = caiPutere;
    }


    public double getKwPutere() {
        return this.caiPutere / 1.34102;
    }

    public boolean isActiv() {
        return activ;
    }
    public void setActiv (boolean activ) {
        this.activ = activ;
    }


}
