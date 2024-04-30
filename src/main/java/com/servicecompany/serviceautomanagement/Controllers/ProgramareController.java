package com.servicecompany.serviceautomanagement.Controllers;

import com.servicecompany.serviceautomanagement.Entities.Programare;
import com.servicecompany.serviceautomanagement.Service.ProgramareService;
import jdk.javadoc.doclet.Reporter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programari")
@Slf4j
public class ProgramareController {

    private final ProgramareService programareService;

    @Autowired
    public  ProgramareController (ProgramareService programareService){
        this.programareService = programareService;
    }

    @PostMapping ("/adauga")
    public ResponseEntity<Programare> adaugaProgramare (@RequestBody Programare programare) {
        Programare programareNoua = programareService.adaugaProgramare(programare);
        return new ResponseEntity<>(programareNoua, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Programare>>listaProgramari() {
        List<Programare> programari = programareService.getProgramari();
        return new ResponseEntity<>(programari, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Programare> getProgramareById (@PathVariable("id") Long id) {
        Programare programare = programareService.getProgramareById(id);
        return new ResponseEntity<>(programare, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Programare> actualizeazaProgramare (@PathVariable("id") Long id, @RequestBody Programare programareNoua) {
        Programare programareActualizata = programareService.actualizeazaProgramare(id, programareNoua);
        return new ResponseEntity<>(programareActualizata, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Programare> stergeProgramare (@PathVariable("id") Long id) {
        programareService.stergeProgramare(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
