package fr.dut.jelevator.building;

public class Building {

    private final int floor;
    private final double heightFloor;
    private int resident;

    public Building(int floor, int resident, double heightFloor) {
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
