package fr.dut.jelevator.building;

public class BuildingFactory {

    private static BuildingFactory instance;
    private int floor, resident;
    private double heightFloor;

    private BuildingFactory() {
    }

    public static BuildingFactory getInstance() {
        if (instance == null) {
            instance = new BuildingFactory();
        }
        return instance;
    }

    public Building createNewBuilding() {
        return new Building(floor, resident, heightFloor);
    }


    public BuildingFactory setFloor(int floor) {
        this.floor = floor;
        return this;
    }

    public BuildingFactory setResident(int resident) {
        this.resident = resident;
        return this;
    }

    public BuildingFactory setHeightFloor(double heightFloor) {
        this.heightFloor = heightFloor;
        return this;
    }
}
