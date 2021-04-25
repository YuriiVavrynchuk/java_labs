package org.example.medic.managers;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.example.medic.models.Department;
import org.example.medic.models.Medic;
import org.example.medic.models.SortOrder;

import java.util.ArrayList;


@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
public class MedicalManager {
    @NonNull ArrayList<Medic> professions;

    public MedicalManager(@NonNull ArrayList<Medic> performances) {
        this.professions = performances;
    }

    public ArrayList<Medic> findByDuration(int duration) {
        ArrayList<Medic> output = new ArrayList<Medic>();
        for (Medic i: this.professions) {
            if (i.getDuration() == duration) {
                output.add(i);
            }
        }
        return output;
    }

    public ArrayList<Medic> findByDepartment(Department department) {
        ArrayList<Medic> output = new ArrayList<Medic>();
        for (Medic i: this.professions) {
            if (i.getDepartment() == department) {
                output.add(i);
            }
        }
        return output;
    }

    public void sortByMaxAge(final SortOrder order) {
        if (order == SortOrder.ASC) {
            this.professions.sort((profession1, profession2) ->
                    profession1.getMaxAge() - profession2.getMaxAge()
            );
        }
        if (order == SortOrder.DESC) {
            this.professions.sort((profession1, profession2) ->
                    profession2.getMaxAge() - profession1.getMaxAge()
            );
        }
    }
    public void printProfessions() {
        System.out.println(this);
    }
}
