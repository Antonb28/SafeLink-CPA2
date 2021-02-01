package org.openjfx;
import java.io.*;
import java.net.PasswordAuthentication;
import java.util.NoSuchElementException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;


public class CreditLoading {
    int i, intcred, getIntcred;
    @FXML
    public TextField FirstNameTextField, LastNameTextField, DateTextField, CardNumTextField, Credit;

    @FXML
    public Label Cr;

    @FXML
    public Button ConfirmButton;

    @FXML
    public PasswordField CVVTextField;

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
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    fw.write( i + ". "+"First Name:" + FN + "|Last Name:" + LN + "|Credit Card Number:" + creditcardnum + "|CVV:" + cvv + "|Expiry Date:" + date + "\n");
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
    private void ViewCredit() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\Credit.txt";
        FileInputStream in = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        FileWriter fw = new FileWriter(path, true);

        String strLine = null, tmp;
        while ((tmp = br.readLine()) != null) {
            strLine = tmp;
        }

        String Cred = Credit.getText();
        int creds = Integer.parseInt(Cred);
        getIntcred+=creds;
        Cr.setText(String.valueOf(getIntcred));
        fw.write(creds+"\n");
        fw.flush();

        try{
            String lastLine = strLine;
            intcred = creds + Integer.parseInt(lastLine);
            fw.write(intcred+"\n");
            fw.close();
        }
        catch (NumberFormatException e){
            System.out.println("NumberFormatException is handled");
        }
        in.close();
    }

    @FXML
    private void Clear(){
        FirstNameTextField.clear();
        LastNameTextField.clear();
        DateTextField.clear();
        CardNumTextField.clear();
        Credit.clear();
        CVVTextField.clear();
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

    @FXML
    private void UserDetails() throws IOException{
        App.setRoot("UserDetails");
    }


}


