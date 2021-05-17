package org.example.medic.models;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Surgeon{
    private int id;
    private String name;
    private String department;
    private int duration;
    private int avgSalary;
    private int maxAge;
}
