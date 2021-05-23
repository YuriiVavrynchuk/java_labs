package org.example.medic.repository;

import org.example.medic.models.Surgeon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeonRepository extends CrudRepository<Surgeon, Long> {
}