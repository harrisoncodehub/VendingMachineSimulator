module com.example.vendingmachinesimulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.desktop;

    opens com.example.vendingmachinesimulator to javafx.fxml;
    exports com.example.vendingmachinesimulator;

}