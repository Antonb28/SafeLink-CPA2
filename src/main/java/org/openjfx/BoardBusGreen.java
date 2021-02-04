package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.time.LocalDate;
import java.io.*;

public class BoardBusGreen {
    ObservableList<String> currentStationList = FXCollections.observableArrayList("Taft Avenue","Vito Cruz","Gil Puyat","Quirino","Aurora","E. Rodriguez","Quezon Avenue","Balintawak");
    ObservableList<String> destinationStationList = FXCollections.observableArrayList("Taft Avenue","Vito Cruz","Gil Puyat","Quirino","Aurora","E. Rodriguez","Quezon Avenue","Balintawak");

    @FXML
    Label Destination, Station, Price, RemainingCredit, Message, QueueNumber, Time, Date;

    @FXML
    ChoiceBox currentStation, destinationStationBox;

    @FXML
    Button confirm, ConfirmButton, RideBus;

    int count = 0;
    Random rn = new Random();
    int queuenum = rn.nextInt(50);
    Queue<Integer> pq = new LinkedList<>();

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
        App.setRoot("UserDetails");
    }


    @FXML
    private void updateLabels() throws IOException {
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
            case "Vito Cruz":
                currentStation_index = 2;
                break;
            case "Gil Puyat":
                currentStation_index = 3;
                break;
            case "Quirino":
                currentStation_index = 4;
                break;
            case "Aurora":
                currentStation_index = 5;
                break;
            case "E. Rodriguez":
                currentStation_index = 6;
                break;
            case "Quezon Avenue":
                currentStation_index = 7;
                break;
            case "Balintawak":
                currentStation_index = 8;
                break;

        }
        switch (base2) {
            case "Ayala":
                detinationStation_index = 1;
                break;
            case "Vito Cruz":
                detinationStation_index = 2;
                break;
            case "Gil Puyat":
                detinationStation_index = 3;
                break;
            case "Quirino":
                detinationStation_index = 4;
                break;
            case "Aurora":
                detinationStation_index = 5;
                break;
            case "E. Rodriguez":
                detinationStation_index = 6;
                break;
            case "Quezon Avenue":
                detinationStation_index = 7;
                break;
            case "Balintawak":
                detinationStation_index = 8;
                break;

        }
        int difference = (detinationStation_index - currentStation_index);

        //Price = 50 + ((index of dest -index of start)*5)
        if (difference < 0) {
            difference = difference * -1;
            int price = 50 + (5 * difference);
            Price.setText(String.valueOf(price));
        }
        else {
            int price = 50 + (5*difference);
            Price.setText(String.valueOf(price));
        }
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //file writing start
        String path = System.getProperty("user.dir") + "\\src\\TravelHistory.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        try {
            bufferedWriter.write("\nStarting Point: " + currentStation.getValue() + " \nDestination: " + destinationStationBox.getValue()+" \nDate and time: "+ date + " " + dtf.format(now) +"\n");
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Date.setText(String.valueOf(date));
        Time.setText(dtf.format(now));
        ConfirmButton.setDisable(false);
    }

    public void ReadFromLast() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\Credit.txt";
        String path2 = System.getProperty("user.dir") + "\\src\\TravelHistory.txt";
        FileInputStream in = new FileInputStream(path);
        FileWriter fileWriter = new FileWriter(path, true);
        FileWriter fileWriter2 = new FileWriter(path2, true);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine = null, tmp;
        while ((tmp = br.readLine()) != null) {
            strLine = tmp;
        }
        String credit = strLine;
        String price = Price.getText();
        int realcredit = Integer.parseInt(credit);
        int realprice;
        realprice = Integer.parseInt(price);
        int realchange = realcredit - realprice;

        if (realcredit>=realprice){
            RemainingCredit.setText(String.valueOf(realchange));
            String change = RemainingCredit.getText();
            fileWriter2.write("Remaining Credit: " +change+ "\n" + "Price of Trip: " +realprice+ "\n");
            fileWriter2.close();

            fileWriter.write(change+"\n");
            fileWriter.close();

        }

        else if(realcredit < realprice){
            Message.setText("Insufficent Funds!");
        }

        in.close();
        RideBus.setDisable(false);
    }

    @FXML
    private void initialize(){
        currentStation.setItems(currentStationList);
        destinationStationBox.setItems(destinationStationList);
    }

    @FXML
    private void RideBus() throws IOException {
        if(count == 0) {
            for (int i = queuenum; i > 0; i--) {
                pq.add(i);
            }
            count++;
        }
        else if(pq.isEmpty()){
            App.setRoot("OnBusScreenGreen");
        }
        else{
            QueueNumber.setText(String.valueOf(pq.peek()));
            pq.remove();
        }
    }
}