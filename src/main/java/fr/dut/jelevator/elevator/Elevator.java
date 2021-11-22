package fr.dut.jelevator.elevator;

public class Elevator {

    private double acceleration, maxSpeed, currentSpeed, width;

    public Elevator() {

    }


    public double getWidth() {
        return width; //TODO
    }

    public double getEnergy() {
        return 0; //TODO
    }
    public double distanceToMaxSpeed() {
        double time = timeToMaxSpeed();
        return (acceleration*time*time)/2;
    }
    public double timeToMaxSpeed() {
        return maxSpeed/acceleration;
    }
    public double distanceToStop() {
        return 0; //TODO
    }
    public double timeToStop() {
        return 0; //TODO
    }
}
