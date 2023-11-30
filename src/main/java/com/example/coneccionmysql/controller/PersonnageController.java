package com.example.coneccionmysql.controller;

import com.example.coneccionmysql.model.Personnage;
import com.example.coneccionmysql.service.PersonnageService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personages")
public class PersonnageController {
    //injection dependencia
    //@Autowired
    private final PersonnageService personnageService;

    public PersonnageController(PersonnageService personnageService) { //with @Autowired, I don't need the contructor
        this.personnageService = personnageService;
    }

    //create a new Personnage
    @Operation(summary = "Create a personnage ")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid  Personnage personnage){
       return ResponseEntity.status(HttpStatus.CREATED).body(personnageService.save(personnage)) ;//201

    }

    //read a user
    @Operation(summary = "Get a personnage by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable int id){
        Optional<Personnage> opersonnage = personnageService.findById(id);
        if(opersonnage.isEmpty()){
            return ResponseEntity.notFound().build();//404
        }
        return ResponseEntity.ok(opersonnage);//200
    }

    //update un personnage
    @Operation(summary = "Update a personnage by id")
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@RequestBody Personnage personnageDetails, @PathVariable (value = "id") int persoId) {
        Optional<Personnage> personnage = personnageService.findById(persoId); //optional don have null
        if(personnage.isEmpty()){
            return ResponseEntity.notFound().build();//404
        }
        personnage.get().setNom(personnageDetails.getNom());
        personnage.get().setPoint_de_vie(personnageDetails.getPoint_de_vie());
        personnage.get().setType(personnageDetails.getType());

        return ResponseEntity.status(HttpStatus.CREATED).body(personnageService.save(personnage.get()));//201

    }
    //delete an personnage
    @Operation(summary = "Delete a personnage by id")
    @DeleteMapping("/{id}")
    public  ResponseEntity<?>delete(@PathVariable int id){
        if(personnageService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        personnageService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    //read all
    @Operation(summary = "List all personnage")
    @GetMapping
    public List<Personnage> readAll(){
        return  personnageService.findAll();
    }


}
