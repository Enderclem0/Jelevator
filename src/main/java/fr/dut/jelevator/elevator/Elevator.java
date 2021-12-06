package fr.dut.jelevator.elevator;

public class Elevator {
    private double acceleration, maxSpeed, currentHeight = 0, deceleration, currentSpeed = 0,objectiveHeight = 0;

    public void move(int TICK_TIME) {
        if (!isArrived()){
            double distance = objectiveHeight - currentHeight;
            boolean up = distance > 0;
            if (currentSpeed < maxSpeed && distance > distanceToStop()) {
                currentSpeed += acceleration * TICK_TIME;
            } else if (distance <= distanceToStop()) {
                currentSpeed -= deceleration * TICK_TIME;
            }
            currentHeight += currentSpeed * TICK_TIME;
        }
    }
    public double getCurrentHeight() {
        return currentHeight;
    }
    public void setObjectiveHeight(double objectiveHeight) {
        this.objectiveHeight = objectiveHeight;
    }
    public boolean isArrived() {
        return currentHeight<=objectiveHeight+0.1||currentHeight>=objectiveHeight-0.1;
    }
    private double distanceToStop() {
        return currentSpeed * currentSpeed / deceleration / 2;
    }
}