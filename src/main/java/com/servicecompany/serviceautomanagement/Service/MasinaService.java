package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.Masina;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MasinaService {
    Masina adaugaMasina(Masina masina);
    List<Masina> getMasini();
    Masina getMasinaById (Long id);
    Masina actualizeazaMasina(Long id, Masina masinaNoua);
    void stergeMasina (Long id);
}
