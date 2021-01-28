package org.openjfx;
import java.io.*;
import java.net.PasswordAuthentication;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;


public class CreditLoading {
    int i, j, intcred;
    @FXML
    public TextField FirstNameTextField, LastNameTextField, DateTextField, CardNumTextField, Credit;

    @FXML
    public Label Cr;

    @FXML
    public Button ConfirmButton;

    @FXML
    public PasswordField CVVTextField;

    private static final String newLine = System.getProperty("line.separator");


    @FXML
    private void TakePayment() {
        String CardNum = CardNumTextField.getText();
        String creditcardnum = (String.valueOf(CardNum));
        String CVV = CVVTextField.getText();
        String cvv = (String.valueOf(CVV));
        String ExpiryDate = DateTextField.getText();
        String date = (String.valueOf(ExpiryDate));
        String FirstName = FirstNameTextField.getText();
        String FN = (String.valueOf(FirstName));
        String LastName = LastNameTextField.getText();
        String LN = (String.valueOf(LastName));


        String path = System.getProperty("user.dir") + "\\src\\CreditCards.txt";

        try {
            i+=1;
            FileWriter fw = new FileWriter(path, true);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are all credentials correct?");
            alert.setContentText("Exit this dialog box to continue editing\nClick ok to confirm");
            Optional<ButtonType> result = alert.showAndWait();

            if (creditcardnum.length() == 16 && cvv.length() == 3 && date.length() == 5) {
                if (result.get() == ButtonType.OK) {
                    fw.write(newLine + i + ". "+"First Name:" + FN + "|Last Name:" + LN + "|Credit Card Number:" + creditcardnum + "|CVV:" + cvv + "|Expiry Date:" + date);
                    fw.close();
                    ConfirmButton.setDisable(false);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    private void ViewCredit() {
        String secondpath = System.getProperty("user.dir") + "\\src\\credit.txt";
        String cred = Credit.getText();
        intcred += Integer.parseInt(cred);
        Cr.setText(String.valueOf(intcred));

        try {
            j+=1;
            FileWriter fw = new FileWriter(secondpath, true);
            fw.write(newLine + j + ". " + "Credit: " + intcred);
            fw.close();
        }

        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @FXML
    private void Clear(){
        FirstNameTextField.clear();
        LastNameTextField.clear();
        DateTextField.clear();
        CardNumTextField.clear();
        Credit.clear();
        CVVTextField.clear();
        Cr.setText("--------");
    }

    @FXML
    private void Back() throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void Help() throws IOException{
        App.setRoot("HelpMenu");
    }

    @FXML
    private void fillForm() throws IOException{
        App.setRoot("HelpMenu");
    }


}


