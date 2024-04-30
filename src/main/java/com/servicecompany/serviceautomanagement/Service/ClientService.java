package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.Client;
import com.servicecompany.serviceautomanagement.Entities.Masina;

import java.util.List;

public interface ClientService {
    Client adaugaClient (Client client);
    List<Client> getClienti();
    Client getClientById(Long id);
    Client actualizeazaClient(Long id, Client clientNou);
    void dezactiveazaClient(Long id);
    void stergereClient(Long id);
    Masina adaugaMasinaClient (Long ClientId, Masina masina);
    Masina actualizeazaMasinaClient(Long clientId, Long masinaId, Masina masinaNoua);
    Masina dezactiveazaMasinaClient (Long clientId, Long masinaId);

}
