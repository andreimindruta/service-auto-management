package com.servicecompany.serviceautomanagement.Controllers;

import com.servicecompany.serviceautomanagement.Entities.IstoricService;
import com.servicecompany.serviceautomanagement.Service.IstoricMasinaService;
import com.servicecompany.serviceautomanagement.Service.IstoricMasinaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/istoric")
@Slf4j
public class IstoricServiceController {
    private final IstoricMasinaService istoricService;

    public IstoricServiceController (IstoricMasinaService istoricService) {
        this.istoricService = istoricService;
    }

    @PostMapping("/adauga")
    public ResponseEntity<IstoricService> adaugaIstoric(@RequestBody IstoricService istoric) {
        IstoricService istoricNou = istoricService.adaugaIstoric(istoric);
        return new ResponseEntity<>(istoricNou, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<IstoricService>> listaIstoric() {
        List<IstoricService> istoricList = istoricService.getIstoric();
        return new ResponseEntity<>(istoricList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IstoricService> getIstoricById(@PathVariable Long id) {
        IstoricService istoric = istoricService.getIstoricById(id);
        if (istoric != null) {
            return new ResponseEntity<>(istoric, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<IstoricService> actualizeazaIstoric(@PathVariable Long id, @RequestBody IstoricService istoricNou) {
        IstoricService istoricActualizat = istoricService.actualizeazaIstoric(id, istoricNou);
        if (istoricActualizat != null) {
            return new ResponseEntity<>(istoricActualizat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeIstoric(@PathVariable Long id) {
        istoricService.stergeIstoric(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
