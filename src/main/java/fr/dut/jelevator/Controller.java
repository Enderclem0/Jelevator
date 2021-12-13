package fr.dut.jelevator;

import fr.dut.jelevator.building.Building;
import fr.dut.jelevator.building.BuildingFactory;
import fr.dut.jelevator.elevator.Elevator;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static fr.dut.jelevator.building.BuildingFactory.getInstance;

public class Controller {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Building> buildings;

    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        buildings = new ArrayList<>();
        buildings.add(getInstance().createNewBuilding());
    }
    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
    public void drawScene(int margin) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double buildingWidth = (canvas.getWidth() / buildings.size())-buildings.size()/2f;
        for (Building building : buildings) {
            gc.setStroke(getRandomBrightColor());
            double drawX = 0;
            gc.strokeLine(drawX, 0, drawX, canvas.getHeight());
            for (int i = 0; i < building.getNbFloors(); i++) {
                gc.strokeLine(drawX, i * building.getHeightFloor(), drawX +buildingWidth, i * building.getHeightFloor());
            }
            double elevatorWidth = buildingWidth / building.getElevatorList().size();
            for (Elevator elevator : building.getElevatorList()) {
                gc.setStroke(getRandomBrightColor());
                gc.strokeRect(drawX, building.getFloor(elevator.getCurrentHeight()) * building.getHeightFloor(), elevatorWidth, building.getHeightFloor());
            }
        }
    }
    public Color getRandomBrightColor() {
        return Color.hsb(Math.random() * 360, 0.75, 1);
    }
}