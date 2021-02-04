package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.*;
import java.util.Optional;

public class Register {
    @FXML
    TextField Username, Password, Password1, FirstName, LastName, Email, Age;

    @FXML
    Label LogInPrompt;

    @FXML
    RadioButton Male, Female;

    @FXML
    ToggleGroup RB;

    @FXML
    private void CreateAccount() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\Users.txt";
        String secondpath = System.getProperty("user.dir") + "\\src\\UserDetails.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(secondpath, true));
        Male.setToggleGroup(RB);
        Female.setToggleGroup(RB);

        if(LastName.getText() == null || LastName.getText().trim().isEmpty()){
            LogInPrompt.setText("Missing credential.");
        }

        else if(FirstName.getText() == null || FirstName.getText().trim().isEmpty()){
            LogInPrompt.setText("Missing credential.");
        }

        else if(Username.getText() == null || Username.getText().trim().isEmpty()){
            LogInPrompt.setText("Missing credential.");
        }

        else if(Password.getText() == null || Password.getText().trim().isEmpty()){
            LogInPrompt.setText("Missing credential.");
        }

        else if(Password1.getText() == null || Password1.getText().trim().isEmpty()){
            LogInPrompt.setText("Missing credential.");
        }

        else if(Email.getText() == null || Email.getText().trim().isEmpty()){
            LogInPrompt.setText("Missing credential.");
        }

        else if(Age.getText() == null || Age.getText().trim().isEmpty()){
            LogInPrompt.setText("Missing credential.");
        }

        else {
            try {
                if (Password.getText().equals(Password1.getText())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Are all credentials correct?");
                    alert.setContentText("Exit this dialog box to continue editing\nClick ok to confirm");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        bufferedWriter.write(Username.getText() + "," + Password.getText() + "\n");
                        bufferedWriter.close();
                        bufferedWriter1.write("First Name: " + FirstName.getText() + "\n");
                        bufferedWriter1.write("Last Name: " + LastName.getText() + "\n");
                        bufferedWriter1.write("Age: " + Age.getText() + "\n");
                        if (Male.isSelected()) {
                            bufferedWriter1.write("Sex: " + "Male" + "\n");
                        }
                        if (Female.isSelected()) {
                            bufferedWriter1.write("Sex: " + "Female" + "\n");
                        }
                        bufferedWriter1.write("Email: " + Email.getText() + "\n");
                        bufferedWriter1.close();

                    }
                }
                else {
                    LogInPrompt.setText("Passwords do not match.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        FirstName.clear();
        LastName.clear();
        Email.clear();
        Age.clear();
        LogInPrompt.setText("");
    }

}
