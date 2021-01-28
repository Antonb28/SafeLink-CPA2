package org.openjfx;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LogIn{

    @FXML
    TextField Username;
    @FXML
    PasswordField Password;
    @FXML
    Label LogInPrompt;

    @FXML
    private void LogIn() throws IOException {
        User us = new User();

        String User, Pass;
        int action;
        User = Username.getText();
        Pass = Password.getText();

        action = us.CheckUser(User,Pass);

        if((action == 2)||(action == 3)||(action == 4)){
            App.setRoot("MainMenu");
        }
        else if(action == 0){
            LogInPrompt.setText("Wrong Password, Try Again");
        }
        else if(action == 1){
            LogInPrompt.setText("User does not exist, Try Again");
        }
        else if(action == 100){
            App.setRoot("Admin");
        }
    }


    @FXML
    private void Register() throws IOException {
        App.setRoot("Register");
    }
}

