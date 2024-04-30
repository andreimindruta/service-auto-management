package com.servicecompany.serviceautomanagement.Controllers;

import com.servicecompany.serviceautomanagement.Entities.Client;
import com.servicecompany.serviceautomanagement.Entities.Masina;
import com.servicecompany.serviceautomanagement.Service.ClientService;
import com.servicecompany.serviceautomanagement.Service.MasinaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masini")
@Slf4j
public class MasinaController {

    private final MasinaService masinaService;
    private final ClientService clientService;

    @Autowired
    public MasinaController(MasinaService masinaService, ClientService clientService) {
        this.masinaService = masinaService;
        this.clientService = clientService;
    }

    @PostMapping("/adauga/{clientId}")
    public ResponseEntity<Masina> adaugaMasina(@PathVariable Long clientId, @RequestBody Masina masina) {
        Client client = clientService.getClientById(clientId);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        masina.setClient(client);
        Masina masinaNoua = masinaService.adaugaMasina(masina);
        return new ResponseEntity<>(masinaNoua, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Masina>> listaMasini() {
        List<Masina> masini = masinaService.getMasini();
        return new ResponseEntity<>(masini, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Masina> detaliiMasina(@PathVariable Long id) {
        Masina masina = masinaService.getMasinaById(id);
        if (masina == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(masina, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Masina> actualizeazaMasina(@PathVariable Long id, @RequestBody Masina masinaNoua) {
        Masina masinaActualizata = masinaService.actualizeazaMasina(id, masinaNoua);
        if (masinaActualizata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(masinaActualizata, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeMasina(@PathVariable Long id) {
        masinaService.stergeMasina(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}