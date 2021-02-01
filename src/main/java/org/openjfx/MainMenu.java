package org.openjfx;

import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainMenu {
    @FXML
    Label GreetingPrompt, credit;
    @FXML
    Rectangle FClick,TClick, printClick;
    @FXML
    ImageView About;
    @FXML
    ImageView Safety;
    @FXML
    ImageView Credit;
    @FXML
    Button ViewC;


    public static Stage parentWindow;

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
    private void ViewCredit() throws IOException{
        App.setRoot("UserDetails");
    }


    @FXML
    private void Transportation() throws IOException{
        App.setRoot("BoardBus");
    }

    @FXML
    private void Food() throws IOException{
        App.setRoot("Credit");
    }

    @FXML
    private void Print() throws IOException{
        App.setRoot("Routes");
    }

    @FXML
    private void User() throws IOException{
        App.setRoot("UserDetails");
    }

    @FXML
    private void FoodDetect() throws IOException{
        FClick.setOpacity(.30);
    }

    @FXML
    private void FoodExit() throws IOException{
        FClick.setOpacity(0);
    }

    @FXML
    private void TransDetect() throws IOException{
        TClick.setOpacity(.30);
    }

    @FXML
    private void TransExit() throws IOException{
        TClick.setOpacity(0);
    }

    @FXML
    private void PrintDetect() throws IOException{
        printClick.setOpacity(.30);
    }

    @FXML
    private void PrintExit() throws IOException{
        printClick.setOpacity(0);
    }

    @FXML
    private void AboutDetect() throws IOException{
        About.setOpacity(0);
    }

    @FXML
    private void AboutExit() throws IOException{
        About.setOpacity(100);
    }

    @FXML
    private void SafetyDetect() throws IOException{
        Safety.setOpacity(0);
    }

    @FXML
    private void SafetyExit() throws IOException{
        Safety.setOpacity(100);
    }

    @FXML
    private void CreditDetect() throws IOException{
        Credit.setOpacity(0);
    }

    @FXML
    private void CreditExit() throws IOException{
        Credit.setOpacity(100);
    }

}
