package org.example.medic.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class Midwife extends Medic{
    @NonNull MidwifeStyle style;

    public Midwife(String name, Department department, int duration, int avgSalary, int maxAge, MidwifeStyle style) {
        super(name, department, duration, avgSalary, maxAge);
        this.style = style;
    }
}
