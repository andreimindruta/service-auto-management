package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.IstoricService;
import com.servicecompany.serviceautomanagement.Repository.IstoricServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IstoricMasinaServiceImpl implements IstoricMasinaService{
    private IstoricServiceRepository istoricRepository;
    @Override
    public IstoricService adaugaIstoric(IstoricService istoric) {
        return istoricRepository.save(istoric);
    }

    @Override
    public List<IstoricService> getIstoric() {
        return istoricRepository.findAll();
    }

    @Override
    public IstoricService getIstoricById(Long id) {
        return istoricRepository.findById(id).orElse(null);
    }

    @Override
    public IstoricService actualizeazaIstoric(Long id, IstoricService istoricNou) {
        IstoricService istoric = istoricRepository.findById(id).orElse(null);
        if (istoric != null) {
           return istoricRepository.save(istoric);
        }
        return null;
    }

    @Override
    public void stergeIstoric(Long id) {
        istoricRepository.deleteById(id);
    }
}
