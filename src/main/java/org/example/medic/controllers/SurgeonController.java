package org.example.medic.controllers;

import org.example.medic.models.Surgeon;
import org.example.medic.services.SurgeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestController
@RequestMapping("/surgeon")
public class SurgeonController {

    private static final Logger LOGGER = Logger.getLogger("org.example.medic.controllers.SurgeonController");

    @Autowired
    private SurgeonService surgeonService;

    @PostMapping
    public ResponseEntity<Surgeon> addSurgeon(@RequestBody Surgeon surgeon){
        return ResponseEntity.ok(surgeonService.addSurgeon(surgeon));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Surgeon> updateSurgeon(@PathVariable Integer id,@RequestBody Surgeon surgeon){
        Surgeon elementToUpdate = surgeonService.getSurgeons().get(id);
        if (elementToUpdate != null) {
            surgeon.setId(id);
            surgeonService.updateSurgeon(id, surgeon);
            return ResponseEntity.ok(elementToUpdate);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Surgeon>> getSurgeons() {
        try {
            return ResponseEntity.ok(surgeonService.getSurgeons());
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Surgeon> getSurgeon(@PathVariable("id") int id) {
        try {
            Surgeon surgeon = surgeonService.getSurgeon(id);
            if (surgeon != null)
                return ResponseEntity.ok(surgeon);
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePenguin(@PathVariable("id") int id){
        Surgeon surgeonToDelete = surgeonService.getSurgeons().get(id);
        if(surgeonToDelete != null) {
            surgeonService.deleteSurgeon(id);
            return ResponseEntity.ok("Your element was successfully deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
