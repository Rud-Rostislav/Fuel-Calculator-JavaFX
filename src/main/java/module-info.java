module com.rrs.fuel_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rrs.fuel_calculator to javafx.fxml;
    exports com.rrs.fuel_calculator;
}