package fr.dut.jelevator.personne;

public class Personne {

    private static int countor;

    private int scheduleDown, scheduleUp;
    private final int id;

    public Personne(int scheduleDown, int scheduleUp) {
        this.scheduleDown = scheduleDown;
        this.scheduleUp = scheduleUp;
        this.id = Personne.countor++;
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
