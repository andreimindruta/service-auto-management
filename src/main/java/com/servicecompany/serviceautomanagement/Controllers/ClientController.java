package com.servicecompany.serviceautomanagement.Controllers;

import com.servicecompany.serviceautomanagement.Entities.Client;
import com.servicecompany.serviceautomanagement.Entities.Masina;
import com.servicecompany.serviceautomanagement.Service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clienti")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    //Endpoint realizat pentru adaugarea unui nou client
    @PostMapping("/add")
    public ResponseEntity<Client> adaugaClient(@RequestBody Client client) {
        Client clientAdaugat = clientService.adaugaClient(client);
        return new ResponseEntity<>(clientAdaugat, HttpStatus.CREATED);
    }
    @PutMapping("actualizeaza/{id}")
    public ResponseEntity<Client> actualizeazaClient(@PathVariable long id, @RequestBody Client client) {
        Client clientActualizat = clientService.actualizeazaClient(id, client);
        if (clientActualizat != null) {
            return new ResponseEntity<>(clientActualizat, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("/dezactiveaza/{id}")
    public ResponseEntity<?> dezactiveazaClient (@PathVariable Long id) {
        clientService.dezactiveazaClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping ("/{clientId}/masini/adauga")
    public ResponseEntity<Masina> adaugaMasinaClient(@PathVariable Long clientId, @RequestBody Masina masina) {
        Masina masinaAdaugata = clientService.adaugaMasinaClient(clientId, masina);
        return new ResponseEntity<>(masinaAdaugata, HttpStatus.CREATED);
    }

    @PutMapping("/{clientId}/masini/actualizeaza/{masinaId}")
    public ResponseEntity<Masina> actualizeazaMasinaClient(@PathVariable Long clientId, @PathVariable Long masinaId, @RequestBody Masina masina) {
        Masina masinaActualizata = clientService.actualizeazaMasinaClient(clientId, masinaId, masina);
        if (masinaActualizata != null) {
            return new ResponseEntity<>(masinaActualizata, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{clientId}/masini/dezactiveaza/{masinaId}")
    public ResponseEntity<?> dezactiveazaMasinaClient (@PathVariable Long clientId, @PathVariable Long masinaId) {
        clientService.dezactiveazaMasinaClient(clientId, masinaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping ("/lista")
    public ResponseEntity <List<Client>> listaClienti() {
        List<Client> clienti = clientService.getClienti();
        return new ResponseEntity<>(clienti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
