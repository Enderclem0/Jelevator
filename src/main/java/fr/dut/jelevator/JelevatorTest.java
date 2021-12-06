package fr.dut.jelevator;

import fr.dut.jelevator.building.Building;
import fr.dut.jelevator.building.BuildingFactory;
import fr.dut.jelevator.building.TimeRange;
import fr.dut.jelevator.elevator.Elevator;
import fr.dut.jelevator.personne.Personne;

public class JelevatorTest {

    public static void main(String[] args) {
        BuildingFactory buildingFactory = new BuildingFactory();
        Building building = buildingFactory.setResident(20).setFloor(5).setHeightFloor(4).createNewBuilding();
        int heureDebut = 10;
        int heureFin = 12;
        Elevator elevator = new Elevator();
        building.getElevatorList().add(elevator);



        TimeRange timeRange = new TimeRange(1000*60*heureDebut, 1000*60*heureFin);

        Personne personne = new Personne();

        building.getPersonneTimeRangeMap().put(personne, timeRange);
    }

}
