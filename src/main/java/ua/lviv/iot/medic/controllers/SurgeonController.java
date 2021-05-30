package ua.lviv.iot.medic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.medic.exception.SurgeonNotFoundException;
import ua.lviv.iot.medic.models.Surgeon;
import ua.lviv.iot.medic.service.SurgeonService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/surgeon")
public class SurgeonController {

    private static final Logger LOGGER = Logger.getLogger("MedicLogger");

    @Autowired
    private SurgeonService surgeonService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Surgeon> getSurgeon(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(surgeonService.getSurgeon(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            LOGGER.severe("Surgeon " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Surgeon> getSurgeons(){
        return surgeonService.getSurgeons();
    }

    @PostMapping
    public ResponseEntity<Surgeon> addSurgeon(@RequestBody Surgeon surgeon){
        if (surgeon.getId() == null) {
            surgeonService.addSurgeon(surgeon);
            return new ResponseEntity<Surgeon>(surgeon, HttpStatus.OK);
        }
        LOGGER.severe("Failed to create a surgeon with passed id. Surgeon creation should not use external ids");
        return new ResponseEntity<Surgeon>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Surgeon> updateSurgeon(@PathVariable Integer id, @RequestBody Surgeon surgeon){
        try {
            surgeon.setId(id);
            surgeonService.updateSurgeon(id, surgeon);
            return new ResponseEntity<>(surgeon, HttpStatus.OK);
        } catch (SurgeonNotFoundException e) {
            LOGGER.severe("Can't update an surgeon with non-existing id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteSurgeon(@PathVariable Integer id){
        if (surgeonService.deleteSurgeon(id)){
            return ResponseEntity.ok("Successfully deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
