package fr.dut.jelevator.elevator;

import fr.dut.jelevator.Controller;
import fr.dut.jelevator.personne.Personne;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private final List<Personne> personneInElevator;
    private final Color color = Controller.getRandomBrightColor();

    private final double acceleration;
    private final double maxSpeed;
    private final double deceleration;
    private double currentHeight = 0;
    private double currentSpeed = 0;
    private double objectiveHeight = 0;

    public Elevator(double acceleration, double maxSpeed, double deceleration) {
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;
        this.deceleration = deceleration;
        this.personneInElevator = new ArrayList<>();
    }

    public Color getColor() {
        return color;
    }

    public void addPersonneInElevator(Personne personne) {
        personneInElevator.add(personne);
    }

    public void removePersonneInElevator(Personne personne) {
        personneInElevator.remove(personne);
    }

    public int getPersonneInElevator() {
        return personneInElevator.size();
    }

    public boolean isEmpty() {
        return personneInElevator.isEmpty();
    }

    public int timeToReachObjective(double objectiveHeight, double TICK_TIME) {
        double oldSpeed = currentSpeed;
        double oldHeight = currentHeight;
        double oldObjectiveHeight = this.objectiveHeight;
        setObjectiveHeight(objectiveHeight);
        int time = 0;
        while (isMoving()) {
            move(TICK_TIME);
        }
        setObjectiveHeight(oldObjectiveHeight);
        currentSpeed = oldSpeed;
        currentHeight = oldHeight;
        return time;
    }

    public void move(double TICK_TIME) {
        if (isMoving()) {
            double distance = objectiveHeight - currentHeight;
            double distanceToStop = distanceToStop();
            boolean up = distance > 0;
            //if we are going up, check if we have the distance to stop
            if (up) {
                if (distance < distanceToStop) {
                    //we have the distance to stop, so we decelerate
                    currentSpeed -= deceleration * TICK_TIME;
                } else {
                    //we don't have the distance to stop, so we accelerate, but we don't go over the max speed
                    if (currentSpeed + acceleration * TICK_TIME < maxSpeed) {
                        currentSpeed += acceleration * TICK_TIME;
                    }
                }
            }
            //if we are going down, check if we have the distance to stop
            else {
                if (distance > -distanceToStop) {
                    //we have the distance to stop, so we decelerate
                    currentSpeed += deceleration * TICK_TIME;
                } else {
                    //we don't have the distance to stop, so we accelerate, but we don't go over the max speed
                    if (currentSpeed - acceleration * TICK_TIME > -maxSpeed) {
                        currentSpeed -= acceleration * TICK_TIME;
                    }
                }
            }
            currentHeight += currentSpeed * TICK_TIME;
        } else {
            currentSpeed = 0;
        }
    }

    public double getCurrentHeight() {
        return currentHeight;
    }

    public boolean isMoving() {
        return !(currentHeight >= objectiveHeight - 0.1 && currentHeight <= objectiveHeight + 0.1);
    }

    private double distanceToStop() {
        //return the distance necessary to stop at the current speed
        return currentSpeed * currentSpeed / (2 * deceleration);
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "personneInElevator=" + personneInElevator +
                ", acceleration=" + acceleration +
                ", maxSpeed=" + maxSpeed +
                ", currentHeight=" + currentHeight +
                ", deceleration=" + deceleration +
                ", currentSpeed=" + currentSpeed +
                ", objectiveHeight=" + objectiveHeight +
                '}';
    }

    public void update(long time_passed) {
        //convert time from ns to s
        double TICK_TIME = time_passed / 1000000000.0;
        move(TICK_TIME);
    }

    public double getObjectiveHeight() {
        return objectiveHeight;
    }

    public void setObjectiveHeight(double objectiveHeight) {
        this.objectiveHeight = objectiveHeight;
    }
}