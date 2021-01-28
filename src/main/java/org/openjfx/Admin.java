package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Admin {
    @FXML
    private void LogOut() throws IOException {
        App.setRoot("LogIn");
    }

    @FXML
    private void OpenLoad() throws IOException {

    }
}
