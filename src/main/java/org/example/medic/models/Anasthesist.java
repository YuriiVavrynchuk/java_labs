package org.example.medic.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class Anasthesist extends Medic {
    @NonNull Remedy remedy;

    public Anasthesist(String name, Department department, int duration, int avgSalary, int maxAge, Remedy remedy) {
        super(name, department, duration, avgSalary, maxAge);
        this.remedy = remedy;
    }
}
