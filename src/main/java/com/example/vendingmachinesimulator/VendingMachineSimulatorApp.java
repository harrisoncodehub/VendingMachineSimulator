/**
 * @author Miles Hudock, Harrison Hubbard, Jaydon Tyndell, Fate Franks
 * CSC-331-002
 * 4/22/2025
 * Purpose: Controller file for the vending machine, calls methods, creates variables, and ensures its usability
 */
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
