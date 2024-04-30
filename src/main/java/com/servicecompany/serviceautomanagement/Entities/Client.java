package com.servicecompany.serviceautomanagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nume;
    private String prenume;
    private String email;
    private boolean activ;

    @ElementCollection
    private List<String> numereTelefon; // lista care permite mai multe numere de telefon

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Masina> masini;

}

