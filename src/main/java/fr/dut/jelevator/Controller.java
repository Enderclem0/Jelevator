package fr.dut.jelevator;

import fr.dut.jelevator.building.Building;
import fr.dut.jelevator.building.BuildingFactory;
import fr.dut.jelevator.elevator.Elevator;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {
    private final List<Building> buildings = new ArrayList<>();
    private final Group group = new Group();
    @FXML
    private BorderPane bPane;
    //drawX est le point de départ du rectangle
    private double drawX = 0;

    public static Color getRandomBrightColor() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return Color.hsb(random.nextInt(360), 0.75, 1);
    }

    public void initialize() {
        System.out.println("initializing");
        Building building = BuildingFactory.getInstance().setFloor(10).setHeightFloor(2).setResident(10).createNewBuilding();
        Building building2 = BuildingFactory.getInstance().setFloor(20).setHeightFloor(2).setResident(10).createNewBuilding();
        Elevator elevator = new Elevator(2.0, 3.0, 2.5);
        Elevator elevator3 = new Elevator(2.0, 3.0, 0.5);
        Elevator elevator2 = new Elevator(1.5, 5.0, 2.5);
        building2.addElevator(elevator2);
        building.addElevator(elevator3);
        elevator3.setObjectiveHeight(building.getHeightFloor() * 5);
        elevator.setObjectiveHeight(building.getHeightFloor() * 5);
        elevator2.setObjectiveHeight(building2.getHeightFloor() * 10);
        building.addElevator(elevator);
        System.out.println("Set elevator objective height to : " + elevator.getObjectiveHeight());
        buildings.add(building);
        buildings.add(building2);
        bPane.setCenter(group);
        System.out.println("Finished initializing\n");
    }

    public void drawScene(int margin) {
        group.getChildren().clear();
        drawX = margin;
        OptionalDouble oMaxHeight = buildings.stream().mapToDouble(Building::getHeight).max();
        double maxHeight = 0;
        if (oMaxHeight.isPresent()) {
            maxHeight = oMaxHeight.getAsDouble();
        }
        double yUnit = bPane.getHeight() / maxHeight;
        double xUnit = (bPane.getWidth() / buildings.size() - (margin * buildings.size() + 1));
        buildings.forEach(building -> {
            drawBuilding(building, yUnit, xUnit);
            drawX += xUnit + margin;
        });
    }

    public void drawElevator(Elevator elevator, double yUnit, double startX, double width, double height) {
        Rectangle rectangle = new Rectangle(startX, bPane.getHeight() - elevator.getCurrentHeight() * yUnit - height, width, height);
        rectangle.setFill(elevator.getColor());
        group.getChildren().add(rectangle);
    }

    public void drawBuilding(Building building, double yUnit, double xUnit) {
        Rectangle rectangle = new Rectangle(drawX, bPane.getHeight() - building.getHeight() * yUnit, xUnit, building.getHeight() * yUnit);
        rectangle.setFill(building.getColor());
        double elevatorX = drawX + (xUnit / 2);
        double elevatorWidth = (elevatorX - drawX) / building.getElevatorList().size();
        group.getChildren().add(rectangle);
        for (Elevator elevator : building.getElevatorList()) {
            drawElevator(elevator, yUnit, elevatorX, elevatorWidth, yUnit * building.getHeightFloor());
            elevatorX += elevatorWidth;
        }

    }

    public void update(long time_passed) {
        buildings.forEach(building -> building.getElevatorList().forEach(elevator -> elevator.update(time_passed)));
    }
}