package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class RouteMenu {
    @FXML
    Rectangle BlueLine, GreenLine, PinkLine;

    @FXML
    private void BackM() throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void fillForm() throws IOException {
        App.setRoot("SafeForm");
    }

    @FXML
    private void HelpM() throws IOException{
        App.setRoot("HelpMenu");
    }

    @FXML
    private void ViewCredit() throws IOException{
        App.setRoot("UserDetails");
    }

    @FXML
    private void BlueShow() throws IOException{
        BlueLine.setOpacity(.30);
    }

    @FXML
    private void BlueClose() throws IOException{
        BlueLine.setOpacity(0);
    }

    @FXML
    private void GreenShow() throws IOException{
        GreenLine.setOpacity(.30);
    }

    @FXML
    private void GreenClose() throws IOException{
        GreenLine.setOpacity(0);
    }

    @FXML
    private void PinkShow() throws IOException{
        PinkLine.setOpacity(.30);
    }

    @FXML
    private void PinkClose() throws IOException{
        PinkLine.setOpacity(0);
    }

    @FXML
    private void BlueLine()throws IOException{
        App.setRoot("BoardBusBlue");
    }

    @FXML
    private void GreenLine()throws IOException{
        App.setRoot("BoardBusGreen");
    }

    @FXML
    private void PinkLine()throws IOException{
        App.setRoot("BoardBusPink");
    }
}
