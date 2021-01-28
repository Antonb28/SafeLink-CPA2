package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import java.io.IOException;


public class BoardBus {
    ObservableList<String> currentStationList = FXCollections.observableArrayList("Taft Avenue","Magallanes","Ayala","Buendia","Guadalupe","Boni","Shaw","Ortigas","Santolan","Cubao","Quezon Avenue");
    ObservableList<String> destinationStationList = FXCollections.observableArrayList("Taft Avenue","Magallanes","Ayala","Buendia","Guadalupe","Boni","Shaw","Ortigas","Santolan","Cubao","Quezon Avenue");
    @FXML
    Label Destination, Station, Price, RemainingCredit;

    @FXML
    ChoiceBox currentStation, destinationStationBox;

    @FXML
    Button confirm;

    @FXML
    private void LogOut() throws IOException {
        App.setRoot("LogIn");
    }

    @FXML
    private void fillForm() throws IOException {
        App.setRoot("LogIn");
    }

    @FXML
    private void Help() throws IOException{
        App.setRoot("HelpMenu");
    }

    @FXML
    private void Back() throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void ViewCredit() throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void RideBus() throws IOException{
        App.setRoot("OnBusScreen");
    }

    @FXML
    private void updateLabels() {
        Station.setText((String) currentStation.getValue());
        Destination.setText((String) destinationStationBox.getValue());

        String base = (String) currentStation.getValue();
        String base2 = (String) destinationStationBox.getValue();
        int currentStation_index = 0;
        int detinationStation_index = 0;
        switch (base) {
            case "Taft Avenue":
                currentStation_index = 1;
                break;
            case "Magallanes":
                currentStation_index = 2;
                break;
            case "Ayala":
                currentStation_index = 3;
                break;
            case "Buendia":
                currentStation_index = 4;
                break;
            case "Guadalupe":
                currentStation_index = 5;
                break;
            case "Boni":
                currentStation_index = 6;
                break;
            case "Shaw":
                currentStation_index = 7;
                break;
            case "Ortigas":
                currentStation_index = 8;
                break;
            case "Santolan":
                currentStation_index = 9;
                break;
            case "Cubao":
                currentStation_index = 10;
                break;
            case "Quezon Avenue":
                currentStation_index = 11;
                break;
        }
        switch (base2) {
            case "Taft Avenue":
                detinationStation_index = 1;
                break;
            case "Magallanes":
                detinationStation_index = 2;
                break;
            case "Ayala":
                detinationStation_index = 3;
                break;
            case "Buendia":
                detinationStation_index = 4;
                break;
            case "Guadalupe":
                detinationStation_index = 5;
                break;
            case "Boni":
                detinationStation_index = 6;
                break;
            case "Shaw":
                detinationStation_index = 7;
                break;
            case "Ortigas":
                detinationStation_index = 8;
                break;
            case "Santolan":
                detinationStation_index = 9;
                break;
            case "Cubao":
                detinationStation_index = 10;
                break;
            case "Quezon Avenue":
                detinationStation_index = 11;
                break;
        }
        int difference = (detinationStation_index - currentStation_index);

        //Price = 50 + ((index of dest -index of start)*5)
        if (difference < 0) {
            difference = difference * -1;
            int price = 50 + (5 * difference);
            Price.setText(String.valueOf(price) + " PHP");
        }
        else {
            int price = 50 + (5*difference);
            Price.setText(String.valueOf(price) + " PHP");
        }
    }
    @FXML
    private void initialize(){
        currentStation.setItems(currentStationList);
        destinationStationBox.setItems(destinationStationList);
    }


}