package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.Programare;

import java.util.List;

public interface ProgramareService {
    Programare adaugaProgramare(Programare programare);
    List<Programare> getProgramari();
    Programare getProgramareById(Long id);
    Programare actualizeazaProgramare(Long id, Programare programareNoua);
    void stergeProgramare(Long id);
}
