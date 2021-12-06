module fr.dut.jelevator {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.dut.jelevator to javafx.fxml;
    exports fr.dut.jelevator.building;
    exports fr.dut.jelevator;
    exports fr.dut.jelevator.elevator;
    exports fr.dut.jelevator.personne;
}