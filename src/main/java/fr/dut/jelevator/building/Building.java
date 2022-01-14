package fr.dut.jelevator.building;

import fr.dut.jelevator.Controller;
import fr.dut.jelevator.elevator.Elevator;
import fr.dut.jelevator.personne.Personne;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Building {

    private final int floor;
    private final double heightFloor;
    private final int resident;
    private final List<Elevator> elevatorList;
    private final List<TimeRange> timeRangesListUp;
    private final List<TimeRange> timeRangesListDown;
    private final Map<Personne, TimeRange> personneTimeRangeMap;
    private final Color color = Controller.getRandomBrightColor();

    public Building(int floor, int resident, double heightFloor) {
        this.elevatorList = new ArrayList<>();
        this.timeRangesListUp = new ArrayList<>();
        this.timeRangesListDown = new ArrayList<>();
        this.floor = floor;
        this.personneTimeRangeMap = new HashMap<>();
        this.resident = resident;
        this.heightFloor = heightFloor;
    }

    public Color getColor() {
        return color;
    }

    public void addElevator(Elevator elevator) {
        this.elevatorList.add(elevator);
    }

    public void addTimeRangeUp(TimeRange timeRange) {
        timeRangesListUp.add(timeRange);
    }

    public void addTimeRangeDown(TimeRange timeRange) {
        timeRangesListDown.add(timeRange);
    }

    public Map<Personne, TimeRange> getPersonneTimeRangeMap() {
        return personneTimeRangeMap;
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public int getNbFloors() {
        return floor;
    }

    public int getResident() {
        return resident;
    }

    public double getHeightFloor() {
        return heightFloor;
    }

    public long getFloor(double currentHeight) {
        return Math.round(currentHeight / heightFloor);
    }

    public double getHeight() {
        return (floor * heightFloor);
    }

    @Override
    public String toString() {
        return "Building{" +
                "floor=" + floor +
                ", heightFloor=" + heightFloor +
                ", resident=" + resident +
                ", elevatorList=" + elevatorList +
                ", timeRangesListUp=" + timeRangesListUp +
                ", timeRangesListDown=" + timeRangesListDown +
                ", personneTimeRangeMap=" + personneTimeRangeMap +
                '}';
    }
}
