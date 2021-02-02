package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class Register {
    @FXML
    TextField Username, Password, Password1;

    @FXML
    Label LogInPrompt;

    @FXML
    private void CreateAccount() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\Users.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        try {
            if(Password.getText().equals(Password1.getText())){
                bufferedWriter.write(Username.getText() + "," + Password.getText());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            else if(Username.getText().isBlank()|| Password.getText().isBlank() || Password1.getText().isBlank()){
                LogInPrompt.setText("Please input the missing data");
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
