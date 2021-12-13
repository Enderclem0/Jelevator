package fr.dut.jelevator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(View.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Elevator");
        stage.setScene(scene);
        stage.show();
        while (true) {
            try {
                Thread.sleep(10);
                Controller.drawScene(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}