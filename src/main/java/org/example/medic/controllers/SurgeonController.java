package org.example.medic.controllers;

import org.example.medic.managers.MedicalManager;
import org.example.medic.models.Surgeon;
import org.example.medic.services.SurgeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/surgeon")
public class SurgeonController {

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
    public ResponseEntity<Collection<Surgeon>> getSurgeons(){
        return ResponseEntity.ok(surgeonService.getSurgeons());
    }

    @GetMapping("{id}")
    public ResponseEntity<Surgeon> getSurgeon(@PathVariable("id") int id) {
        Surgeon surgeon = surgeonService.getSurgeon(id);
        if (surgeon != null)
            return ResponseEntity.ok(surgeon);
        return ResponseEntity.notFound().build();
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
