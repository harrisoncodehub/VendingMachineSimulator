package com.example.vendingmachinesimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VendingMachineSimulatorApp extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vendingMachine.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Vending Machine");
        stage.setScene(scene);
        stage.show();
    }
}
