package org.example.medic.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class Surgeon extends Medic{
    @NonNull Organ organ;

    public Surgeon(String name, Department department, int duration, int avgSalary, int maxAge, Organ organ) {
        super(name, department, duration, avgSalary, maxAge);
        this.organ = organ;
    }
}
