package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserDetails {
    @FXML
    TextArea Output;

    @FXML
    private void Back() throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void LogOut() throws IOException {
        App.setRoot("LogIn");
    }

    @FXML
    private void fillForm() throws IOException {
        App.setRoot("SafeForm");
    }

    @FXML
    private void Help() throws IOException{
        App.setRoot("HelpMenu");
    }

    @FXML
    private void Clear(){
        Output.clear();
    }

    @FXML
    private void TransactionHistory(){
        String path = System.getProperty("user.dir") + "\\src\\Credit.txt";
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

    @FXML
    private void ShowDetails() {
        String path = System.getProperty("user.dir") + "\\src\\UserDetails.txt";
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
