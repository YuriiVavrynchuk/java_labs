package ua.lviv.iot.medic.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
public class Surgeon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String department;
    int duration;
    int avgSalary;
    int maxAge;

    public Surgeon copy(){
        return new Surgeon(this.id, this.name, this.department, this.duration, this.avgSalary, this.maxAge);
    }

}
