package com.servicecompany.serviceautomanagement.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Programare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Masina masina;

    private LocalDateTime dataProgramare;
    private String actiune;
    private int intervalTimp;  // in minute, multiplu de 30, intre orele 8-17

    public Programare(Client client, Masina masina, LocalDateTime dataProgramare, String actiune, int intervalTimp) {
        this.client = client;
        this.masina = masina;
        this.dataProgramare = dataProgramare;
        this.actiune = actiune;
        this.intervalTimp = intervalTimp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Masina getMasina() {
        return masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    public LocalDateTime getDataProgramare() {
        return dataProgramare;
    }

    public void setDataProgramare(LocalDateTime dataProgramare) {
        this.dataProgramare = dataProgramare;
    }

    public String getActiune() {
        return actiune;
    }

    public void setActiune(String actiune) {
        this.actiune = actiune;
    }

    public int getIntervalTimp() {
        return intervalTimp;
    }

    public void setIntervalTimp(int intervalTimp) {
        this.intervalTimp = validateIntervalTimp(intervalTimp);
    }
    private int validateIntervalTimp (int intervalTimp) {
        if (intervalTimp <30 || intervalTimp %30 != 0 || intervalTimp <8*60 || intervalTimp > 17*60) {
            throw new IllegalArgumentException("Intervalul de timp trebuie sa fie in minute, multiplu de 30, si sa fie intre orele 8:00 si 17:00.");
        }
        return intervalTimp;
    }
}

