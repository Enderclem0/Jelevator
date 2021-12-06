package fr.dut.jelevator.building;

import java.util.concurrent.ThreadLocalRandom;

public class TimeRange {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final int startHour, endHour; //Horaire en millisecondes

    public TimeRange(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    //Horaire en millisecondes
    public double getRandomTimelaps() {
        return random.nextInt(startHour, endHour);
    }

    public int getEndHour() {
        return endHour;
    }

    public int getStartHour() {
        return startHour;
    }
}
