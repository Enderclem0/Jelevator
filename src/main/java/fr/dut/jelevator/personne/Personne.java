package fr.dut.jelevator.personne;

import fr.dut.jelevator.building.TimeRange;

public class Personne {

    private static int counter;
    private final int id;

    public Personne() {
        this.id = Personne.counter                                                                                                                                                                                                                          ++;
    }

    public int getId() {
        return id;
    }

}
