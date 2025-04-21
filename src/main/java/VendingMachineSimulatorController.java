/**
 * Sample Skeleton for 'vendingMachine.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VendingMachineSimulatorController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Coke"
    private Button Coke; // Value injected by FXMLLoader

    @FXML
    void selectItem(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Coke != null : "fx:id=\"Coke\" was not injected: check your FXML file 'vendingMachine.fxml'.";

    }

    private void selectItem(){

    }

}
