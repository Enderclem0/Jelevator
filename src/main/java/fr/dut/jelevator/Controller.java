package fr.dut.jelevator;

import fr.dut.jelevator.building.Building;
import fr.dut.jelevator.building.BuildingFactory;
import fr.dut.jelevator.elevator.Elevator;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static fr.dut.jelevator.building.BuildingFactory.getInstance;

public class Controller {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Building> buildings;
    private int drawX = 0;
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        buildings = new ArrayList<>();
        buildings.add(getInstance().setFloor(5).setHeightFloor(10).setResident(20).createNewBuilding());
        buildings.add(getInstance().setFloor(5).setHeightFloor(5).setResident(20).createNewBuilding());
        drawScene(10);

    }
    public void drawScene(int margin) {
        drawX = margin;
        int lineWidth = 5;
        OptionalDouble oMaxHeight = buildings.stream().mapToDouble(Building::getHeight).max();
        double maxHeight = 0;
        if (oMaxHeight.isPresent()) {
            maxHeight = oMaxHeight.getAsDouble();
        }
        double yUnit = canvas.getHeight() / maxHeight;
        double xUnit = (canvas.getWidth() / buildings.size()-(margin* buildings.size()+1));
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setLineWidth(lineWidth);
        buildings.forEach(building -> {
            gc.setFill(getRandomBrightColor());
            System.out.println("drawing building : \n");
            System.out.println("x : " + drawX + " y : " + (canvas.getHeight() - building.getHeight() * yUnit));
            System.out.println("width : " + xUnit + " height : " + building.getHeight() * yUnit);
            gc.rect(drawX, canvas.getHeight() - building.getHeight() * yUnit, xUnit, building.getHeight() * yUnit);
            gc.stroke();
            drawX += xUnit + margin;
        });
    }
    public void drawElevator(Elevator elevator) {

    }
    public Color getRandomBrightColor() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Color rand = Color.hsb(random.nextInt(360), 0.75, 1);
        System.out.println("Random color:"+rand+"\n");
        return rand;
    }
}