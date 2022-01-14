package fr.dut.jelevator;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    private final Controller controller;
    long delta;
    long lastFrameTime;

    public GameLoop(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void handle(long l) {
        if (lastFrameTime == 0) {
            lastFrameTime = l;
        }
        delta = l - lastFrameTime;
        lastFrameTime = l;
        controller.update(delta);
        controller.drawScene(10);
    }
}
