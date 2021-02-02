package org.openjfx;


import java.io.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogIn{
    @FXML
    TextField Username;

    @FXML
    PasswordField Password;

    @FXML
    Label LogInPrompt;

    @FXML
    private void LogIn() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\Users.txt";
        BufferedReader br = null;
        if(Username.getText().equals("Admin") && Password.getText().equals("Admin")){
            App.setRoot("Admin");
        }

        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (br != null) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] splitted = st.split(",");
                if (Username.getText().equals(splitted[0]) && Password.getText().equals(splitted[1])) {
                    App.setRoot("MainMenu");
                    break;
                }
                else {
                    LogInPrompt.setText("Incorrect username/password");
                }
            }
        }
    }

    @FXML
    private void Register() throws IOException {
        App.setRoot("Register");
    }
}