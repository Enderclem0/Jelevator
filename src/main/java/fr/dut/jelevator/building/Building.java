package fr.dut.jelevator.building;

import fr.dut.jelevator.elevator.Elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private final int floor;
    private final double heightFloor;
    private int resident;
    private final List<Elevator> elevatorList;

    public Building(int floor, int resident, double heightFloor) {
        this.elevatorList = new ArrayList<>();
        this.floor = floor;
        this.resident = resident;
        this.heightFloor = heightFloor;
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
