package fr.dut.jelevator.building;

import fr.dut.jelevator.elevator.Elevator;
import fr.dut.jelevator.personne.Personne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Building {

    private final int floor;
    private final double heightFloor;
    private int resident;
    private final List<Elevator> elevatorList;
    private final List<TimeRange> timeRangesListUp;
    private final List<TimeRange> timeRangesListDown;
    private final Map<Personne, TimeRange> personneTimeRangeMap;

    public Building(int floor, int resident, double heightFloor) {
        this.elevatorList = new ArrayList<>();
        this.timeRangesListUp = new ArrayList<>();
        this.timeRangesListDown = new ArrayList<>();
        this.floor = floor;
        this.personneTimeRangeMap = new HashMap<>();
        this.resident = resident;
        this.heightFloor = heightFloor;
    }

    public void addTimeRangeUp(TimeRange timeRange){
        timeRangesListUp.add(timeRange);
    }

    public void addTimeRangeDown(TimeRange timeRange){
        timeRangesListDown.add(timeRange);
    }

    public Map<Personne, TimeRange> getPersonneTimeRangeMap() {
        return personneTimeRangeMap;
    }

    //Temps en millisecondes
    public double getTimelapsToFloor(Elevator elevator, int floor){

        return 0; //TODO
    }


    public int getPositionElevatorByTime(Elevator elevator){

        return 0; //TODO
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public int getFloor() {
        return floor;
    }

    public int getResident() {
        return resident;
    }

    public double getHeightFloor() {
        return heightFloor;
    }

}
