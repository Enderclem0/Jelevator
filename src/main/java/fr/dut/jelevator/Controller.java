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
    private static Canvas canvas;
    private static GraphicsContext gc;
    private static List<Building> buildings = new ArrayList<>();;
    private static int drawX = 0;
    public void initialize(){
        gc = canvas.getGraphicsContext2D();
        buildings.add(getInstance().setFloor(5).setHeightFloor(10).setResident(20).createNewBuilding());
        buildings.add(getInstance().setFloor(5).setHeightFloor(5).setResident(20).createNewBuilding());
    }
    public static void drawScene(int margin) {
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
            gc.fillRect(drawX, canvas.getHeight() - building.getHeight() * yUnit, xUnit, building.getHeight() * yUnit);
            drawX += xUnit + margin;
        });
    }
    public static void drawElevator(Elevator elevator) {

    }
    public static Color getRandomBrightColor() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Color rand = Color.hsb(random.nextInt(360), 0.75, 1);
        System.out.println("Random color:"+rand+"\n");
        return rand;
    }
}