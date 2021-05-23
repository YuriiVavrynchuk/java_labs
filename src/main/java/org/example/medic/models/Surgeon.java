package org.example.medic.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Surgeon{
    private int id;
    private String name;
    private String department;
    private int duration;
    private int avgSalary;
    private int maxAge;

    public Surgeon copy(){
        return new Surgeon(this.id, this.name, this.department, this.duration, this.avgSalary, this.maxAge);
    }
}
