package ua.lviv.iot.medic.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.lviv.iot.medic.repositories.SurgeonRepository;
import ua.lviv.iot.medic.exception.SurgeonNotFoundException;
import ua.lviv.iot.medic.models.Surgeon;
import java.util.List;

@Service
@Data
@ApplicationScope
public class SurgeonService {

    private SurgeonRepository repository;

    @Autowired
    public SurgeonService(SurgeonRepository surgeonRepository) {
        this.repository = surgeonRepository;
    }
    public void addSurgeon(Surgeon surgeon){
        repository.save(surgeon);
    }

    public Surgeon updateSurgeon(Integer id, Surgeon surgeon) throws SurgeonNotFoundException {
        if (repository.existsById(surgeon.getId())) {
            surgeon.setId(id);
            return repository.save(surgeon);
        }
        throw new SurgeonNotFoundException("Surgeon " + surgeon.getId() + " not found");
    }

    public List<Surgeon> getSurgeons(){
        return repository.findAll();
    }

    public Surgeon getSurgeon(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public boolean deleteSurgeon(Integer id){
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
