package org.openjfx;

import java.io.IOException;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import java.io.File;

import java.util.Random;

public class BusScreen {
    @FXML
    Rectangle box1, box2, box3, box4, box5, box6, box7, box8, box9, box10;
    @FXML
    Rectangle box11, box12, box13, box14, box15, box16, box17, box18, box19, box20;
    @FXML
    Rectangle box21, box22, box23, box24, box25, box26, box27, box28, box29, box30;
    @FXML
    Rectangle box31, box32, box33, box34, box35, box36, box37, box38, box39, box40;
    @FXML
    Rectangle box41, box42, box43, box44, box45, box46, box47, box48;
    @FXML
    Button PrevButton, NextButton,SelectQRButton;
    @FXML
    Label CurrentStationLabel, arrival;


    int[] array = new int[48];
    Random rn = new Random();
    Queue<Rectangle> q = new LinkedList<>();
    int present_point,base;
    String[] Stations = {"Taft Avenue","Magallanes","Ayala","Buendia","Guadalupe","Boni","Shaw","Ortigas","Santolan","Cubao","Quezon Avenue"};
    int index;

    public void setPresent_point(int present_point){
        this.present_point=present_point;
    }
    public void setBase(int base){
        this.base=base;
    }
    @FXML
    private void Back() throws IOException {
        App.setRoot("MainMenu");
    }
    public void SelectQR() {
        File file;
        String path;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        file = fileChooser.showOpenDialog(null);
        path = file.getName();
        System.out.println(path);
        switch (path){
            case "Taft Avenue.png":

                index=0;
                break;
            case "Magallanes.png":

                index=1;
                break;
            case "Ayala.png":

                index=2;
                break;
            case "Buendia.png":

                index=3;
                break;
            case "Guadalupe.png":

                index=4;
                break;
            case "Boni.png":

                index=5;
                break;
            case "Shaw.png":

                index=6;
                break;
            case "Ortigas.png":

                index=7;
                break;
            case "Santolan.png":

                index=8;
                break;
            case "Cubao.png":

                index=9;
                break;
            case "Quezon Avenue.png":
                index=10;
                break;
        }
        CurrentStationLabel.setText(Stations[index]);
        ScanQR();
    }
    public void PreviousStation(){
        if (index < 0){
            index++;
            CurrentStationLabel.setText("No Previous Station");
        }
        else if (base == index ){
            CurrentStationLabel.setText(Stations[index]);
            arrival.setText("Arrived in destination, exit bus");

        }
        else {
            CurrentStationLabel.setText(Stations[index--]);
            ScanQR();
        }
    }

    public void NextStation(){
        if (index > 10){
            index--;
            CurrentStationLabel.setText("No Next Station");
        }
        else if (present_point == index ){
            CurrentStationLabel.setText(Stations[index]);
            arrival.setText("Arrived in destination");

        }
        else {
            CurrentStationLabel.setText(Stations[index++]);
            ScanQR();
        }
    }
    public void ScanQR(){
        int i, j, k, min, minIndex;

        for(k = 0; k < 48; k++) {
            array[k] = rn.nextInt(4);
        }

        for(i = 0; i < (48-1); i++)
        {
            min = array[i];    // current min
            minIndex = i;	  // index of min
            for(j = i+1;j < 48; j++)
            {
                if(min > array[j])
                {
                    min = array[j];  // update min
                    minIndex = j;	// index of min
                }
            }
            // swap min and first element of the array
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex]=temp;
        }


        if(array[0] == 1){
            box1.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[0] == 2){
            box1.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[0] == 3){
            box1.setFill(Paint.valueOf("d34545"));
        }
        else{
            box1.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[1] == 1){
            box2.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[1] == 2){
            box2.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[1] == 3){
            box2.setFill(Paint.valueOf("d34545"));
        }
        else{
            box2.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[2] == 1){
            box3.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[2] == 2){
            box3.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[2] == 3){
            box3.setFill(Paint.valueOf("d34545"));
        }
        else{
            box3.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[3] == 1){
            box4.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[3] == 2){
            box4.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[3] == 3){
            box4.setFill(Paint.valueOf("d34545"));
        }
        else{
            box4.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[4] == 1){
            box5.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[4] == 2){
            box5.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[4] == 3){
            box5.setFill(Paint.valueOf("d34545"));
        }
        else{
            box5.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[5] == 1){
            box6.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[5] == 2){
            box6.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[5] == 3){
            box6.setFill(Paint.valueOf("d34545"));
        }
        else{
            box6.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[6] == 1){
            box7.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[6] == 2){
            box7.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[6] == 3){
            box7.setFill(Paint.valueOf("d34545"));
        }
        else{
            box7.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[7] == 1){
            box8.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[7] == 2){
            box8.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[7] == 3){
            box8.setFill(Paint.valueOf("d34545"));
        }
        else{
            box8.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[8] == 1){
            box9.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[8] == 2){
            box9.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[8] == 3){
            box9.setFill(Paint.valueOf("d34545"));
        }
        else{
            box9.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[9] == 1){
            box10.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[9] == 2){
            box10.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[9] == 3){
            box10.setFill(Paint.valueOf("d34545"));
        }
        else{
            box10.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[10] == 1){
            box11.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[10] == 2){
            box11.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[10] == 3){
            box11.setFill(Paint.valueOf("d34545"));
        }
        else{
            box11.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[11] == 1){
            box12.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[11] == 2){
            box12.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[11] == 3){
            box12.setFill(Paint.valueOf("d34545"));
        }
        else{
            box12.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[12] == 1){
            box13.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[12] == 2){
            box13.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[12] == 3){
            box13.setFill(Paint.valueOf("d34545"));
        }
        else{
            box13.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[13] == 1){
            box14.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[13] == 2){
            box14.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[13] == 3){
            box14.setFill(Paint.valueOf("d34545"));
        }
        else{
            box14.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[14] == 1){
            box15.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[14] == 2){
            box15.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[14] == 3){
            box15.setFill(Paint.valueOf("d34545"));
        }
        else{
            box15.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[15] == 1){
            box16.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[15] == 2){
            box16.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[15] == 3){
            box16.setFill(Paint.valueOf("d34545"));
        }
        else{
            box16.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[16] == 1){
            box17.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[16] == 2){
            box17.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[16] == 3){
            box17.setFill(Paint.valueOf("d34545"));
        }
        else{
            box17.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[17] == 1){
            box18.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[17] == 2){
            box18.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[17] == 3){
            box18.setFill(Paint.valueOf("d34545"));
        }
        else{
            box18.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[18] == 1){
            box19.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[18] == 2){
            box19.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[18] == 3){
            box19.setFill(Paint.valueOf("d34545"));
        }
        else{
            box19.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[19] == 1){
            box20.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[19] == 2){
            box20.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[19] == 3){
            box20.setFill(Paint.valueOf("d34545"));
        }
        else{
            box20.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[20] == 1){
            box21.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[20] == 2){
            box21.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[20] == 3){
            box21.setFill(Paint.valueOf("d34545"));
        }
        else{
            box21.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[21] == 1){
            box22.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[21] == 2){
            box22.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[21] == 3){
            box22.setFill(Paint.valueOf("d34545"));
        }
        else{
            box22.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[22] == 1){
            box23.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[22] == 2){
            box23.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[22] == 3){
            box23.setFill(Paint.valueOf("d34545"));
        }
        else{
            box23.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[23] == 1){
            box24.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[23] == 2){
            box24.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[23] == 3){
            box24.setFill(Paint.valueOf("d34545"));
        }
        else{
            box24.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[24] == 1){
            box25.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[24] == 2){
            box25.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[24] == 3){
            box25.setFill(Paint.valueOf("d34545"));
        }
        else{
            box25.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[25] == 1){
            box26.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[25] == 2){
            box26.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[25] == 3){
            box26.setFill(Paint.valueOf("d34545"));
        }
        else{
            box26.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[26] == 1){
            box27.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[26] == 2){
            box27.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[26] == 3){
            box27.setFill(Paint.valueOf("d34545"));
        }
        else{
            box27.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[27] == 1){
            box28.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[27] == 2){
            box28.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[27] == 3){
            box28.setFill(Paint.valueOf("d34545"));
        }
        else{
            box28.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[28] == 1){
            box29.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[28] == 2){
            box29.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[28] == 3){
            box29.setFill(Paint.valueOf("d34545"));
        }
        else{
            box29.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[29] == 1){
            box30.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[29] == 2){
            box30.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[29] == 3){
            box30.setFill(Paint.valueOf("d34545"));
        }
        else{
            box30.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[30] == 1){
            box31.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[30] == 2){
            box31.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[30] == 3){
            box31.setFill(Paint.valueOf("d34545"));
        }
        else{
            box31.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[31] == 1){
            box32.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[31] == 2){
            box32.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[31] == 3){
            box32.setFill(Paint.valueOf("d34545"));
        }
        else{
            box32.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[32] == 1){
            box33.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[32] == 2){
            box33.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[32] == 3){
            box33.setFill(Paint.valueOf("d34545"));
        }
        else{
            box33.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[33] == 1){
            box34.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[33] == 2){
            box34.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[33] == 3){
            box34.setFill(Paint.valueOf("d34545"));
        }
        else{
            box34.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[34] == 1){
            box35.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[34] == 2){
            box35.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[34] == 3){
            box35.setFill(Paint.valueOf("d34545"));
        }
        else{
            box35.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[35] == 1){
            box36.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[35] == 2){
            box36.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[35] == 3){
            box36.setFill(Paint.valueOf("d34545"));
        }
        else{
            box36.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[36] == 1){
            box37.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[36] == 2){
            box37.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[36] == 3){
            box37.setFill(Paint.valueOf("d34545"));
        }
        else{
            box37.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[37] == 1){
            box38.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[37] == 2){
            box38.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[37] == 3){
            box38.setFill(Paint.valueOf("d34545"));
        }
        else{
            box38.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[38] == 1){
            box39.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[37] == 2){
            box39.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[37] == 3){
            box39.setFill(Paint.valueOf("d34545"));
        }
        else{
            box39.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[39] == 1){
            box40.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[39] == 2){
            box40.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[39] == 3){
            box40.setFill(Paint.valueOf("d34545"));
        }
        else{
            box40.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[40] == 1){
            box41.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[40] == 2){
            box41.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[40] == 3){
            box41.setFill(Paint.valueOf("d34545"));
        }
        else{
            box41.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[41] == 1){
            box42.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[41] == 2){
            box42.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[41] == 3){
            box42.setFill(Paint.valueOf("d34545"));
        }
        else{
            box42.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[42] == 1){
            box43.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[42] == 2){
            box43.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[42] == 3){
            box43.setFill(Paint.valueOf("d34545"));
        }
        else{
            box43.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[43] == 1){
            box44.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[43] == 2){
            box44.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[43] == 3){
            box44.setFill(Paint.valueOf("d34545"));
        }
        else{
            box44.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[44] == 1){
            box45.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[44] == 2){
            box45.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[44] == 3){
            box45.setFill(Paint.valueOf("d34545"));
        }
        else{
            box45.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[45] == 1){
            box46.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[45] == 2){
            box46.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[45] == 3){
            box46.setFill(Paint.valueOf("d34545"));
        }
        else{
            box46.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[46] == 1){
            box47.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[46] == 2){
            box47.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[46] == 3){
            box47.setFill(Paint.valueOf("d34545"));
        }
        else{
            box47.setFill(Paint.valueOf("5bae4c"));
        }

        if(array[47] == 1){
            box48.setFill(Paint.valueOf("5bae4c"));
        }
        else if(array[47] == 2){
            box48.setFill(Paint.valueOf("ffcb30"));
        }
        else if(array[47] == 3){
            box48.setFill(Paint.valueOf("d34545"));
        }
        else{
            box48.setFill(Paint.valueOf("5bae4c"));
        }

    }

}
