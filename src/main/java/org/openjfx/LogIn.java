package org.openjfx;


import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
        boolean grantAccess = false;
        String User = Username.getText();
        String Pass = Password.getText();
        String path = System.getProperty("user.dir") + "\\src\\Users.txt";

        try {
            Scanner read = new Scanner(new File(path));
            int noOfLines=0; // count how many lines in the file
            while(read.hasNextLine()){
                noOfLines++;
            }

            //loop through every line in the file and check against the user name & password (as I noticed you saved inputs in pairs of lines)
            for(int i=0; i<noOfLines; i++){
                if(read.nextLine().equals(User)){ // if the same user name
                    i++;
                    if(read.nextLine().equals(Pass)){ // check password
                        grantAccess = true; // if also same, change boolean to true
                        break; // and break the for-loop
                }
            }
        }
            if(grantAccess){
                App.setRoot("MainMenu");
            }
            else{
                LogInPrompt.setText("Invalid!");
            }

            read.close();
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    @FXML
    private void Register() throws IOException {
        App.setRoot("Register");
    }
}

