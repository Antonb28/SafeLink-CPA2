package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class BoardBus {
    ObservableList<String> currentStationList = FXCollections.observableArrayList("Taft Avenue","Magallanes","Ayala","Buendia","Guadalupe","Boni","Shaw","Ortigas","Santolan","Cubao","Quezon Avenue");
    ObservableList<String> destinationStationList = FXCollections.observableArrayList("Taft Avenue","Magallanes","Ayala","Buendia","Guadalupe","Boni","Shaw","Ortigas","Santolan","Cubao","Quezon Avenue");

    @FXML
    Label Destination, Station, Price, RemainingCredit, QueueLabel;

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

        BoardBus boardBus = new BoardBus();
        String secondpath = System.getProperty("user.dir") + "\\src\\credit.txt";
        boardBus.ReadFromLast(secondpath);

    }

    public void ReadFromLast(String secondpath){
        int lines = 0;
        StringBuilder stringBuilder = new StringBuilder();
        RandomAccessFile randomAccessFile= null;
        try {
            randomAccessFile = new RandomAccessFile(secondpath, "r");
            long fileLength = secondpath.length() - 1;
            // Set the pointer at the last of the file
            randomAccessFile.seek(fileLength);
            for(long pointer = fileLength; pointer >= 0; pointer--){
                randomAccessFile.seek(pointer);
                char c;
                // read from the last one char at the time
                c = (char)randomAccessFile.read();
                // break when end of the line
                if(c == '\n'){
                    break;
                }
                stringBuilder.append(c);
            }
            // Since line is read from the last so it
            // is in reverse so use reverse method to make it right
            stringBuilder.reverse();
            System.out.println("Line - " + stringBuilder.toString());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void initialize(){
        currentStation.setItems(currentStationList);
        destinationStationBox.setItems(destinationStationList);
    }


    @FXML
    private void RideBus() throws IOException {
        int random = (int) Math.random()*(20-1+1)+1;
        int temp = random;
        int count = 0;
        int i;
        MyQueue myQueue = new MyQueue(20);

        if(count == 0){
           for (i = 0; i==random; i++){
               myQueue.push(i);
            }
           count++;
        }

        else if ((int) myQueue.front()==temp){
            myQueue.pop();
        }

        else {
            App.setRoot("OnBusScreen");
        }
        temp--;
        QueueLabel.setText(String.valueOf(temp));

    }
}