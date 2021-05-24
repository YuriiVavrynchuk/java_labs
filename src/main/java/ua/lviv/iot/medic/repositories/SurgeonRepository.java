package ua.lviv.iot.medic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.medic.models.Surgeon;

@Repository
public interface SurgeonRepository extends JpaRepository<Surgeon, Integer> {
}
