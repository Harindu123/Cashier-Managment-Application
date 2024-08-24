package com.example.hr_fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label label11, label12,label21,label22,label23,label31, label32, label33, label34, label35, label1,
            label2, label3, label4, label5, label6, label7, label8, name, burgs;

    @FXML
    private TextField searchField;

    String[] temp1 = new String[15];
    Integer[] temp2 = new Integer[15];
    void set(){
        if (FoodQueue.cashier1[0].equals("Available")){
            label11.setText("X");
        } else {
            label11.setText("O");
        }
        if (FoodQueue.cashier1[1].equals("Available")){
            label12.setText("X");
        } else {
            label12.setText("O");
        }

        if (FoodQueue.cashier2[0].equals("Available")){
            label21.setText("X");
        } else {
            label21.setText("O");
        }
        if (FoodQueue.cashier2[1].equals("Available")){
            label22.setText("X");
        } else {
            label22.setText("O");
        }
        if (FoodQueue.cashier2[2].equals("Available")){
            label23.setText("X");
        } else {
            label23.setText("O");
        }

        if (FoodQueue.cashier3[0].equals("Available")){
            label31.setText("X");
        } else {
            label31.setText("O");
        }
        if (FoodQueue.cashier3[1].equals("Available")){
            label32.setText("X");
        } else {
            label32.setText("O");
        }
        if (FoodQueue.cashier3[2].equals("Available")){
            label33.setText("X");
        } else {
            label33.setText("O");
        }
        if (FoodQueue.cashier3[3].equals("Available")){
            label34.setText("X");
        } else {
            label34.setText("O");
        }
        if (FoodQueue.cashier3[4].equals("Available")){
            label35.setText("X");
        } else {
            label35.setText("O");
        }

        if (FoodQueue.waiting[0].equals("Available")){
            label1.setText("X");
        } else {
            label1.setText("O");
        }
        if (FoodQueue.waiting[1].equals("Available")){
            label2.setText("X");
        } else {
            label2.setText("O");
        }
        if (FoodQueue.waiting[2].equals("Available")){
            label3.setText("X");
        } else {
            label3.setText("O");
        }
        if (FoodQueue.waiting[3].equals("Available")){
            label4.setText("X");
        } else {
            label4.setText("O");
        }
        if (FoodQueue.waiting[4].equals("Available")){
            label5.setText("X");
        } else {
            label5.setText("O");
        }
        if (FoodQueue.waiting[5].equals("Available")){
            label6.setText("X");
        } else {
            label6.setText("O");
        }
        if (FoodQueue.waiting[6].equals("Available")){
            label7.setText("X");
        } else {
            label7.setText("O");
        }
        if (FoodQueue.waiting[7].equals("Available")){
            label8.setText("X");
        } else {
            label8.setText("O");
        }
    }
    @FXML
    public void initialize() {
        set();
    }

    @FXML
    private void search() {
        String query = searchField.getText();
        int index = searchNameInCashier1(query);
        if (index==99){
            name.setText("Not Found");
        } else {
            name.setText(temp1[index]);
            burgs.setText(String.valueOf(temp2[index]));
        }
    }
    private int searchNameInCashier1(String name) {
        int j=0;
        try {
            for (String i : FoodQueue.cashier1) {
                String[] queueValues = i.split(":");
                String n1 = queueValues[0];
                String n2 = queueValues[1];
                String fName = n1 + " " + n2;
                int cBurg = Integer.parseInt(queueValues[2]);
                temp1[j] = fName;
                temp2[j] = cBurg;
                j++;
            }
            for (String i : FoodQueue.cashier2) {
                String[] queueValues = i.split(":");
                String n1 = queueValues[0];
                String n2 = queueValues[1];
                String fName = n1 + " " + n2;
                int cBurg = Integer.parseInt(queueValues[2]);
                temp1[j] = fName;
                temp2[j] = cBurg;
                j++;
            }
            for (String i : FoodQueue.cashier3) {
                String[] queueValues = i.split(":");
                String n1 = queueValues[0];
                String n2 = queueValues[1];
                String fName = n1 + " " + n2;
                int cBurg = Integer.parseInt(queueValues[2]);
                temp1[j] = fName;
                temp2[j] = cBurg;
                j++;
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        int k = 0 ;
        for (String cashier : temp1) {
            if (cashier!=null){
                if (cashier.equalsIgnoreCase(name)) {
                    return k; // Name found in cashier1
                }
            }
            k++;
        }
        return 99; // Name not found in cashier1
    }
}