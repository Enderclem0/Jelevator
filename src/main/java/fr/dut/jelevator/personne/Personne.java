package fr.dut.jelevator.personne;

import fr.dut.jelevator.building.TimeRange;

public class Personne {

    private static int counter;
    private int scheduleDown, scheduleUp;
    private final int id;

    public Personne(int scheduleDown, int scheduleUp) {
        this.scheduleDown = scheduleDown;
        this.scheduleUp = scheduleUp;
        this.id = Personne.counter                                                                                                                                                                                                                          ++;
    }

    public int getId() {
        return id;
    }

    public int getScheduleDown() {
        return scheduleDown;
    }

    public void setScheduleDown(int scheduleDown) {
        this.scheduleDown = scheduleDown;
    }

    public int getScheduleUp() {
        return scheduleUp;
    }

    public void setScheduleUp(int scheduleUp) {
        this.scheduleUp = scheduleUp;
    }
}
