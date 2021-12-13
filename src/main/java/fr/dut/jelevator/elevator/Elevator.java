package fr.dut.jelevator.elevator;

import fr.dut.jelevator.personne.Personne;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private final List<Personne> personneInElevator;

    private double acceleration, maxSpeed, currentHeight = 0, deceleration, currentSpeed = 0,objectiveHeight = 0;

    public Elevator() {
        this.personneInElevator = new ArrayList<>();
    }

    public void addPersonneInElevator(Personne personne){
        personneInElevator.add(personne);
    }

    public void removePersonneInElevator(Personne personne){
        personneInElevator.remove(personne);
    }

    public int getPersonneInElevator(){
        return personneInElevator.size();
    }

    public boolean isEmpty(){
        return personneInElevator.isEmpty();
    }
    public int timeToReachObjective(double objectiveHeight){
        double oldSpeed = currentSpeed;
        double oldHeight = currentHeight;
        double oldObjectiveHeight = this.objectiveHeight;
        setObjectiveHeight(objectiveHeight);
        int time = 0;
        while (isMoving()){
            move(1);
        }
        setObjectiveHeight(oldObjectiveHeight);
        currentSpeed = oldSpeed;
        currentHeight = oldHeight;
        return time;
    }
    public void move(int TICK_TIME) {
        if (isMoving()){
            double distance = objectiveHeight - currentHeight;
            boolean up = distance > 0;
            if (currentSpeed < maxSpeed && distance > distanceToStop()) {
                currentSpeed += acceleration * TICK_TIME;
            } else if (distance <= distanceToStop()) {
                currentSpeed -= deceleration * TICK_TIME;
            }
            currentHeight += currentSpeed * TICK_TIME;
        }
        else {
            currentSpeed = 0;
        }
    }

    public double getCurrentHeight() {
        return currentHeight;
    }
    public void setObjectiveHeight(double objectiveHeight) {
        this.objectiveHeight = objectiveHeight;
    }
    public boolean isMoving() {
        return !(currentHeight <= objectiveHeight + 0.1) && !(currentHeight >= objectiveHeight - 0.1);
    }
    private double distanceToStop() {
        return currentSpeed * currentSpeed / deceleration / 2;
    }
}