package org.example.medic.services;

import org.example.medic.models.Surgeon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SurgeonService {

    AtomicInteger counter = new AtomicInteger(0);

    private final Map<Integer, Surgeon> surgeons;

    public SurgeonService(HashMap<Integer, Surgeon> surgeons) {
        this.surgeons = surgeons;
    }

    public Surgeon addSurgeon(Surgeon surgeon){
        surgeon.setId(counter.incrementAndGet());
        surgeons.put(surgeon.getId(), surgeon);
        return surgeon;
    }

    public  Surgeon updateSurgeon(Integer id, Surgeon surgeon){
        surgeons.put(id, surgeon);
        return surgeon;
    }

    public List<Surgeon> getSurgeons(){
        return new ArrayList<>(surgeons.values());
    }

    public Surgeon getSurgeon(int id){
        return surgeons.get(id);
    }

    public void deleteSurgeon(Integer id){
        surgeons.remove(id);
    }
}