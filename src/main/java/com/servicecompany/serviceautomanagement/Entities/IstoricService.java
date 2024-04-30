package com.servicecompany.serviceautomanagement.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class IstoricService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Masina masina;

    private LocalDateTime dataPrimire;
    private LocalDateTime dataProcesare;
    private String problemeDescoperite;
    private String operatiuniEfectuate;

    private boolean reparata;
    private int durataReparatie;  //in min., multiplu de 10

    public IstoricService(Masina masina, LocalDateTime dataPrimire, LocalDateTime dataProcesare, String problemeDescoperite, String operatiuniEfectuate, boolean reparata, int durataReparatie) {
        this.masina = masina;
        this.dataPrimire = dataPrimire;
        this.dataProcesare = dataProcesare;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Masina getMasina() {
        return masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    public LocalDateTime getDataPrimire() {
        return dataPrimire;
    }

    public void setDataPrimire(LocalDateTime dataPrimire) {
        this.dataPrimire = dataPrimire;
    }

    public LocalDateTime getDataProcesare() {
        return dataProcesare;
    }

    public void setDataProcesare(LocalDateTime dataProcesare) {
        this.dataProcesare = dataProcesare;
    }

    public String getProblemeDescoperite() {
        return problemeDescoperite;
    }

    public void setProblemeDescoperite(String problemeDescoperite) {
        this.problemeDescoperite = problemeDescoperite;
    }

    public String getOperatiuniEfectuate() {
        return operatiuniEfectuate;
    }

    public void setOperatiuniEfectuate(String operatiuniEfectuate) {
        this.operatiuniEfectuate = operatiuniEfectuate;
    }

    public boolean isReparata() {
        return reparata;
    }

    public void setReparata(boolean reparata) {
        this.reparata = reparata;
    }

    public int getDurataReparatie() {
        return durataReparatie;
    }

    public void setDurataReparatie(int durataReparatie) {
        if (durataReparatie%10 !=0) {
            throw new IllegalArgumentException("Durata reparatiei trebuie sa fie in minute si multiplu de 10.");
        }
        this.durataReparatie = durataReparatie;
    }
}
