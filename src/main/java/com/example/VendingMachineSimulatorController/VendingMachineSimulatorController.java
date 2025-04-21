package com.example.VendingMachineSimulatorController;
/**
 * Sample Skeleton for 'vendingMachine.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import com.example.VendingItem.VendingItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;



public class VendingMachineSimulatorController {

    //Variables

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Chugjug"
    private Button Chugjug; // Value injected by FXMLLoader

    @FXML // fx:id="Coke"
    private Button Coke; // Value injected by FXMLLoader

    @FXML // fx:id="Ketchup"
    private Button Ketchup; // Value injected by FXMLLoader

    @FXML // fx:id="Mug"
    private Button Mug; // Value injected by FXMLLoader

    @FXML // fx:id="Saratoga"
    private Button Saratoga; // Value injected by FXMLLoader

    @FXML // fx:id="Squirt"
    private Button Squirt; // Value injected by FXMLLoader

    @FXML // fx:id="cardArea"
    private Group cardArea; // Value injected by FXMLLoader

    @FXML // fx:id="debitCard"
    private ImageView debitCard; // Value injected by FXMLLoader

    @FXML // fx:id="itemScreen"
    private TextField itemScreen; // Value injected by FXMLLoader


    @FXML // fx:id="paymentScreen"
    private TextArea paymentScreen; // Value injected by FXMLLoader

    //Methods


    /**
     * Creates an object to display information when button is pressed
     */
    @FXML
    void handleCokeButton(ActionEvent event) {
        VendingItem coke = new VendingItem("Coke",2.50);
        displayItem(coke.getName(), coke.getPrice());
    }

    @FXML
    void handleKetchupButton(ActionEvent event) {
        VendingItem ketchup = new VendingItem("Ketchup",1.50);
        displayItem(ketchup.getName(), ketchup.getPrice());
    }

    @FXML
    void handleChugJugButton(ActionEvent event) {
        VendingItem chugjug = new VendingItem("Chug Jug",7.50);
        displayItem(chugjug.getName(), chugjug.getPrice());
    }

    @FXML
    void handleMugButton(ActionEvent event){
        VendingItem mug = new VendingItem("Mug",2.25);
        displayItem(mug.getName(),mug.getPrice());
    }

    @FXML
    void handleSaratogaButton(ActionEvent event){
        VendingItem saratoga = new VendingItem("Saratoga",3.25);
        displayItem(saratoga.getName(),saratoga.getPrice());
    }

    @FXML
    void handleSquirtButton(ActionEvent event){
        VendingItem squirt = new VendingItem("Squirt",2.50);
        displayItem(squirt.getName(),squirt.getPrice());
    }

    // Helper method to format and set item text
    private void displayItem(String name, double price) {
        itemScreen.setText(name + " - $" + String.format("%.2f", price));
    }

    //DraggableMaker draggableMaker = new DraggableMaker();


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Chugjug != null : "fx:id=\"Chugjug\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert Coke != null : "fx:id=\"Coke\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert Ketchup != null : "fx:id=\"Ketchup\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert Mug != null : "fx:id=\"Mug\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert Saratoga != null : "fx:id=\"Saratoga\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert Squirt != null : "fx:id=\"Squirt\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert cardArea != null : "fx:id=\"cardArea\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert debitCard != null : "fx:id=\"debitCard\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert itemScreen != null : "fx:id=\"itemScreen\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        assert paymentScreen != null : "fx:id=\"paymentScreen\" was not injected: check your FXML file 'vendingMachine.fxml'.";
        //draggableMaker.makeDraggable(debitCard);
    }


}
