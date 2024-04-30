package com.servicecompany.serviceautomanagement.Service;

import com.servicecompany.serviceautomanagement.Entities.Client;
import com.servicecompany.serviceautomanagement.Entities.Masina;
import com.servicecompany.serviceautomanagement.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client adaugaClient(Client client) {
       return clientRepository.save(client);
    }

    @Override
    public List<Client> getClienti() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client actualizeazaClient(Long id, Client clientNou) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            client.setNume(clientNou.getNume());
            client.setPrenume(clientNou.getPrenume());
            client.setNumereTelefon(clientNou.getNumereTelefon());
            client.setEmail(clientNou.getEmail());
            client.setMasini(clientNou.getMasini());
           return clientRepository.save(client);
        }
        return null;
    }

    @Override
    public void dezactiveazaClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client !=null) {
            client.setActiv(false);
            clientRepository.save(client);
        }
    }


    @Override
    public void stergereClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Masina adaugaMasinaClient (Long clientId, Masina masina) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            masina.setClient(client);
            List<Masina> masini = client.getMasini();
            masini.add(masina);
            client.setMasini(masini);
            clientRepository.save(client);
            return masina;
        } else {
            throw new RuntimeException("Clientul cu id-ul " + clientId + "nu a fost gasit");
        }
    }
    @Override
    public Masina actualizeazaMasinaClient (Long clientId, Long masinaId, Masina masinaNoua) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            List<Masina> masini = client.getMasini();
            if (masini != null){
                for (Masina masina:masini) {
                    if (masina.getId() == masinaId) {
                        masina.setNrInmatriculare(masinaNoua.getNrInmatriculare());
                        masina.setSerieSasiu(masinaNoua.getSerieSasiu());
                        masina.setMarca(masinaNoua.getMarca());
                        masina.setModel(masinaNoua.getModel());
                        masina.setAnFabricatie(masinaNoua.getAnFabricatie());
                        masina.setTipMotorizare(masinaNoua.getTipMotorizare());
                        masina.setCapacitateMotor(masinaNoua.getCapacitateMotor());
                        masina.setCaiPutere(masinaNoua.getCaiPutere());
                        clientRepository.save(client);
                        return masina;
                    }
                }
            }
        }
        throw new RuntimeException("Masina cu ID-ul " + masinaId + " nu a fost gasita pentru clientul cu ID-ul " + clientId);
    }

    @Override
    public Masina dezactiveazaMasinaClient(Long clientId, Long masinaId) {
        Optional <Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            List<Masina> masini = client.getMasini();
            for (Masina masina:masini) {
                if (masina.getId() == (masinaId)) {
                    masina.setActiv(false);
                    clientRepository.save(client);
                    return masina;
                }
            }
            throw new RuntimeException("Masina cu ID-ul " + masinaId + "nu a fost gasita pentru clientul cu ID-ul" + clientId);

        } else {
            throw new RuntimeException("Clientul cu ID-ul" + clientId + "nu a fost gasit.");
        }
    }
}

