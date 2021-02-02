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
        readFile();
    }

    @FXML
    private void Reset() {
        Username.clear();
        Password.clear();
        Password1.clear();
        LogInPrompt.setText("");
    }

    void readFile() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\Users.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

        try {
            if(Password.getText().equals(Password1.getText())){
                bufferedWriter.write(Username.getText());
                bufferedWriter.newLine();
                bufferedWriter.write(Password.getText());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            else {
                LogInPrompt.setText("Passwords do not match!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
