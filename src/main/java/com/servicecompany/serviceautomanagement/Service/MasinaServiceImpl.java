package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.Masina;
import com.servicecompany.serviceautomanagement.Repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MasinaServiceImpl implements MasinaService{
    @Autowired
    private MasinaRepository masinaRepository;
    @Override
    public Masina adaugaMasina(Masina masina) {

        return masinaRepository.save(masina);
    }

    @Override
    public List<Masina> getMasini() {
        return masinaRepository.findAll();
    }

    @Override
    public Masina getMasinaById(Long id) {
        return masinaRepository.findById(id).orElse(null);
    }

    @Override
    public Masina actualizeazaMasina(Long id, Masina masinaNoua) {
        Masina masina = masinaRepository.findById(id).orElse(null);
        if (masina !=null) {
            masina.setNrInmatriculare(masinaNoua.getNrInmatriculare());
            masina.setSerieSasiu(masinaNoua.getSerieSasiu());
            masina.setMarca(masinaNoua.getMarca());
            masina.setModel(masinaNoua.getModel());
            masina.setAnFabricatie(masinaNoua.getAnFabricatie());
            masina.setTipMotorizare(masinaNoua.getTipMotorizare());
            masina.setCapacitateMotor(masinaNoua.getCapacitateMotor());
            masina.setCaiPutere(masinaNoua.getCaiPutere());
          return  masinaRepository.save(masina);
        }
        return null;
    }

    @Override
    public void stergeMasina(Long id) {
        masinaRepository.deleteById(id);
    }
}
