package fr.dut.jelevator.elevator;

public class Elevator {

    private double acceleration, maxSpeed, currentSpeed=0,currentHeight=0,deceleration;

    public Elevator() {
    }
    //Time to reach the distance in milliseconds
    public double timeToReach(double distance) {
        return 0.0; //TODO
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
