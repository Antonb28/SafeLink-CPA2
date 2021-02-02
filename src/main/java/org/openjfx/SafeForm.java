package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;

public class SafeForm {
    private static final String newLine = System.getProperty("line.separator");
    String path = System.getProperty("user.dir") + "\\src\\SafeForm.txt";
    FileWriter fw = new FileWriter(path, true);

    @FXML
    RadioButton YesButton1;

    @FXML
    Label Message;

    @FXML
    ToggleGroup RD1;

    @FXML
    ToggleGroup RD2;

    @FXML
    ToggleGroup RD3;

    @FXML
    ToggleGroup RD4;

    @FXML
    RadioButton NoButton1;

    @FXML
    RadioButton YesButton2;

    @FXML
    RadioButton NoButton2;

    @FXML
    RadioButton YesButton3;

    @FXML
    RadioButton NoButton3;

    @FXML
    RadioButton YesButton4;

    @FXML
    RadioButton NoButton4;

    public SafeForm() throws IOException {
    }

    public void UserDetails() throws IOException {
        App.setRoot("UserDetails");
    }

    public void Help() throws IOException {
        App.setRoot("HelpMenu");
    }

    public void LogOut() throws IOException {
        App.setRoot("LogIn");
    }

    public void Back() throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void TakeAnswers() throws IOException {
        YesButton1.setToggleGroup(RD1);
        NoButton1.setToggleGroup(RD1);

        YesButton2.setToggleGroup(RD2);
        NoButton2.setToggleGroup(RD2);

        YesButton3.setToggleGroup(RD3);
        NoButton3.setToggleGroup(RD3);

        YesButton4.setToggleGroup(RD4);
        NoButton4.setToggleGroup(RD4);

        if(YesButton1.isSelected()) {
            Yes();
        }

        if(NoButton1.isSelected()){
            No();
        }

        if(YesButton2.isSelected()){
            Yes2();

        }

        if(NoButton2.isSelected()){
            No2();
        }

        if(YesButton3.isSelected()){
            Yes3();
        }

        if(NoButton3.isSelected()){
            No3();
        }

        if(YesButton4.isSelected()){
            Yes4();
        }

        if(NoButton4.isSelected()){
            No4();
        }

        Message.setText("Successfully filled up form!");
        Close();
        Clear();
    }

    private void Yes(){
        try {
            fw.write("1. Have you been experiencing any symptoms of covid-19 in the last 14 days?: "+"Yes" + "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void No(){
        try {
            fw.write("1. Have you been experiencing any symptoms of covid-19 in the last 14 days?: "+"No" + "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void Yes2(){
        try {
            fw.write("2. Are you vaccinated?: "+"Yes" + "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void No2(){
        try {
            fw.write("2. Are you vaccinated?: "+"No" + "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    private void Yes3(){
        try {
            fw.write("3. Have you traveled to any areas that have confirmed cases in the last 14 days?: "+"Yes" + "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    private void No3(){
        try {
            fw.write("3. Have you traveled to any areas that have confirmed cases in the last 14 days?: "+"No" + "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    private void Yes4(){
        try {
            fw.write("4. Is it your first time travelling today?: "+"Yes" + "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    private void No4(){
        try {
            fw.write("4. Is it your first time travelling today?: "+"No"+ "\n");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void Close() throws IOException{
        fw.flush();
    }

    @FXML
    private void Clear(){
        YesButton1.setSelected(false);
        NoButton1.setSelected(false);
        YesButton2.setSelected(false);
        NoButton2.setSelected(false);
        YesButton3.setSelected(false);
        NoButton3.setSelected(false);
        YesButton4.setSelected(false);
        NoButton4.setSelected(false);
    }

}