package fr.dut.jelevator;

import fr.dut.jelevator.building.Building;
import fr.dut.jelevator.building.BuildingFactory;
import fr.dut.jelevator.elevator.Elevator;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;

import static fr.dut.jelevator.building.BuildingFactory.getInstance;

public class Controller {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Building> buildings;
    private int drawX = 0;
    public void initialize() {
        System.out.println("Initialize controller");
        gc = canvas.getGraphicsContext2D();
        buildings = new ArrayList<>();
        buildings.add(getInstance().setFloor(5).setHeightFloor(10).setResident(20).createNewBuilding());
        buildings.add(getInstance().setFloor(3).setHeightFloor(10).setResident(20).createNewBuilding());
        drawScene(10);

    }
    public void drawScene(int margin) {
        drawX = margin;
        OptionalDouble oMaxHeight = buildings.stream().mapToDouble(Building::getHeight).max();
        System.out.println("Getting building height...");
        double maxHeight = 0;
        if (oMaxHeight.isPresent()) {
            maxHeight = oMaxHeight.getAsDouble();
        }
        System.out.println("Buildings size: " + buildings.size());
        System.out.println("Canvas width: " + canvas.getWidth());
        double yUnit = canvas.getHeight() / maxHeight;
        double xUnit = (canvas.getWidth() / buildings.size()-(margin* buildings.size()+1));
        System.out.println("xUnit value: " + xUnit);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setLineWidth(5);
        System.out.println("Drawing buildings...");
        buildings.forEach(building -> {
            gc.setFill(getRandomBrightColor());
            gc.rect(drawX, canvas.getHeight() - (canvas.getHeight()-building.getHeight()*yUnit), xUnit, building.getHeight() * yUnit);
            gc.stroke();
            drawX += xUnit + margin;
            System.out.println("Updating drawX: " + drawX);
        });

    }
    public Color getRandomBrightColor() {
        return Color.hsb(Math.random() * 360, 0.75, 1);
    }
}