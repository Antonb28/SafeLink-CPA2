package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class Register {
    @FXML
    TextField Username, Password, Password1, FirstName, LastName, Email, Age, Sex;

    @FXML
    Label LogInPrompt;

    @FXML
    private void CreateAccount() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\Users.txt";
        String secondpath = System.getProperty("user.dir") + "\\src\\UserDetails.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(secondpath, true));
        try {
            if(Password.getText().equals(Password1.getText())){
                bufferedWriter.write(Username.getText() + "," + Password.getText());
                bufferedWriter.newLine();
                bufferedWriter.close();
                bufferedWriter1.write(FirstName.getText() + "\n" + LastName.getText() + "\n" + Age.getText() + "\n" + Sex.getText() + "\n" + Email.getText() + "\n");
                bufferedWriter1.close();
            }
            else {
                LogInPrompt.setText("Passwords do not match!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void GoBack() throws IOException {
        App.setRoot("LogIn");
    }

    @FXML
    private void Reset() {
        Username.clear();
        Password.clear();
        Password1.clear();
        LogInPrompt.setText("");
    }



}
