package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.IstoricService;

import java.util.List;

public interface IstoricMasinaService {
    IstoricService adaugaIstoric (IstoricService istoric);
    List<IstoricService> getIstoric();
    IstoricService getIstoricById (Long id);
    IstoricService actualizeazaIstoric(Long id, IstoricService istoricNou);
    void stergeIstoric(Long id);
}
