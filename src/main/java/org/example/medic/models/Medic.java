package org.example.medic.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)

public abstract class Medic {
    @NonNull String name;
    @NonNull Department department;
    @NonNull int duration;
    @NonNull int avgSalary;
    @NonNull int maxAge;
}
