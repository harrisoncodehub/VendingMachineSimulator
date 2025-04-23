package com.example.vendingmachinesimulator;
/**
 * @author Miles Hudock, Harrison Hubbard, Jaydon Tyndell, Fate Franks
 * CSC-331-002
 * 4/22/2025
 * Purpose: Controller file for the vending machine, calls methods, creates variables, and ensures its usability
 */
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.animation.Timeline; //timer libraries
import javafx.animation.KeyFrame;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import javafx.scene.shape.Rectangle;

import javafx.scene.image.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

//For changing audio
import javax.sound.sampled.FloatControl;


public class VendingMachineSimulatorController {
    //Payment
    //allows the use of hovering
    private boolean isHoveringScanner = false;
    private Timeline hoverTimer;
    //Files paths for audio files stored in strings for usage
    static String filepath = "vendingnoise.wav";
    static String filepath2 = "vendingdispense.wav";
    static String filepath3 = "gulpgulp.wav";


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

    //image that will display once all processes have been completed
    @FXML
    private ImageView dispensedItem;

    @FXML
    private Rectangle dispenser;

    //variables for drag
    @FXML
    private double mouseAnchorX;

    @FXML
    private double mouseAnchorY;

    //variable to indicate if a button has been pressed.
    private boolean itemSelected = false;

    //Variables that indicates what item should be dispensed after push
    private String item = "";

    //Methods

    /**
     * Allows for audio during program run
     * @param location
     */
    public static void PlayMusic(String location){
        try{
            //creates file object
            File musicPath = new File(location);
            //checks to see if the path exists
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-25.0f); // Decrease volume (in decibels)
                clip.start();
                //plays the clip
            }
            else{
                System.out.println("Cant find file");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Audio for when the item is dispensed
     * @param location
     */
    public static void PlaySound(String location){
        try{
            //creates file object
            File musicPath = new File(location);
            //checks to see if the path exists
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(5.0f); // Decrease volume (in decibels)
                clip.start();
                //plays the clip
            }
            else{
                System.out.println("Cant find file");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void PlayGulp(String location){
        try{
            //creates file object
            File musicPath = new File(location);
            //checks to see if the path exists
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(3.0f); // Decrease volume (in decibels)
                clip.start();
                //plays the clip
            }
            else{
                System.out.println("Cant find file");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Allows the debit card to be draggable and checks to see if it's hovering over the scanner
     */
    @FXML
    private void enableCardDrag() {
        //enables debit card to be draggable
        debitCard.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getSceneX() - debitCard.getLayoutX();
            mouseAnchorY = mouseEvent.getSceneY() - debitCard.getLayoutY();
        });

        debitCard.setOnMouseDragged(mouseEvent ->{
            debitCard.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            debitCard.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);


        //checks to see if it is hovering the scanner
        checkIfHoveringScanner();
        });
    }

    /**
     * Checks to see if the card is hovering over the card area
     */
    private void checkIfHoveringScanner(){
        //checks to see if its over the cardArea group
        if (debitCard.getBoundsInParent().intersects(cardArea.getBoundsInParent())){
            if (!isHoveringScanner){
                isHoveringScanner = true;
                startHoverTime();
            }
        }else{
            isHoveringScanner = false;
            if (hoverTimer != null){
                hoverTimer.stop();
            }
        }
    }

    /**
     * Starts hover time for debit card and screen area. Constantly displays please tap card.
     */
    private void startHoverTime() {
        try{

            //timer for hovering, 3 seconds, if correct it will call confirm payment
            hoverTimer = new Timeline(new KeyFrame(Duration.seconds(3),e -> {
                try {
                    confirmPayment();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }));

            hoverTimer.setCycleCount(1);
            hoverTimer.play();}
        //displays Please tap card
        catch (Exception e){
            paymentScreen.setText("Please select an item.");
        }

    }

    /**
     * Checks to see if an item was selected, if so payment screen is displayed.
     * @throws InterruptedException
     */
    private void confirmPayment() throws InterruptedException {
        if(itemSelected){
            paymentScreen.setText("Payment Confirmed!");
            //pauses program for 3 seconds, does not affect GUI
            Thread.sleep(3000);
            //plays clunk noise of item falling
            PlaySound(filepath2);
            itemSelected = false;
            dispenseItem();


        }

        else{
            itemScreen.setText("REMOVE CARD AND CHOOSE ITEM");
        }

    }

    /**
     * displays the item that the user purchased
     */
    //********************************************************
    @FXML
    private void hideDispensedItem(){
        dispensedItem.setVisible(false);
        PlayGulp(filepath3);
        dispenser.setFill(Paint.valueOf("#454545"));
    }

    @FXML
    private void dispenseItem() throws InterruptedException {
        //creates new image and makes it visible
        dispensedItem.setImage(new Image(String.valueOf(getClass().getResource("/com/example/vendingmachinesimulator/images/"+item).toExternalForm())));
        dispensedItem.setVisible(true);

        //Sets position of item, will have to configure
        dispensedItem.setLayoutY(620);
        dispensedItem.setLayoutX(250);
        dispensedItem.setRotate(90);
        dispenser.setFill(Paint.valueOf("black"));


        itemScreen.setText("Thank you for your purchase!");
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.play();
        itemScreen.setText("Select Item");

    }

    /**
     * Creates an object to display information when button is pressed
     */
    @FXML
    void handleCokeButton(ActionEvent event) {
        VendingItem coke = new VendingItem("Coke",2.50);
        displayItem(coke.getName(), coke.getPrice());
        itemSelected = true;
        item = "coket.png";
        paymentScreen.setText("Please tap card.");
    }

    /**
     * Creates an object to display information when button is pressed
     * @param event
     */
    @FXML
    void handleKetchupButton(ActionEvent event) {
        VendingItem ketchup = new VendingItem("Ketchup",1.50);
        displayItem(ketchup.getName(), ketchup.getPrice());
        itemSelected = true;
        item = "ketchup.png";
        paymentScreen.setText("Please tap card.");

    }

    /**
     * Creates an object to display information when button is pressed
     * @param event
     */
    @FXML
    void handleChugJugButton(ActionEvent event) {
        VendingItem chugjug = new VendingItem("Chug Jug",7.50);
        displayItem(chugjug.getName(), chugjug.getPrice());
        itemSelected = true;
        item = "chugjugt.png";
        paymentScreen.setText("Please tap card.");
    }

    /**
     * Creates an object to display information when button is pressed
     * @param event
     */
    @FXML
    void handleMugButton(ActionEvent event){
        VendingItem mug = new VendingItem("Mug",2.25);
        displayItem(mug.getName(),mug.getPrice());
        itemSelected = true;
        item = "mugmugmug.png";
        paymentScreen.setText("Please tap card.");
    }

    /**
     * Creates an object to display information when button is pressed
     * @param event
     */
    @FXML
    void handleSaratogaButton(ActionEvent event){
        VendingItem saratoga = new VendingItem("Saratoga",3.25);
        displayItem(saratoga.getName(),saratoga.getPrice());
        itemSelected = true;
        item = "saratogat.png";
        paymentScreen.setText("Please tap card.");
    }

    /**
     * Creates an object to display information when button is pressed
     * @param event
     */
    @FXML
    void handleSquirtButton(ActionEvent event){
        VendingItem squirt = new VendingItem("Squirt",2.50);
        displayItem(squirt.getName(),squirt.getPrice());
        itemSelected = true;
        item = "squirtt.png";
        paymentScreen.setText("Please tap card.");
    }

    /**
     * method to format and set item text
     * @param name
     * @param price
     */
    private void displayItem(String name, double price) {
        itemScreen.setText(name + " - $" + String.format("%.2f",price));
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
        paymentScreen.setText("Please tap card.");
        itemScreen.setText("Select Item");
        PlayMusic(filepath);


    }

    public static void main(String[] args){
        while(true){
            PlayMusic(filepath);
        }
    }
}
