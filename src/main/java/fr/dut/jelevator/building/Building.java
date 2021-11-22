package fr.dut.jelevator.building;

import fr.dut.jelevator.elevator.Elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private final int floor;
    private final double heightFloor;
    private int resident;
    private final List<Elevator> elevatorList;
    private final List<TimeRange> timeRangesListUp;
    private final List<TimeRange> timeRangesListDown;

    public Building(int floor, int resident, double heightFloor) {
        this.elevatorList = new ArrayList<>();
        this.timeRangesListUp = new ArrayList<>();
        this.timeRangesListDown = new ArrayList<>();
        this.floor = floor;
        this.resident = resident;
        this.heightFloor = heightFloor;
    }

    public void addTimeRangeUp(TimeRange timeRange){
        timeRangesListUp.add(timeRange);
    }

    public void addTimeRangeDown(TimeRange timeRange){
        timeRangesListDown.add(timeRange);
    }

    //Temps en millisecondes
    public double getTimelaps(Elevator elevator, int floor){

        return 0; //TODO
    }


    public int getPositionElevator(Elevator elevator){

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
