package fr.dut.jelevator.building;

public class BuildingFactory {

    private int floor, resident;
    private double heightFloor;
    private BuildingFactory instance;

    public BuildingFactory() {
        this.instance = this;
    }

    public BuildingFactory getInstance() {
        return instance;
    }

    public Building createNewBuilding(){
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
