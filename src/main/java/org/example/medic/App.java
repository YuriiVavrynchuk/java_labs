package org.example.medic;

import lombok.var;
import org.example.medic.managers.MedicalManager;
import org.example.medic.models.Anasthesist;
import org.example.medic.models.Department;
import org.example.medic.models.Medic;
import org.example.medic.models.Midwife;
import org.example.medic.models.MidwifeStyle;
import org.example.medic.models.Organ;
import org.example.medic.models.Remedy;
import org.example.medic.models.SortOrder;
import org.example.medic.models.Surgeon;
import java.util.ArrayList;
import java.util.List;

public final class App
{
    private App() {
        throw new AssertionError("Instantiating utility class.");
    }

    public static void main( String[] args )
    {
        Midwife galya = new Midwife("Galya", Department.EAST, 10,1000,90, MidwifeStyle.StyleB0233);
        Surgeon vasyl = new Surgeon("Vasyl", Department.NORTH, 8, 10000, 60, Organ.HEART);
        Anasthesist ivan = new Anasthesist("Ivan", Department.WEST, 7, 100000, 50, Remedy.Ca2CO3);
        var pylypaOrlyka = new MedicalManager(new ArrayList<Medic>(List.of(galya, vasyl, ivan)));
        pylypaOrlyka.findByDepartment(Department.NORTH);
        pylypaOrlyka.findByDepartment(Department.WEST);
        pylypaOrlyka.findByDepartment(Department.EAST);
        pylypaOrlyka.sortByMaxAge(SortOrder.ASC);
        pylypaOrlyka.printProfessions();
        pylypaOrlyka.sortByMaxAge(SortOrder.DESC);
        pylypaOrlyka.printProfessions();
    }
}
