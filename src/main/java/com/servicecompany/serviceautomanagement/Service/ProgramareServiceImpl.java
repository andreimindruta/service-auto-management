package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.Programare;
import com.servicecompany.serviceautomanagement.Repository.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProgramareServiceImpl implements ProgramareService{
    @Autowired
    private ProgramareRepository programareRepository;
    @Override
    public Programare adaugaProgramare(Programare programare) {
        return programareRepository.save(programare);
    }

    @Override
    public List<Programare> getProgramari() {
        return programareRepository.findAll();
    }

    @Override
    public Programare getProgramareById(Long id) {
        return programareRepository.findById(id).orElse(null);
    }

    @Override
    public Programare actualizeazaProgramare(Long id, Programare programareNoua) {
        Programare programare = programareRepository.findById(id).orElse(null);
        if(programare != null) {
            programare.setMasina(programareNoua.getMasina());
            programare.setActiune(programareNoua.getActiune());
            programare.setIntervalTimp(programareNoua.getIntervalTimp());
          return  programareRepository.save(programare);
        }
        return null;
    }

    @Override
    public void stergeProgramare(Long id) {
        programareRepository.deleteById(id);
    }
}
