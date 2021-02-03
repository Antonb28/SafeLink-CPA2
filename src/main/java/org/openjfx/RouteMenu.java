package org.openjfx;

import javafx.fxml.FXML;

import java.io.IOException;

public class RouteMenu {
    @FXML
    private void Back() throws IOException {
        App.setRoot("MainMenu");
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
}
