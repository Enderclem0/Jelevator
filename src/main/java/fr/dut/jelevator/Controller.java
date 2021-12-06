package fr.dut.jelevator;

import fr.dut.jelevator.building.Building;
import fr.dut.jelevator.elevator.Elevator;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.List;

public class Controller {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Building> buildings;
    private double drawX = 0;

    public void initialize() {
        gc = canvas.getGraphicsContext2D();
    }

    public void drawScene(int margin) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double buildingWidth = (canvas.getWidth() / buildings.size())-buildings.size()/2f;
        for (Building building : buildings) {
            gc.setStroke(getRandomBrightColor());
            gc.strokeLine(drawX, 0, drawX, canvas.getHeight());
            for (int i = 0; i < building.getFloor(); i++) {
                gc.strokeLine(drawX, i * building.getHeightFloor(), drawX+buildingWidth, i * building.getHeightFloor());
            }
            double elevatorWidth = buildingWidth / building.getElevatorList().size();
        }
    }
    public Color getRandomBrightColor() {
        return Color.hsb(Math.random() * 360, 0.75, 1);
    }
}