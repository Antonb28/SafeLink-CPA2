package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
    @FXML
    TextArea Output;

    @FXML
    private void LogOut() throws IOException {
        App.setRoot("LogIn");
    }

    @FXML
    private void OpenTravelHistory() {
        String path =System.getProperty("user.dir") + "\\src\\TravelHistory.txt";
        DisplayText(path);
    }

    @FXML
    private void OpenLoad(){
        String path = System.getProperty("user.dir") + "\\src\\Credit.txt";
        DisplayCredit(path);
    }

    @FXML
    private void OpenTransactions(){
        String path = System.getProperty("user.dir") + "\\src\\CreditCards.txt";
        DisplayText(path);
    }

    @FXML
    private void OpenSafetyForm(){
        String path = System.getProperty("user.dir") + "\\src\\SafeForm.txt";
        DisplayText(path);
    }

    @FXML
    private void Clear(){
        Output.clear();
    }

    private void DisplayCredit(String path) {
        try{
            Scanner s = new Scanner(new File(path)).useDelimiter("\\s+");
            while (s.hasNext()) {
                if (s.hasNextInt()) { // check if next token is an int
                    Output.appendText(s.nextInt() + "\n"); // display the found integer
                } else {
                    Output.appendText(s.next() + "\n"); // else read the next token
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    private void DisplayText(String path) {
        try{
            Scanner s = new Scanner(new File(path)).useDelimiter("");
            while (s.hasNext()) {
                if (s.hasNextInt()) { // check if next token is an int
                    Output.appendText(s.nextInt() + ""); // display the found integer
                } else {
                    Output.appendText(s.next() + ""); // else read the next token
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
