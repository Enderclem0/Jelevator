package fr.dut.jelevator.personne;

public class Personne {

    private static int counter;
    private final int id;
    private int scheduleDown, scheduleUp;

    public Personne() {
        this.id = Personne.counter++;
    }

    public int getId() {
        return id;
    }

}
