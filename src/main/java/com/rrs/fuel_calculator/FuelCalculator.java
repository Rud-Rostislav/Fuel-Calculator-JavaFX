package com.rrs.fuel_calculator;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FuelCalculator extends Application {
    private static final String DARK_MODE_CSS =
            "-fx-background-color: #2b2b2b; " +
                    "-fx-control-inner-background: #3d3d3d; " +
                    "-fx-text-fill: white;";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Калькулятор палива");

        // Create labels and text fields
        Label fuelBeforeLabel = new Label("Скільки палива було до поїздки?");
        TextField fuelBeforeTextField = new TextField();
        fuelBeforeTextField.setAlignment(Pos.CENTER);
        fuelBeforeTextField.setPrefWidth(300);

        Label fuelAfterLabel = new Label("Скільки палива залишилося після поїздки?");
        TextField fuelAfterTextField = new TextField();
        fuelAfterTextField.setAlignment(Pos.CENTER);
        fuelAfterTextField.setPrefWidth(300);

        Label totalKmLabel = new Label("Скільки кілометрів ви проїхали?");
        TextField totalKmTextField = new TextField();
        totalKmTextField.setAlignment(Pos.CENTER);
        totalKmTextField.setPrefWidth(300);

        Label priceGasolineLabel = new Label("Скільки коштує 1 літр бензину?");
        TextField priceGasolineTextField = new TextField();
        priceGasolineTextField.setAlignment(Pos.CENTER);
        priceGasolineTextField.setPrefWidth(300);

        TextArea resultLabel = new TextArea();
        resultLabel.setEditable(false);
        resultLabel.setWrapText(true);

        // Create a button to calculate the results
        Button calculateButton = new Button("Розрахувати");
        calculateButton.setOnAction(e -> {
            try {
                double fuelBefore = Double.parseDouble(fuelBeforeTextField.getText());
                double fuelAfter = Double.parseDouble(fuelAfterTextField.getText());
                double totalKm = Double.parseDouble(totalKmTextField.getText());
                double priceGasoline = Double.parseDouble(priceGasolineTextField.getText());
                double totalFuelConsumption = fuelBefore - fuelAfter;
                double avgFuelConsumption = totalFuelConsumption / totalKm * 100.0;
                double fuelPrice100 = priceGasoline * totalFuelConsumption;
                double fuelPrice1 = avgFuelConsumption * priceGasoline / 100;
                resultLabel.setText(String.format("Витрата на %d км = %.2f л, %.2f грн.%n" +
                                "Середня витрата на 100 км = %.2f л, %.2f грн.%n" +
                                "Вартість 1 км = %.2f грн.",
                        (int) totalKm, totalFuelConsumption, fuelPrice100,
                        avgFuelConsumption, avgFuelConsumption * priceGasoline, fuelPrice1));

            } catch (NumberFormatException ex) {
                resultLabel.setText("Будь ласка, введіть число!");
            }
        });

// Create a GridPane and add all the labels and text fields to it
        // Додати CSS стилі
        String labelStyle = "-fx-text-fill: white;";
        fuelBeforeLabel.setStyle(labelStyle);
        fuelAfterLabel.setStyle(labelStyle);
        totalKmLabel.setStyle(labelStyle);
        priceGasolineLabel.setStyle(labelStyle);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        GridPane.setHalignment(fuelBeforeLabel, HPos.CENTER);
        gridPane.addRow(1, fuelBeforeLabel);
        GridPane.setHalignment(fuelBeforeTextField, HPos.CENTER);
        gridPane.addRow(2, fuelBeforeTextField);
        GridPane.setHalignment(fuelAfterLabel, HPos.CENTER);
        gridPane.addRow(3, fuelAfterLabel);
        GridPane.setHalignment(fuelAfterTextField, HPos.CENTER);
        gridPane.addRow(4, fuelAfterTextField);
        GridPane.setHalignment(totalKmLabel, HPos.CENTER);
        gridPane.addRow(5, totalKmLabel);
        GridPane.setHalignment(totalKmTextField, HPos.CENTER);
        gridPane.addRow(6, totalKmTextField);
        GridPane.setHalignment(priceGasolineLabel, HPos.CENTER);
        gridPane.addRow(7, priceGasolineLabel);
        GridPane.setHalignment(priceGasolineTextField, HPos.CENTER);
        gridPane.addRow(8, priceGasolineTextField);
        GridPane.setHalignment(calculateButton, HPos.CENTER);
        gridPane.addRow(9, calculateButton);
        gridPane.addRow(10, resultLabel);


        Scene scene = new Scene(gridPane, 500, 500);
        primaryStage.setScene(scene);
        // Add CSS styles for dark mode
        scene.getRoot().setStyle(DARK_MODE_CSS);
        primaryStage.setScene(scene);

        // Set minimum width and height for the stage
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);

        // Center the stage on the screen
        primaryStage.centerOnScreen();

        // Show the stage
        primaryStage.show();
    }
}