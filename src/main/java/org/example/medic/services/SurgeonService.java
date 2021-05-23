package org.example.medic.services;

import lombok.Data;
import org.example.medic.models.Surgeon;
import org.example.medic.repository.SurgeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Data
@ApplicationScope
public class SurgeonService {

    private SurgeonRepository repository;

    @Autowired
    public SurgeonService(SurgeonRepository repository) {
        this.repository = repository;
    }

    public Surgeon addSurgeon(Surgeon surgeon){
        repository.save(surgeon);
        return surgeon;
    }

    public  Surgeon updateSurgeon(int id, Surgeon surgeon){
        Surgeon surgeonToUpdate = repository.findById((long) id).orElse(null);
        if(surgeon != null) {
            surgeon = surgeon.copy();
            surgeon.setId((int) id);
            repository.save(surgeon);
        }
        return surgeonToUpdate;
    }

    public List<Surgeon> getSurgeons(){
        return StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public Surgeon getSurgeon(int id){
        return repository.findById((long) id).orElse(null);
    }

    public int deleteSurgeon(int id){
        Surgeon surgeon = repository.findById((long) id).orElse(null);
        if(surgeon!=null) {
            repository.deleteById((long) id);
            return id;
        }
        return -1;
    }
}